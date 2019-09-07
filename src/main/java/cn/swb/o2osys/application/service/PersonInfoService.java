package cn.swb.o2osys.application.service;

import cn.swb.o2osys.application.entity.PersonInfo;

public interface PersonInfoService {
    /**
     * 获取用户详细信息
     * @param personInfo
     * @return
     */
    PersonInfo getPersonInfo(PersonInfo personInfo);
}
