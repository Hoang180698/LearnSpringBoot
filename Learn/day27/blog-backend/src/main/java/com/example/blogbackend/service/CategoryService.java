package com.example.blogbackend.service;

import com.example.blogbackend.Dto.CategoryDto;
import com.example.blogbackend.entity.Category;
import com.example.blogbackend.exception.NotFoundException;
import com.example.blogbackend.repository.CategoryRepository;
import com.example.blogbackend.request.CategoryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    public List<Category> getAllCategory() {
       return categoryRepository.findAll();
    }

    public Category createCategory(CategoryRequest request) {
        Category category = Category.builder()
                .name(request.getName())
                .build();
        return categoryRepository.save(category);
    }

    public Category getCategoryById(Integer id) {
        return categoryRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found category with id = " + id);
        });
    }

    public Category updateCategory(Integer id, CategoryRequest request) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found category with id = " + id);
        });
        category.setName(request.getName());
        return categoryRepository.save(category);
    }

    public void deleteCategory(Integer id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found category with id = " + id);
        });
        categoryRepository.delete(category);
    }

    public List<CategoryDto> getAllCategoryAndAmountUsed() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryDto> categoryDtos = new ArrayList<>();
        for (Category category: categories) {
            CategoryDto categoryDto = new CategoryDto(category.getId(), category.getName(), category.getBlogs().size());
            categoryDtos.add(categoryDto);
        }
        return categoryDtos;
    }
}
