package cn.swb.o2osys.application.service.ServiceImp;

import cn.swb.o2osys.application.entity.LocalAuth;
import cn.swb.o2osys.application.mapper.LocalAuthMapper;
import cn.swb.o2osys.application.service.LocalAuthService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;



@Service
public class LocalAuthServiceImp implements LocalAuthService {

    @Autowired
    LocalAuthMapper userMapper;

    @Override
    public LocalAuth selectById(LocalAuth localAuth){
        //TODO 使用md5对密码进行加密，然后才能与数据库中加密后数据进行对比
        localAuth.setPassword(DigestUtils.md5DigestAsHex(localAuth.getPassword().getBytes()));
        QueryWrapper<LocalAuth> queryWrapper = new QueryWrapper<>();//mp对查询条件进行封装，
        queryWrapper.eq("user_name",localAuth.getUserName());//where user_name = 变量username
        if(userMapper.selectOne(queryWrapper).getPassword().equals(localAuth.getPassword())){
            //select * from localAuth where user_name = 变量username
            //one代表返回一个
            return userMapper.selectOne(queryWrapper);
        }else {
            return null;
        }
    }

    @Override
    public int regist(LocalAuth localAuth) {

        return 0;
    }
}
