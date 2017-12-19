package bs.qch.budding.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/toLogin")
    public String toLogin(){

        return "login/login";
    }

    @RequestMapping("/toRegister")
    public String toRegister(){

        return "register/register";
    }
}
