package cn.swb.o2osys.application.controller;

import cn.swb.o2osys.application.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("shop/area")
public class AreaController {
    @Autowired
    AreaService areaService;

    /**
     * 返回列表数据
     * @return
     */
    @GetMapping("list")
    @ResponseBody
    public Object getAreas(){
        System.out.println("1111111111");
        return areaService.getAreas();
    }
}
