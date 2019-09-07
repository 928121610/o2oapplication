package cn.swb.o2osys.application.service;

import cn.swb.o2osys.application.entity.LogLogin;

public interface LogLoginService {
    /**
     * 向用户日志表中插入数据
     * @param logLogin
     * @return
     */
    int insert(LogLogin logLogin);
}
