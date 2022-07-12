package com.klabsy.dao;

import com.klabsy.pojo.Student;

import java.util.List;

public interface StudentMapper {

    //增加一个Student
    int addStudent(Student student);
    //根据id删除一个Student
    int deleteStudentById(int Sno);
    //更新Student
    int updateStudent(Student student);
    //根据id查询,返回一个Book
    Student queryStudentById(int id);
    //查询全部Student,返回list集合
    List<Student> queryAllStudent();

}
