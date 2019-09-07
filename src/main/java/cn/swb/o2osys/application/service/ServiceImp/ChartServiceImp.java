package cn.swb.o2osys.application.service.ServiceImp;

import cn.swb.o2osys.application.config.TableData;
import cn.swb.o2osys.application.entity.OrderDetail;
import cn.swb.o2osys.application.mapper.ChartMapper;
import cn.swb.o2osys.application.service.ChartService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ChartServiceImp implements ChartService {
    @Autowired
    ChartMapper chartMapper;

    @Override
    public TableData getcharJSON() {
        TableData tableData=new TableData();
        tableData.setMapZhu(chartMapper.selectZhu());
        tableData.setMapBing(chartMapper.selectBing());
        tableData.setMapTiao(chartMapper.selectTiao());
        return tableData;
    }
}
