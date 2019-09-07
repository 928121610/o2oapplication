package cn.swb.o2osys.application.service.ServiceImp;

import cn.swb.o2osys.application.entity.Area;
import cn.swb.o2osys.application.mapper.AreaMapper;
import cn.swb.o2osys.application.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class AreaServiceImp implements AreaService {
    @Autowired
    AreaMapper areaMapper;
    @Override
    public List<Area> getAreas() {
        return areaMapper.selectList(null);
    }
}
