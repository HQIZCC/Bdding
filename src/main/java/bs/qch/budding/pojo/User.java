package bs.qch.budding.pojo;

public class User {

    private String userId;      // 用户的id
    private String username;    // 用户名
    private String password;    // 用户密码
    private String status;     //  1 -- 招标单位  0-- 投标单位

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
