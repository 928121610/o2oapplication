package cn.swb.o2osys.application.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;
@Data
public class Product {
    private Integer productId;

    private String productName;

    private String productDesc;

    private String imgAddr;

    private String normalPrice;

    private String promotionPrice;

    private Integer priority;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createTime;
    @JsonIgnore
    private Date lastEditTime;

    private Integer enableStatus;

    private Integer point;
    @JsonIgnore
    private Integer productCategoryId;
    @JsonIgnore
    private Integer shopId;
}