package bs.qch.budding.pojo;

public class User {

	private String userId; // 用户id
	private String username; // 用户名
	private String password; // 用户密码
	private Integer role; // 1.代表招标方， 0代表投标方

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

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

}
