package com.example.accessingdatamysql.repository;

import com.example.accessingdatamysql.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  IStudentsRespository extends JpaRepository<Students, Integer> {

    // custom query to search to blog post by title or content
    List<Students> findStudentsByNameContainsAndEmailContains(String name, String email);
}
