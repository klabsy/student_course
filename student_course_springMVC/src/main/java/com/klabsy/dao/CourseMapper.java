package com.klabsy.dao;

import com.klabsy.pojo.Course;

import java.util.List;

public interface CourseMapper {

    //增加一个Course
    int addCourse(Course course);
    //根据id删除一个Course
    int deleteCourseById(int id);
    //更新Student
    int updateCourse(Course course);
    //根据id查询,返回一个Course
    Course queryCourseById(int id);
    //查询全部Student,返回list集合
    List<Course> queryAllCourse();

}
