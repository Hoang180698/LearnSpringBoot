package com.example.blogbackend.repository;

import com.example.blogbackend.Dto.CategoryDto;
import com.example.blogbackend.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Set<Category> findByIdIn(List<Integer> ids);

//    @Query(nativeQuery = true, value = "select c.id, c.name, count(b.id) as used from category c left join blog_category bc on c.id = bc.category_id left join blog b on bc.blog_id = b.id where b.status = true group by c.id")
//    List<Category> getAllCategoryAndAmountUsed();

//    @Query(nativeQuery = true, value = "select new com.ex")
//    List<CategoryDto> getAllCategoryAndAmountUsed();
}