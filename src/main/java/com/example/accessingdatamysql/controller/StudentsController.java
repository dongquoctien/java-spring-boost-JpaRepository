package com.example.accessingdatamysql.controller;

import com.example.accessingdatamysql.model.Students;
import com.example.accessingdatamysql.repository.IStudentsRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class StudentsController {

    @Autowired
    IStudentsRespository studentsRespository;

    @GetMapping("/students")
    public List<Students> index(){

        return studentsRespository.findAll();
    }

    //Get search request parameter
    @GetMapping("/students-by")
    public  List<Students> indexBy(String name, String code){
        return studentsRespository.findStudentsByNameContainsAndEmailContains(name, code);
    }

    //Get detail by id
    @GetMapping("/students/{id}")
    public Students detail(@PathVariable String id){
        int studentId = Integer.parseInt(id);
        return studentsRespository.getReferenceById(studentId);
    }

    //Request body
    @PostMapping("/students-search")
    public List<Students> searchMutiple(@RequestBody Map<String, String> body){
        String searchTerm = body.get("text");
        return studentsRespository.findStudentsByNameContainsAndEmailContains(searchTerm, searchTerm);
    }

    @PostMapping("/students-create")
    public Students createStudent(@RequestBody Map<String, String> body){
        String name = body.get("name");
        Integer age =  Integer.parseInt( body.get("age") != null ? body.get("age") :"0");
        String email = body.get("email");

        return studentsRespository.save(new Students( name, age, email));
    }

    @PutMapping("/students-update/{id}")
    public Students update(@PathVariable String id, @RequestBody Map<String, String> body){
        int blogId = Integer.parseInt(id);
        // get student
        Students student = studentsRespository.getReferenceById(blogId);
        String name = body.get("name");
        Integer age =  Integer.parseInt( body.get("age") != null ? body.get("age") :"0");
        String email = body.get("email");

        student.setName(name);
        student.setAge(age);
        student.setEmail(email);
        return studentsRespository.save(student);
    }
}
