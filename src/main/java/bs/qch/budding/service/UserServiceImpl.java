package bs.qch.budding.service;

import bs.qch.budding.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    public void saveUser(String username, String password, String status) {
        userMapper.saveUser(username, password, status);
    }

    public String queryUser(String username, String password) {

        return userMapper.findUser(username, password);
    }

    public String queryUserByUsername(String username) {
        return userMapper.queryUserByUsername(username);
    }
}
