package cn.swb.o2osys.application.controller;

import cn.swb.o2osys.application.config.TableData;
import cn.swb.o2osys.application.service.ChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("shop/chart")
public class ChartController {
    @Autowired
    ChartService chartService;

    @GetMapping("/top5.html")
    public String top(){
        return "administrator/chart.html";
    }

    @GetMapping("getcharJSON")
    @ResponseBody
    public TableData getcharJSON(){
        return chartService.getcharJSON();
    }
}
