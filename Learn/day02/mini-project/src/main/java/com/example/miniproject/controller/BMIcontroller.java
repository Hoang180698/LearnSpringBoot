package com.example.miniproject.controller;

import com.example.miniproject.request.BmiRequest;
import com.example.miniproject.service.BMIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BMIcontroller {

    @Autowired
    private BMIService bmiService;

    @GetMapping("/bmi-get")
    public double calculateBmiGet(@RequestParam double height, @RequestParam double weight) {
        return bmiService.getBmi(height, weight);
    }

    @PostMapping("/bmi-post")
    public double calculateBmiPost(@RequestBody BmiRequest request) {
        return bmiService.getBmi(request.getHeight(), request.getWeight());
    }
}
