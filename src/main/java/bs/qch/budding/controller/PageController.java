package bs.qch.budding.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

	// 跳转到登录页面
    @RequestMapping("/toLogin")
    public String toLogin(){

        return "login/login";
    }

    @RequestMapping("/toRegister")
    public String toRegister(){

    	// 跳转到注册页面
        return "register/register";
    }
}
