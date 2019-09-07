package cn.swb.o2osys.application.service.ServiceImp;

import cn.swb.o2osys.application.config.DataGridView;
import cn.swb.o2osys.application.entity.Product;
import cn.swb.o2osys.application.mapper.ProductMapper;
import cn.swb.o2osys.application.service.ProductService;
import cn.swb.o2osys.application.vo.ProductVo;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    ProductMapper productMapper;
    @Override
    public DataGridView getDataGridView(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        List<Product> products = productMapper.selectList(null);
        PageInfo<Product> productPageInfo = new PageInfo<>(products);

        DataGridView<Product> dataGridView=new DataGridView<>();
        dataGridView.setCode(0);
        dataGridView.setMsg("看看message是个啥");
        dataGridView.setCount(productPageInfo.getTotal());
        dataGridView.setData(productPageInfo.getList());
        return dataGridView;
    }

    @Override
    public DataGridView getDataGridViewReload(Integer page, Integer limit, ProductVo productVo, HttpSession session) {
        PageHelper.startPage(page,limit);
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.like("product_name",productVo.getProductName());
        try {
            queryWrapper.between("promotion_price",Integer.parseInt(productVo.getStartPrice()),Integer.parseInt(productVo.getEndPrice()));
        }catch (Exception e){
            //啥也不做
        }
        List<Product> products = productMapper.selectList(queryWrapper);
        PageInfo<Product> productPageInfo = new PageInfo<>(products);

        DataGridView<Product> dataGridView=new DataGridView<>();
        dataGridView.setCode(0);
        dataGridView.setMsg("看看message是个啥");
        dataGridView.setCount(productPageInfo.getTotal());
        dataGridView.setData(productPageInfo.getList());
        return dataGridView;
    }

    @Override
    public String deleteProduct(String productId, String operation) {
        String msg="";
        int flag=1;//
        if(operation.equals("up")){
            msg="上架成功";
            flag=1;
        }else if(operation.equals("down")){
            msg="下架成功";
            flag=0;
        }else if(operation.equals("delete")){
            msg="删除成功";
            flag=2;
        }
        //TODO 创建查询条件，queryWrapper，根据product_id得到对应的Product
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("product_id",productId);
        Product product = productMapper.selectOne(queryWrapper);
        System.out.println(product);
        //TODO update根据queryWrapper条件（相当于where子句）
        product.setEnableStatus(flag);//更改要更改为的product实例
        productMapper.update(product,queryWrapper);//update语句是根据实例更改所有的值
        return msg;
    }
}