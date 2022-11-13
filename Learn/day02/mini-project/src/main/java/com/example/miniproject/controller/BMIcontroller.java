package com.example.miniproject.controller;

import com.example.miniproject.request.UpsertBMIRequest;
import com.example.miniproject.service.BMIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BMIcontroller {

    @Autowired
    private BMIService bmiService;

    @GetMapping("/bmi")
    public double getBMI(@RequestBody UpsertBMIRequest bmiRequest) {
        return bmiService.getBMI(bmiRequest);
    }
}
