package action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import bean.User;
import lombok.Data;
import service.AdminService;


@Data
public class LoginAction extends ActionSupport implements ModelDriven {

    private AdminService adminService;


    private User user;

    @Override
    public Object getModel() {
        return user;
    }

    public String login()throws Exception{
        if (adminService.isUser(user)==true)return SUCCESS;
            addFieldError("user.username","用户名或密码错误");
            return INPUT;
    }
}
