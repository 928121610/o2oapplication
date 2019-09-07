package cn.swb.o2osys.application.vo;

import cn.swb.o2osys.application.entity.Product;
import lombok.Data;

import java.util.List;

@Data
public class ProductVo extends Product{
    private String productName;
    private String startTime;
    private String endTime;
    private String startPrice;
    private String endPrice;

    private List<Long> shopIds;
}
