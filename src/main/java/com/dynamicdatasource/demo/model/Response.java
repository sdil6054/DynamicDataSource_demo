package com.dynamicdatasource.demo.model;

import lombok.Data;

import java.util.List;

@Data
public class Response {

    List<Student> students;
    List<College> colleges;
}
