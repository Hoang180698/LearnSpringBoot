package com.example.demobean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Component
public class User {
    private String name;
    private String email;

    public void showInfo(){
        System.out.println("Name" + name + " - eamil : " +email);
    }
    public void hello() {
        System.out.println("xin chào");
    }
}
