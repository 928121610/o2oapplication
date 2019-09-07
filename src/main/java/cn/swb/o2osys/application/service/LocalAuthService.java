package cn.swb.o2osys.application.service;

import cn.swb.o2osys.application.entity.LocalAuth;


public interface LocalAuthService {
    LocalAuth selectById(LocalAuth localAuth);

    int regist(LocalAuth localAuth);
}
