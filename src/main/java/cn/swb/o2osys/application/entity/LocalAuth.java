package cn.swb.o2osys.application.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import java.util.Date;

@Data//用户简略信息
public class LocalAuth {
    private Integer localAuthId;
    @TableId(value = "user_id",type = IdType.AUTO)
    private Integer userId;

    private String userName;

    private String password;

    private Date createTime;

    private Date lastEditTime;
}