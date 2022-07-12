package com.klabsy.service;

import com.klabsy.dao.CourseMapper;
import com.klabsy.pojo.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//@Service
public class CourseServiceImpl implements CourseService {
//    @Autowired
    private CourseMapper courseMapper;
    public void setCourseMapper(CourseMapper courseMapper){
        this.courseMapper = courseMapper;
    }


    @Override
    public int addCourse(Course course) {
        return courseMapper.addCourse(course);
    }

    @Override
    public int deleteCourseById(int id) {
        return courseMapper.deleteCourseById(id);
    }

    @Override
    public int updateCourse(Course course) {
        return courseMapper.updateCourse(course);
    }

    @Override
    public Course queryCourseById(int id) {
        return courseMapper.queryCourseById(id);
    }

    @Override
    public List<Course> queryAllCourse() {
        return courseMapper.queryAllCourse();
    }
}
