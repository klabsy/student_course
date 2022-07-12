package com.klabsy.controller;
import com.klabsy.pojo.Course;
import com.klabsy.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    @Qualifier("CourseServiceImpl")
    private CourseService courseService;
    //查全部
    @RequestMapping("/get_allCourse")
    public List<Course> get_allCourse(){
        List<Course> courselist = courseService.queryAllCourse();
        return courselist; //由于@RestController注解，将list转成json格式返回
    }

    @PostMapping("/add_Course")
    public String addCourse(@RequestBody Course course) {
        System.out.println(course);
        courseService.addCourse(course);
    //        return "redirect:/tudent/allCourse";
        return "addsuccss";
    }

    //删除
    @DeleteMapping("/del_Course/{Cno}")
    public String deleteCourse(@PathVariable("Cno") int id) {
        System.out.println(id);
        courseService.deleteCourseById(id);
        return "dellsuccss";
    }

    //id查
    @PostMapping("/id_UpdateCourse/{Cno}")
    public Course id_Course(@PathVariable("Cno") int id){
        System.out.println(id);
        Course courselist = courseService.queryCourseById(id);
        return courselist;
    }

    //改
    @PutMapping("/updateCourse/{Cno}")
    public String toUpdateCourse(@RequestBody Course course, @PathVariable("Cno") int id) {
        System.out.println(course);
        course.setCno(id);
        courseService.updateCourse(course);
        return "updatesuccss"; //根据当前查询到的对象，进行更新，返回到对应页面
    }
}

