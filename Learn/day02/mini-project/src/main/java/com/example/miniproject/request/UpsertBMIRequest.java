package com.example.miniproject.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpsertBMIRequest {
    private double height;
    private double weight;
}
