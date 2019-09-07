package cn.swb.o2osys.application.controller;

import cn.swb.o2osys.application.config.DataGridView;
import cn.swb.o2osys.application.service.ProductService;
import cn.swb.o2osys.application.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("shop/product")
public class ProductController {
    @Autowired
    ProductService productService;
    /**
     * 返回list表格数据
     * @return
     */
    @GetMapping("list.html")
    public String loginHtml(){
        return "administrator/list";
    }
    /**
     * 返回list表格数据
     * @return
     */
    @GetMapping("productListJson")
    @ResponseBody
    public DataGridView productListJson(@RequestParam(value = "page",required = false,defaultValue = "1") Integer page,
                                        @RequestParam(value = "limit",required = false,defaultValue = "5")Integer limit){
        return productService.getDataGridView(page,limit);
    }
    @GetMapping("productListJsonSelect")
    @ResponseBody
    public DataGridView productListJsonSelect(
            @RequestParam(value = "page",required = false,defaultValue = "1") Integer page,
            @RequestParam(value = "limit",required = false,defaultValue = "5") Integer limit,
            ProductVo productVo, HttpSession session){
        System.out.println(productVo);
        System.out.println(session);
        return productService.getDataGridViewReload(page,limit,productVo,session);
    }
    @GetMapping("operatBatchProduct")
    @ResponseBody
    public String operatBatchProduct(
            @RequestParam String productId,
            @RequestParam String operation){
        return productService.deleteProduct(productId,operation);
    }
}
