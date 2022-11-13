package com.example.miniproject.service;

import com.example.miniproject.exception.BadRequestException;
import com.example.miniproject.request.UpsertBMIRequest;
import org.springframework.stereotype.Service;

@Service
public class BMIService {
    public double getBMI(UpsertBMIRequest bmiRequest) {

        if (bmiRequest.getWeight() <= 0 || bmiRequest.getHeight() <= 0) {
            throw  new BadRequestException("Can nang va chieu cao phai > 0");
        }
        double bmi = bmiRequest.getHeight() / Math.pow(bmiRequest.getWeight(), 2);
        return bmi;
    }
}
