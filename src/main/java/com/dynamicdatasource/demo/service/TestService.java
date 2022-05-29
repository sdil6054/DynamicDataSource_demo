package com.dynamicdatasource.demo.service;

import com.dynamicdatasource.demo.config.SwitchDataSource;
import com.dynamicdatasource.demo.model.College;
import com.dynamicdatasource.demo.model.Student;
import com.dynamicdatasource.demo.repository.CollegeRepository;
import com.dynamicdatasource.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CollegeRepository collegeRepository;

    @SwitchDataSource("student")
    public List<Student> getAllStudents(){
        return  studentRepository.findAll();
    }


    @SwitchDataSource("college")
    public List<College> getAllColleges(){
        return  collegeRepository.findAll();
    }
}
