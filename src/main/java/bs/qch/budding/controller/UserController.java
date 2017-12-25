package bs.qch.budding.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import bs.qch.budding.pojo.User;
import bs.qch.budding.pojo.UserDesc;
import bs.qch.budding.service.UserService;
import bs.qch.budding.utils.Md5;

// 操作用户
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	// 注册操作
	@RequestMapping("/register.action")
	public String toRegister(User user, Model model){
		
		// 一项为空，就重新注册
		if (StringUtils.isEmpty(user.getUsername() ) || StringUtils.isEmpty(user.getPassword()) || StringUtils.isEmpty(user.getRole())) {
			
			model.addAttribute("error", "用户民，密码或者角色不能为空");
			return "register/register";
		}
		
		String md5Password = null;
		
		try {
			md5Password = Md5.EncoderByMd5(user.getPassword());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return "register/register";
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return "register/register";
		}
		
		// 判断当前是否已经有了这个公司
		String username = userService.queryUserByUsername(user.getUsername());
		
		if(username != null){
			
			model.addAttribute("error", "当前用户名已存在，请重新注册");
			
			return "register/register"; 
		}
		
		if(userService.saveUser(user.getUsername(), md5Password, user.getRole())){
			
			model.addAttribute("error", "请求超时，请重新注册");
			
			return "register/register";
		}else{
			
			model.addAttribute("error", "注册成功，请登录");
			
			return "/login/login";
		}
	}
	
	// 登录操作，并将信息保存到cookie中
	@RequestMapping("/login.action")
	public String toLogin(User user, Model model , HttpSession session){
		
		String role = userService.findUserByUPR(user.getUsername(), user.getPassword() );
		
		if(role == null){
			model.addAttribute("error", "帐号密码可能出错,请重新登录");
			return "login/login";
		}
		
		user.setRole(Integer.parseInt(role));
		
		session.setAttribute("userSession", user);
		
		model.addAttribute("username", user.getUsername());
		
		// 跳转到填写用户详情页面
		return "index";
		
	}

	// 跳转到用户详情展示效果
    @RequestMapping("/toUserDesc.action")
    public String toUserDesc(Model model, HttpSession session){
    	
    	User user = (User) session.getAttribute("userSession");
    	
    	String username = user.getUsername();
    	
    	model.addAttribute("username", username);
    	
    	return "login/userdesc";
    }
    
    // 完善详细信息
    @RequestMapping("/toFinshUserDesc.action")
    public String toFinshUserDesc(UserDesc userDesc, Model model, HttpSession session){
    	
    	
    	if(StringUtils.isEmpty(userDesc.getRealname()) || StringUtils.isEmpty(userDesc.getNickname())
    			|| StringUtils.isEmpty(userDesc.getEmail()) || StringUtils.isEmpty(userDesc.getTelphone())
    			|| StringUtils.isEmpty(userDesc.getAddress())){
    		
    		model.addAttribute("error", "所填写的项目均不能为空，请完善");
    		
    		return "login/userdesc";
    	}
    	
    	User user = (User) session.getAttribute("userSession");
    	
    	model.addAttribute("username", user.getUsername());
    	
    	userService.saveUserDesc(userDesc.getRealname(), userDesc.getNickname(), userDesc.getEmail(), userDesc.getTelphone(), userDesc.getAddress());
    	
    	return "index";
    }
    
}






































