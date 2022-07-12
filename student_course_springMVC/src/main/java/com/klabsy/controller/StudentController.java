package com.klabsy.controller;


import com.klabsy.pojo.Student;
import com.klabsy.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    @Qualifier("StudentServiceImpl")
    private StudentService studentService;
    //查全部
    @RequestMapping("/get_allStudent")
    public List<Student> get_allStudent(){
        List<Student> studentlist = studentService.queryAllStudent();
        return studentlist; //由于@RestController注解，将list转成json格式返回
    }

    @PostMapping("/add_Student")
    public String addStudent(@RequestBody Student student) {
        System.out.println(student);
        studentService.addStudent(student);
    //        return "redirect:/tudent/allStudent";
        return "addsuccss";
    }

    //删除
    @DeleteMapping("/del_Student/{Sno}")
    public String deleteStudent(@PathVariable("Sno") int id) {
        System.out.println(id);
        studentService.deleteStudentById(id);
        return "dellsuccss";
    }

    //id查
    @PostMapping("/id_UpdateStudent/{Sno}")
    public Student id_Student(@PathVariable("Sno") int id){
        System.out.println(id);
        Student studentlist = studentService.queryStudentById(id);
        return studentlist;
    }

    //改
    @PutMapping("/updateStudent/{Sno}")
    public String toUpdateStudent(@RequestBody Student student, @PathVariable("Sno") int id) {
        System.out.println(student);
        student.setSno(id);
        studentService.updateStudent(student);
        return "updatesuccss"; //根据当前查询到的对象，进行更新，返回到对应页面
    }
}

