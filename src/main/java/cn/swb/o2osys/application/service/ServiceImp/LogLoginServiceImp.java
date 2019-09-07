package cn.swb.o2osys.application.service.ServiceImp;

import cn.swb.o2osys.application.entity.LogLogin;
import cn.swb.o2osys.application.mapper.LogLoginMapper;
import cn.swb.o2osys.application.service.LogLoginService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogLoginServiceImp implements LogLoginService {
    @Autowired
    LogLoginMapper logLoginMapper;
    @Override
    public int insert(LogLogin logLogin) {
        return logLoginMapper.insert(logLogin);
    }
}
