package cn.swb.o2osys.application.config;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Data
public class TableData {
    private List<Map<String,Object>> mapZhu=new ArrayList<>();
    private List<Map<String,Object>> mapBing=new ArrayList<>();
    private List<Map<String,Object>> mapTiao=new ArrayList<>();
}
