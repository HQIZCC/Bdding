package bs.qch.budding.mapper;

import org.apache.ibatis.annotations.Param;

public interface UserMapper {

	public void saveUser(@Param("userId")String userId, @Param("username") String username, @Param("password") String password, @Param("role") Integer role);

	public String queryUserByUsername(String username);

	public String finUserByUPR(@Param("username") String username, @Param("md5Password") String md5Password);

	public void saveUserDesc(@Param("userId") String userId, @Param("realname") String realname, @Param("nickname") String nickname, @Param("email") String email, @Param("telphone") String telphone,
			@Param("address") String address);
	
}
