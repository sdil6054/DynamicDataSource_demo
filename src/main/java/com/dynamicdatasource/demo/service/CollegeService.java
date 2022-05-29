package com.dynamicdatasource.demo.service;

import com.dynamicdatasource.demo.config.SwitchDataSource;
import com.dynamicdatasource.demo.model.College;
import com.dynamicdatasource.demo.repository.CollegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollegeService {

    @Autowired
    private CollegeRepository collegeRepository;
    @SwitchDataSource(value = "college")
    public List<College> getAllColleges(){
        return collegeRepository.findAll();
    }
}
