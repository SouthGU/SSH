package demo01;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	private String username;
	private String password;
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
	
	public String execute(){
		if("admin".equals(username.trim()) && "sise".equals(password.trim())){
			return SUCCESS;
		}else {
			this.addFieldError("username", "用户名或密码错误！");
			return LOGIN;
		}
	}
	
	public void validate(){
		if(null==username || username.trim().length()==0)
			this.addFieldError("username", "用户名必须输入");
		if(null==password || username.trim().length()==0)
			this.addFieldError("password", "用户名必须输入");
	}

}
