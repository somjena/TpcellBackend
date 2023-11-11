package com.example.tpcell.Service;

import com.example.tpcell.Entity.Students;
import com.example.tpcell.Exception.ResourceNotFoundException;
import com.example.tpcell.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    @Autowired

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Students saveStudent(Students students) {
        return studentRepository.save(students);
    }

    @Override
    public List<Students> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public Students getStudentById(Long id) {
        Optional<Students> students = studentRepository.findById(id);
        if (students.isPresent()){
            return students.get();
        }else {
            throw new ResourceNotFoundException("Stident","id",id);
        }
    }

    @Override
    public Students updateStudentById(Students std, Long id) {
        Students existingStudent = studentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Students","Id","id"));
        existingStudent.setReg_Id(std.getReg_Id());
        existingStudent.setFirstName(std.getFirstName());
        existingStudent.setLastName(std.getLastName());
        existingStudent.seteMail(std.geteMail());
        existingStudent.setNumber(std.getNumber());
        existingStudent.setDepartment(std.getDepartment());
        existingStudent.setPassword(std.getPassword());
        studentRepository.save(existingStudent);
        return existingStudent;
    }

    @Override
    public void deleteStudent(String std, Long id) {
        Students existingStudent = studentRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Students","Id","id"));
        studentRepository.delete(existingStudent);
    }
}
