package com.klabsy.service;

import com.klabsy.dao.StudentMapper;
import com.klabsy.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//@Service
public class StudentServiceImpl implements StudentService {
//    @Autowired
    private StudentMapper studentMapper;
    public void setStudentMapper(StudentMapper studentMapper){
        this.studentMapper = studentMapper;
    }


    @Override
    public int addStudent(Student student) {
        return studentMapper.addStudent(student);
    }

    @Override
    public int deleteStudentById(int id) {
        return studentMapper.deleteStudentById(id);
    }

    @Override
    public int updateStudent(Student student) {
        return studentMapper.updateStudent(student);
    }

    @Override
    public Student queryStudentById(int id) {
        return studentMapper.queryStudentById(id);
    }

    @Override
    public List<Student> queryAllStudent() {
        return studentMapper.queryAllStudent();
    }
}
