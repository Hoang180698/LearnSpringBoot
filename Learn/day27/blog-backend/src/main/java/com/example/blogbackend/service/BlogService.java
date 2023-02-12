package com.example.blogbackend.service;

import com.example.blogbackend.entity.Blog;
import com.example.blogbackend.entity.Category;
import com.example.blogbackend.entity.User;
import com.example.blogbackend.exception.NotFoundException;
import com.example.blogbackend.repository.BlogRepository;
import com.example.blogbackend.repository.CategoryRepository;
import com.example.blogbackend.repository.CommentRepository;
import com.example.blogbackend.repository.UserRepository;
import com.example.blogbackend.request.UpsertBlogRequest;
import com.github.slugify.Slugify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private Slugify slugify;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CommentRepository commentRepository;

    public List<Blog> getAllBlog() {
        return blogRepository.findAll();
    }

    @Transactional
    public Blog createBlog(UpsertBlogRequest request) {
        // Validate thông tin (Nếu cần thiết) - validation

        // Tìm kiếm category
        Set<Category> categories = categoryRepository.findByIdIn(request.getCategoryIds());

        // TODO : sau này user chính là user đăng nhập (Hiện tại đang fix)
        Integer userId = 1;
        User user = userRepository.findById(userId).orElseThrow(() -> {
            throw new NotFoundException("Not found user with id = " + userId);
        });

        // Tạo Blog
        Blog blog = Blog.builder()
                .title(request.getTitle())
                .slug(slugify.slugify(request.getTitle()))
                .content(request.getContent())
                .description(request.getDescription())
                .thumbnail(request.getThumbnail())
                .status(request.getStatus())
                .categories(categories)
                .user(user)
                .build();

        return blogRepository.save(blog);
    }

    public Blog getBlogById(Integer id) {
        return blogRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found user with id = " + id);
        });
    }

    @Transactional
    public Blog updateBlog(Integer id, UpsertBlogRequest request) {
        Blog blog = blogRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found user with id = " + id);
        });

        // Tìm kiếm category
        Set<Category> categories = categoryRepository.findByIdIn(request.getCategoryIds());

        blog.setTitle(request.getTitle());
        blog.setContent(request.getContent());
        blog.setSlug(slugify.slugify(request.getTitle()));
        blog.setDescription(request.getDescription());
        blog.setStatus(request.getStatus());
        blog.setCategories(categories);
        blog.setThumbnail(request.getThumbnail());

        return blogRepository.save(blog);

    }

    @Transactional
    public void deleteBlog(Integer id) {
        // TODO : Khi xóa blog cẩn thận vì liên quan đến comment và category (có thể sử dụng life cycle để xử lý - preRemove)
        // Xóa Blog -> Xóa Comment
        // Xóa Blog -> Xóa Blog-category trong bảng trung gian, không xóa category
        Blog blog = blogRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found user with id = " + id);
        });

        blogRepository.delete(blog);
        commentRepository.deleteAllByBlog(blog);
    }
}
