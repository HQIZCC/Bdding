package bs.qch.budding.pojo;

public class User {

	private String userId; // �û�id
	private String username; // �û���
	private String password; // �û�����
	private Integer role; // 1.�����б귽�� 0����Ͷ�귽

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
