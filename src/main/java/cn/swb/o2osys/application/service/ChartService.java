package cn.swb.o2osys.application.service;

import cn.swb.o2osys.application.config.TableData;
import org.springframework.stereotype.Service;

@Service
public interface ChartService {
    TableData getcharJSON();
}
