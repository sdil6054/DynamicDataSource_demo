package com.dynamicdatasource.demo.controller;

import com.dynamicdatasource.demo.model.Response;
import com.dynamicdatasource.demo.service.CollegeService;
import com.dynamicdatasource.demo.service.StudentService;
import com.dynamicdatasource.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping(value = "/")
    public Response getResponse(){
        Response response = new Response();
        response.setStudents(testService.getAllStudents());
        response.setColleges(testService.getAllColleges());
        return response;
    }
}
