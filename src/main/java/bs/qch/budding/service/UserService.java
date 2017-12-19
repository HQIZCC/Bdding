package bs.qch.budding.service;

public interface UserService {
    public void saveUser(String username, String password, String status);

    public String queryUser(String username, String password);

    public String queryUserByUsername(String username);
}
