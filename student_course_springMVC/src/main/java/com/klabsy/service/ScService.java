package com.klabsy.service;

import com.klabsy.pojo.Sc;
import com.klabsy.pojo.StuCourse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ScService {
    //增加一个Sc
    int addSc(Sc sc);
    //根据id删除一个Sc
    int deleteScById(int Sno,  int Cno);
    //更新Sc
    int updateSc(Sc sc);
    //根据id查询,返回一个StuCourse
    List<StuCourse> queryScById(int id);
    //根据id查询,返回一个StuCourse
    List<StuCourse> queryScBycnoId(int id);
    //查询全部Sc,返回list集合
    List<Sc> queryAllSc();
}
