package cn.swb.o2osys.application.controller;

import cn.swb.o2osys.application.entity.LocalAuth;
import cn.swb.o2osys.application.entity.LogLogin;
import cn.swb.o2osys.application.entity.PersonInfo;
import cn.swb.o2osys.application.service.LocalAuthService;
import cn.swb.o2osys.application.service.LogLoginService;
import cn.swb.o2osys.application.service.PersonInfoService;
import com.google.code.kaptcha.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping("shop")
public class LocalAuthController {
    @Autowired
    LocalAuthService userService;
    @Autowired
    LogLoginService logLoginService;
    @Autowired
    PersonInfoService personInfoService;
    /**
     * 返回login.html登录页面
     * @return
     */
    @GetMapping("login.html")
    public String loginHtml(){
        return "login";
    }
    /**
     * 返回buyer/regist.html买家注册页面
     * @return
     */
    @GetMapping("buyerRegist.html")
    public String buyerRegist(){
        return "buyer/regist";
    }
    /**
     * 返回seller/regist.html卖家注册页面
     * @return
     */
    @GetMapping("sellerRegist.html")
    public String sellerRegist(){
        return "seller/regist";
    }
    /**
     * 返回对应登录初始化页面
     * @return
     */
    @GetMapping("index")
    public String loginindex(String kaptcha,
                             HttpServletRequest request,
                             LocalAuth localAuth,
                             HttpSession httpSession){
        //TODO 判断验证码是否正确
        // 1.获取Kaptcha生成的
        String kaptchastring = (String) httpSession.getAttribute(Constants.KAPTCHA_SESSION_KEY);
        //一次性验证码=======>获取完之后，移除
//        httpSession.removeAttribute(Constants.KAPTCHA_SESSION_KEY);
        if (kaptchastring.equalsIgnoreCase(kaptcha)){
            //TODO 判断用户名与密码是否匹配
            localAuth = userService.selectById(localAuth);
            //用户与密码匹配跳转到管理界面administrator/index.html
            if (localAuth!=null){
                //TODO 1.查询出PersonInfo的信息
                // 只需要将loginUser的user_id作为PersonInfo的查询条件即可
                PersonInfo personInfo = new PersonInfo();
                personInfo.setUserId(localAuth.getUserId());
                personInfo = personInfoService.getPersonInfo(personInfo);
                System.out.println(personInfo);
                //TODO 2.将成功登录的用户信息放入Session中
                httpSession.setAttribute("localAuth",localAuth);
                httpSession.setAttribute("personInfo",personInfo);
                //TODO 3.将成功登录的用户信息放入用户日志logLogin中
                LogLogin logLogin = new LogLogin();
                logLogin.setLoginname(localAuth.getUserName());
                logLogin.setLoginip("127.0.0.1");
                logLogin.setLogintime(new Date());
                int insert = logLoginService.insert(logLogin);
                System.out.println("插入行数:"+insert);
                return "administrator/index.html";
            }else{
                //用户与密码不匹配跳转到登录界面login
                httpSession.setAttribute("errormsg","用户名或密码错误");
                return "login";
            }
        }else {
            //验证码错误跳转到登录界面login
            httpSession.setAttribute("errormsg","验证码错误");
            return "login";
        }
    }
    /**
     * 注册后返回登录页面
     * @return
     */
    @PostMapping("regist")
    public String registindex(HttpServletRequest request) {
        LocalAuth localAuth=null;
        userService.regist(localAuth);
        return "login";
    }
    /**
     * 返回main页面
     * @return
     */
    @GetMapping("main")
    public String main(){
        return "static/resources/page/main.html";
    }
}
