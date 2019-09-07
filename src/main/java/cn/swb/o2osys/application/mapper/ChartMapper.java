package cn.swb.o2osys.application.mapper;

import cn.swb.o2osys.application.entity.OrderDetail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ChartMapper extends BaseMapper<OrderDetail> {
    /**
     * 返回柱状图数据
     * @return
     */
    List<Map<String,Object>> selectZhu();
    /**
     * 返回饼状图数据
     * @return
     */
    List<Map<String,Object>> selectBing();
    /**
     * 返回条形图数据
     * @return
     */
    List<Map<String,Object>> selectTiao();
}
