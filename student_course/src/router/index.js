import Vue from 'vue'
import Router from 'vue-router'
import Student from '@/components/Student'
import Course from "../components/Course";
import ScStu from "../components/ScStu";
import StuSc from "../components/StuSc";
import Index from "../components/Index";
import Teacher from "../components/Teacher";
import Login from "../components/Login";
import Student_course from "../components/Student_course";
import Student_grade from "../components/Student_grade";
import Teacher_course from "../components/Teacher_course";
import Teacher_grade from "../components/Teacher_grade";
import Teacher_info from "../components/Teacher_info";
import Itroduction from "../components/Itroduction";
import Teacher_upcourse from "../components/Teacher_upcourse";
import Teacher_upgrade from "../components/Teacher_upgrade";
import Teacher_upinfo from "../components/Teacher_upinfo";
import Teacher_addinfo from "../components/Teacher_addinfo";
import Teacher_addcourse from "../components/Teacher_addcourse";
import Student_addcourse from "../components/Student_addcourse";
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/index',
      name: 'index',
      component: Index
    },
    {
      path: '/',
      name: 'login',
      component: Login
    },
    {
      path: '/itroduction',
      name: 'itroduction',
      component: Itroduction
    },
    {
      path: '/teacher',
      name: 'teacher',
      component: Teacher
    },
    {
      path: '/teacher_course',
      name: 'teacher_course',
      component: Teacher_course
    },
    {
      path:'/student_addcourse',
      name: 'student_addcourse',
      component: Student_addcourse
    },
    {
      path: '/teacher_upcourse',
      name: 'teacher_upcourse',
      component: Teacher_upcourse
    },
    {
      path: '/teacher_addcourse',
      name: 'teacher_addcourse',
      component: Teacher_addcourse
    },
    {
      path: '/teacher_addinfo',
      name: 'teacher_addinfo',
      component: Teacher_addinfo
    },
    {
      path: '/teacher_upgrade',
      name: 'teacher_upgrade',
      component: Teacher_upgrade
    },
    {
      path: '/teacher_grade',
      name: 'teacher_grade',
      component: Teacher_grade
    },
    {
      path: '/teacher_info',
      name: 'teacher_info',
      component: Teacher_info
    },
    {
      path: '/teacher_upinfo',
      name: 'teacher_upinfo',
      component: Teacher_upinfo
    },
    {
      path: '/student',
      name: 'student',
      component: Student
    },
    {
      path: '/student_grade',
      name: 'student_grade',
      component: Student_grade
    },
    {
      path: '/student_course',
      name: 'student_course',
      component: Student_course
    },
    {
      path: '/course',
      name: 'course',
      component: Course
    },
    {
      path: '/scStu',
      name: 'scStu',
      component: ScStu
    },
    {
      path: '/stuSc',
      name: 'stuSc',
      component: StuSc
    },
  ]
})
