package bs.qch.budding.mapper;

import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    // 注册
    public void saveUser(@Param("username") String username, @Param("password") String password, @Param("status") String status);

    // 登录
    public String findUser(@Param("username") String username, @Param("password") String password);

    public String queryUserByUsername(String username);
}
