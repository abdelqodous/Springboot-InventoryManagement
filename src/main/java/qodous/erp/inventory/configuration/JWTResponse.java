package qodous.erp.inventory.configuration;

public class JWTResponse {

	private String token;
	private String userName;
	private String password;
	private String status;
	
	public JWTResponse() {
		
	}
	
	public JWTResponse(String token, String userName, String password, String status) {
		super();
		this.token = token;
		this.userName = userName;
		this.password = password;
		this.status = status;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	@Override
	public String toString() {
		return "$$.. JWTResponse [token=" + token + ", userName=" + userName + ", password=" + password + ", status="
				+ status + "]";
	}
	
}
