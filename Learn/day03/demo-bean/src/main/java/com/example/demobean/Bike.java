package com.example.demobean;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("bike")
public class Bike implements Vehicle{
    @Override
    public void run() {
        System.out.println("Đi học bằng xe đạp");
    }
}
