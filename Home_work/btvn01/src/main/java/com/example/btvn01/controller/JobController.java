package com.example.btvn01.controller;


import com.example.btvn01.model.Job;
import com.example.btvn01.request.UpsertJobRequest;
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

    // GET : api/v1/jobs : Lấy danh sách tất cả job
    @GetMapping("jobs")
    public List<Job> getJobs() {
        return jobService.getJobs();
    }

    // GET : api/v1/jobs/{id} : Lấy chi tiết 1 job theo id
    @GetMapping("jobs/{id}")
    public Job getJobById(@PathVariable int id) {
        return jobService.getJobById(id);
    }

    // POST : api/v1/jobs : Tạo mới Job -> Đối tượng sau khi tạo
    @PostMapping("jobs")
    public Job createJobs(@RequestBody UpsertJobRequest request) {
        return jobService.createJobs(request);
    }

    // PUT : api/v1/jobs/{id} : Cập nhật thông tin job -> Đối tượng sau khi cập nhật
    @PutMapping("jobs/{id}")
    public Job updateJob(@PathVariable int id, @RequestBody UpsertJobRequest request) {
        return jobService.updateJob(id, request);
    }

    // DELETE : api/v1/jobs/{id} : Xóa cuốn sách theo id
    @DeleteMapping("jobs/{id}")
    public void deleteJob(@PathVariable int id) {
        jobService.deleteJob(id);
    }

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