package com.example.accessingdatamysql.controller;

import com.example.accessingdatamysql.model.Students;
import com.example.accessingdatamysql.repository.IStudentsRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentsController {

    @Autowired
    IStudentsRespository studentsRespository;

    @GetMapping("/students")
    public List<Students> index(){
        return studentsRespository.findAll();
    }



}
