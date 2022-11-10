package com.example.btvn01.controller;


import com.example.btvn01.model.Job;
import com.example.btvn01.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class JobController {
    @Autowired
    private JobService jobService;

    // GET api/v1/jobs/random : trả về một job ngẫu nhiên trong danh sách
    @GetMapping("jobs/random")
    public Job getJobRandom() {
        return jobService.getJobRandom();
    }

    // GET api/v1/sort?max_salary=desc : trả về danh sách job được sắp xếp giảm dần theo lương tối đa
    @GetMapping("sort")
    public List<Job> getSortJob(@RequestParam String max_salary) {
        return  jobService.getSortJobB(max_salary);
    }
}