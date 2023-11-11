package com.example.tpcell.Service;

import com.example.tpcell.Entity.Students;

import java.util.List;

public interface StudentService {
    Students saveStudent(Students students);
    List<Students> getAll();
    Students getStudentById(Long id);

    Students updateStudentById(Students std , Long id);

    void deleteStudent(String std,Long id);
}
