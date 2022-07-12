package com.klabsy.dao;

import com.klabsy.pojo.Sc;
import com.klabsy.pojo.StuCourse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ScMapper {

    //增加一个Sc
    int addSc(Sc sc);
    //根据id删除一个Sc
    int deleteScById(@Param("Sno") int Sno, @Param("Cno") int Cno);
    //更新Sc
    int updateSc(Sc sc);
    //根据sno查询,返回一个StuCourse
    List<StuCourse> queryScById(int id);
    //根据cno查询,返回一个StuCourse
    List<StuCourse> queryScBycnoId(int id);
    //查询全部Sc,返回list集合
    List<Sc> queryAllSc();

}
