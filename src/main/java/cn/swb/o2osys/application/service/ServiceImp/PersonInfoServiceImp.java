package cn.swb.o2osys.application.service.ServiceImp;

import cn.swb.o2osys.application.entity.PersonInfo;
import cn.swb.o2osys.application.mapper.PersonInfoMapper;
import cn.swb.o2osys.application.service.PersonInfoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonInfoServiceImp implements PersonInfoService {
    @Autowired
    PersonInfoMapper personInfoMapper;
    @Override
    public PersonInfo getPersonInfo(PersonInfo personInfo) {
        QueryWrapper<PersonInfo> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("user_id",personInfo.getUserId());
        return personInfoMapper.selectOne(queryWrapper);
    }
}
