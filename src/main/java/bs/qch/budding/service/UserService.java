package bs.qch.budding.service;

public interface UserService {

	// 注册用户
	public boolean saveUser(String username, String password, Integer role);

	// 通过用户名查询是否该用户民已经存在了
	public String queryUserByUsername(String username);

	// 通过用户民，密码，角色查询是否存在用户
	public String findUserByUPR(String username, String password );

	// 完善登录信息
	public void saveUserDesc(String realname, String nickname, String email, String telphone, String address);
    
}
