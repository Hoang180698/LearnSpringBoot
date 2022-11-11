package com.example.btvn01.service;

import com.example.btvn01.model.Job;
import com.example.btvn01.request.UpsertJobRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

@Service
public class JobService {
    private List<Job> jobs;

    public JobService() {
        jobs = new ArrayList<>();
        jobs.add(new Job(1,"Wed developer", "java-wed","Cau Giay",500, 2000, "Td1@gmail.com"));
        jobs.add(new Job(2,"Shipper", "giao do an","Dich Vong",400, 1000, "Td2@gmail.com"));
        jobs.add(new Job(3,"O-sin", "don dep","Quan Hoa",5000, 10000, "Td3@gmail.com"));
        jobs.add(new Job(4,"seller", "ban hang dong","LonDon",1000, 3000, "Td1@gmail.com"));
        jobs.add(new Job(5,"engineer", "dien tu","Japan",2000, 4000, "Td1@gmail.com"));
    }
    public Job getJobRandom() {
        if (jobs.isEmpty()){
            return null;
        }
        Random rd = new Random();
        Job job = jobs.get(rd.nextInt(jobs.size()));
        return  job;
    }
    public List<Job> getJobs() {
        return jobs;
    }
    public Job getJobById(int id) {
        for (Job job : jobs) {
            if (job.getId() == id) {
                return  job;
            }
        }
        return  null;
    }
    public Job createJobs(UpsertJobRequest request) {
        Random rd = new Random();
        int id = rd.nextInt(1000);

        Job job = new Job(id, request.getTitle(), request.getDescription(),
                       request.getLocation(), request.getMinSalary(), request.getMaxSalary(),
                       request.getEmailTo());
        jobs.add(job);
        return  job;
    }
    public Job updateJob(int id,  UpsertJobRequest request) {
        for (Job job : jobs) {
            if (job.getId() == id) {
                job.setTitle(request.getTitle());
                job.setDescription(request.getDescription());
                job.setLocation(request.getLocation());
                job.setMaxSalary(request.getMaxSalary());
                job.setMinSalary(request.getMinSalary());
                job.setEmailTo(request.getEmailTo());

                return  job;
            }

        };
        return  null;
    }
    public void deleteJob(int id) {
       jobs.removeIf(job -> job.getId() == id );
    }
    public List<Job> getSortJobB(String max_salary) {
        List sortJobs = new ArrayList<>(jobs);
        if (max_salary.equals("desc")) {
            sortJobs.sort(new Comparator<Job>() {
                @Override
                public int compare(Job o1, Job o2) {
                    return o2.getMaxSalary() - o1.getMaxSalary();
                }
            });;
            return sortJobs;
        }
        if (max_salary.equals("asc")) {
            sortJobs.sort(new Comparator<Job>() {
                @Override
                public int compare(Job o1, Job o2) {
                    return o1.getMaxSalary() - o2.getMaxSalary();
                }
            });;
            return  sortJobs;
        }
        return  this.jobs;
    }

}