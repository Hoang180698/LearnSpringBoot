package com.example.btvn01.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Job {
    private  int id;
    private  String title;
    private  String description;
    private  String location;
    private  int minSalary;
    private  int maxSalary;
    private  String emailTo;
}
