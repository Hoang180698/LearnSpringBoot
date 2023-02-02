package com.example.jpabasic;

import com.example.jpabasic.entity.User;
import com.example.jpabasic.repository.UserRepository;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.lang.ref.SoftReference;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class JpaBasicApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Faker faker;

    @Test
    void save_random_user() {
        for (int i = 0; i < 30; i++) {
            User user = User.builder()
                    .name(faker.name().fullName())
                    .email(faker.internet().emailAddress())
                    .age(faker.number().numberBetween(15, 40))
                    .build();

            userRepository.save(user);
        }
    }

    @Test
    void pagination_user_test() {
        Page<User> page = userRepository.findAll(PageRequest.of(0, 10, Sort.by("age").descending()));
        page.getContent().forEach(System.out::println);
    }

    @Test
    void sort_user_test() {
        List<User> users = userRepository.findAll(Sort.by("age").descending());
        users.forEach(System.out::println);
    }

    @Test
    void save_user() {
        User user = User.builder()
                .name("Nguyen Van hoang")
                .email("hoang180698@gmail.com")
                .age(25)
                .build();

        userRepository.save(user);
    }

    @Test
    @Transactional(noRollbackFor = {RuntimeException.class})
    void transaction_test() {
        userRepository.deleteById(2);

        throw new RuntimeException("co loi xay ra");
    }

    @Test
    void save_mutilple_user() {
        User user = User.builder()
                .name("Nguyen Van A")
                .email("A1@gmail.com")
                .age(23)
                .build();
        User user1 = User.builder()
                .name("Nguyen Van B")
                .email("abc@gmail.com")
                .age(30)
                .build();
        User user2 = User.builder()
                .name("Tran Thi C")
                .email("C@gmail.com")
                .age(26)
                .build();

        userRepository.saveAll(List.of(user, user1, user2));
    }

    @Test
    void updateUser_user() {
       Optional<User> userOptional = userRepository.findById(1);
       if (userOptional.isPresent()) {
           User user = userOptional.get();
           user.setName("Nguyen Van Hoang update");
           user.setAge(27);

           userRepository.save(user);
       }
    }

    @Test
    void delete_user() {
        userRepository.deleteById(1);
    }

    @Test
    void findByName_test() {
        List<User> users = userRepository.findByName("Nguyen Van B");
        users.forEach(System.out::println);

        List<User> users1 = userRepository.findByNameJPQL("Nguyen Van B");
        users1.forEach(System.out::println);

        List<User> users2 = userRepository.findByNameNative("Nguyen Van B");
        users2.forEach(System.out::println);
    }

    @Test
    void countByAge() {
        long total = userRepository.countByAgeBetween(10, 40);
        System.out.println(total);
    }

    @Test
    void findByNameContaining_test() {
        List<User> users = userRepository.findByNameContainingIgnoreCase("van");
        users.forEach(System.out::println);
    }

    @Test
    void updateNameUser_test() {
        userRepository.updateNameUser(2, "Nguyen Van B Update");
    }

}
