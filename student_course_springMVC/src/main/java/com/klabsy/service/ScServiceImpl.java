package com.klabsy.service;

import com.klabsy.dao.ScMapper;
import com.klabsy.pojo.Sc;
import com.klabsy.pojo.StuCourse;

import java.util.List;
//@Service
public class ScServiceImpl implements ScService {
//    @Autowired
    private ScMapper scMapper;
    public void setScMapper(ScMapper scMapper){
        this.scMapper = scMapper;
    }


    @Override
    public int addSc(Sc sc) {
        return scMapper.addSc(sc);
    }

    @Override
    public int deleteScById(int Sno, int Cno) {
        return scMapper.deleteScById(Sno, Cno);
    }

    @Override
    public int updateSc(Sc sc) {
        return scMapper.updateSc(sc);
    }

    @Override
    public List<StuCourse> queryScById(int id) {
        return scMapper.queryScById(id);
    }

    @Override
    public List<StuCourse> queryScBycnoId(int id) {
        return scMapper.queryScBycnoId(id);
    }

    @Override
    public List<Sc> queryAllSc() {
        return scMapper.queryAllSc();
    }
}
