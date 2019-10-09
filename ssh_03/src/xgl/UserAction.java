package xgl;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven{

	private User user = new User();
	
	public Object getModel() {
		return user;
	}
	
	public String execute() throws Exception {
		ActionContext ctx = ActionContext.getContext();
		Map session = ctx.getSession();
		if(user.getUsername()!=null&&user.getUsername().equals("admin")&&user.getPassword()!=null&&user.getPassword().equals("sise")){
			
			session.put("username", user.getUsername());
			return SUCCESS;
		}else{
			addFieldError("username", "用户名或密码错误");
			return LOGIN;
		}
	}
	
	public String addUser(){
		return "add";
	}
	

}
