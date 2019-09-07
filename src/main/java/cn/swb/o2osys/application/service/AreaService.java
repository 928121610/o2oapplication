package cn.swb.o2osys.application.service;

import cn.swb.o2osys.application.entity.Area;

import java.util.List;

public interface AreaService {
    /**
     * 用列表的形式返回所有区域
     * @return
     */
    List<Area> getAreas();
}
