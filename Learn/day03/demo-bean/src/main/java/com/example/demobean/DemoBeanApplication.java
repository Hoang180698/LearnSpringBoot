package com.example.demobean;

import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLOutput;
import java.util.Random;

@SpringBootApplication
public class DemoBeanApplication {
    // Tạo bean bằng cách đánh dấu anotation lên class
    // Controller, RestController, Service, Reposotory
    // -> tạo ra 1 đối tượng duy nhất(singleton) -> Được đưa vap application context để quản lý
    // 1. Sử dụng autowired
    // 2. Sử dụng contructor (recommend)
    // 3. sử dụng setter

    //Tạo bean băng cách đánh dấu anocation lên method
    // @Bean: Trả về 1 đối tượng -> @Configure, @SpringBootApplication

    public static void main(String[] args) {
        ApplicationContext context = (ApplicationContext) SpringApplication.run(DemoBeanApplication.class, args);

        User user = context.getBean(User.class);
        user.hello();

//        Student student = context.getBean(Student.class);
//        student.showInfo();

        Student student1 = context.getBean("student1", Student.class);
        student1.showInfo();
        student1.showVehicle();

        Student student2 = context.getBean("student2", Student.class);
        student2.showInfo();

        Student student3 = context.getBean("student3", Student.class);
        student3.showInfo();

        Random random = context.getBean(Random.class);
        System.out.println(random.nextInt(1000));


    }

    @Bean("student1")
    public Student creatStudent() {
        return new Student("Nguyen Van A", "A@gamil.com");
    }

    @Bean("student2")
    public Student creatStudent1() {
        return new Student("Tran van B", "b@gmail.com");
    }

    @Bean
    public Random random() {
        return new Random();
    }

}
