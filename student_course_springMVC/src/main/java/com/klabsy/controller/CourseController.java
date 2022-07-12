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
    //��ȫ��
    @RequestMapping("/get_allCourse")
    public List<Course> get_allCourse(){
        List<Course> courselist = courseService.queryAllCourse();
        return courselist; //����@RestControllerע�⣬��listת��json��ʽ����
    }

    @PostMapping("/add_Course")
    public String addCourse(@RequestBody Course course) {
        System.out.println(course);
        courseService.addCourse(course);
    //        return "redirect:/tudent/allCourse";
        return "addsuccss";
    }

    //ɾ��
    @DeleteMapping("/del_Course/{Cno}")
    public String deleteCourse(@PathVariable("Cno") int id) {
        System.out.println(id);
        courseService.deleteCourseById(id);
        return "dellsuccss";
    }

    //id��
    @PostMapping("/id_UpdateCourse/{Cno}")
    public Course id_Course(@PathVariable("Cno") int id){
        System.out.println(id);
        Course courselist = courseService.queryCourseById(id);
        return courselist;
    }

    //��
    @PutMapping("/updateCourse/{Cno}")
    public String toUpdateCourse(@RequestBody Course course, @PathVariable("Cno") int id) {
        System.out.println(course);
        course.setCno(id);
        courseService.updateCourse(course);
        return "updatesuccss"; //���ݵ�ǰ��ѯ���Ķ��󣬽��и��£����ص���Ӧҳ��
    }
}

