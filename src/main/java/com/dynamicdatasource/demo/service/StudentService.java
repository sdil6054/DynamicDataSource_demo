package com.dynamicdatasource.demo.service;
import com.dynamicdatasource.demo.config.SwitchDataSource;
import com.dynamicdatasource.demo.model.College;
import com.dynamicdatasource.demo.model.Student;
import com.dynamicdatasource.demo.repository.CollegeRepository;
import com.dynamicdatasource.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @SwitchDataSource(value = "student")
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

}
