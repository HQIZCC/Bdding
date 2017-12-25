package bs.qch.budding.service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bs.qch.budding.mapper.UserMapper;
import bs.qch.budding.pojo.User;
import bs.qch.budding.utils.Md5;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	public boolean saveUser(String username, String password, Integer role) {
		
		User user = new User();
		
		String userId = user.getUserId();
		
		userId = UUID.randomUUID().toString();
		
		try {
			userMapper.saveUser(userId, username, password, role);
			
			return false;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return true;
	}

	public String queryUserByUsername(String username) {
		
		return userMapper.queryUserByUsername(username);
		
	}

	public String findUserByUPR(String username, String password) {
		
		String md5Password = null;
		try {
			md5Password = Md5.EncoderByMd5(password);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String userId = userMapper.finUserByUPR(username, md5Password);
		
		return userId;
	}

	public void saveUserDesc(String realname, String nickname, String email, String telphone, String address) {
		
		String userId = UUID.randomUUID().toString();
		
		userMapper.saveUserDesc(userId, realname, nickname, email, telphone, address);
	}

}





































