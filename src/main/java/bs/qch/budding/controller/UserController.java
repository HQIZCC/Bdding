package bs.qch.budding.controller;

import bs.qch.budding.pojo.User;
import bs.qch.budding.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;

    @RequestMapping("/login.action")
    public String login(User user, Model model){

        if (StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword())){
            model.addAttribute("error", "用户名或密码不能为空");
            return "login/login";
        }

        String userId = userService.queryUser(user.getUsername(), user.getPassword());

        if (StringUtils.isEmpty(userId) || userId == null){
            model.addAttribute("error","用户名和密码错误");
            return "login/login";
        }

        model.addAttribute("username",user.getUsername());
        return "index";
    }

    // 注册用户，若成功则跳转到登录页面
    @RequestMapping("/register.action")
    public String RegisterUser(User user, Model model){

        if (StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword()) || StringUtils.isEmpty(user.getStatus())){
            model.addAttribute("error", "用户名或密码不能为空");
            return "/register/register";
        }

        String userId = userService.queryUserByUsername(user.getUsername());

        if (!StringUtils.isEmpty(userId) || userId != null){
            model.addAttribute("error", "用户名已存在");
            return "register/register";
        }
        userService.saveUser(user.getUsername(), user.getPassword(),user.getStatus());

        return "/login/login";
    }
}
