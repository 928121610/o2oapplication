package cn.swb.o2osys.application.service;

import cn.swb.o2osys.application.config.DataGridView;
import cn.swb.o2osys.application.vo.ProductVo;

import javax.servlet.http.HttpSession;

public interface ProductService {
    DataGridView getDataGridView(Integer page, Integer limit);
    DataGridView getDataGridViewReload(Integer page, Integer limit, ProductVo productVo, HttpSession session);
    String deleteProduct(String productId,String operation);
}
