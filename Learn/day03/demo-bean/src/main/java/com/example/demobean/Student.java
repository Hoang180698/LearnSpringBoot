package com.example.demobean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {
    private String name;
    private String email;

    @Autowired
    @Qualifier("Bus")
    private Vehicle vehicle;

    public void showVehicle() {
        vehicle.run();
    }

    public Student(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void showInfo(){
        System.out.println("Name: " + name + " - eamil : " +email);
    }
    public void hello() {
        System.out.println("xin chào học sinh");
    }
}
