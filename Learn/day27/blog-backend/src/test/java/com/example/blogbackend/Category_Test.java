package com.example.blogbackend;

import com.example.blogbackend.entity.Category;
import com.example.blogbackend.exception.NotFoundException;
import com.example.blogbackend.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class Category_Test {
    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void findById() {
        Category category = categoryRepository.findById(1).orElseThrow(() -> {
            throw new NotFoundException("dasd");
        });

        System.out.println(category.getBlogs());
    }

}
