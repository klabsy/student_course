package com.klabsy.controller;
import com.klabsy.pojo.Sc;
import com.klabsy.pojo.StuCourse;
import com.klabsy.service.ScService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sc")
public class ScController {
    @Autowired
    @Qualifier("ScServiceImpl")
    private ScService scService;
    //查全部
    @RequestMapping("/get_allSc")
    public List<Sc> get_allSc(){
        List<Sc> sclist = scService.queryAllSc();
        return sclist; //由于@RestController注解，将list转成json格式返回
    }

    @PostMapping("/add_Sc")
    public String addSc(@RequestBody Sc sc) {
        System.out.println(sc);
        scService.addSc(sc);
        return "addsuccss";
    }

    //删除
    @DeleteMapping("/del_Sc/{Sno}/{Cno}")
    public String deleteSc(@PathVariable("Sno") int sno, @PathVariable("Cno") int cno) {
        System.out.println(sno+" "+cno);
        scService.deleteScById(sno, cno);
        return "dellsuccss";
    }

    //id查
    @PostMapping("/id_UpdateSc/{Sno}")
    public List<StuCourse> id_Sc(@PathVariable("Sno") int id){
        System.out.println(id);
        List<StuCourse> sclistid =scService.queryScById(id);
        System.out.println(sclistid);
        return sclistid;
    }

    //id查
    @PostMapping("/Cno_UpdateSc/{Cno}")
    public List<StuCourse> Cno_Sc(@PathVariable("Cno") int id){
        System.out.println(id);
        List<StuCourse> sclistsc =scService.queryScBycnoId(id);
        System.out.println(sclistsc);
        return sclistsc;
    }

    //改
    @PutMapping("/updateSc/{Sno}")
    public String toUpdateSc(@RequestBody Sc sc, @PathVariable("Sno") int id) {
        System.out.println(sc);
        sc.setSno(id);
        scService.updateSc(sc);
        return "updatesuccss"; //根据当前查询到的对象，进行更新，返回到对应页面
    }
}

