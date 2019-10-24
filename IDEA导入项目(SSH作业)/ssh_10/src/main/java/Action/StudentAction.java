package Action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @Auther: sise.xgl
 * @Date: 2019/10/24/16:16
 * @Description:
 */
public class StudentAction extends ActionSupport {
    private String name;
    private String password;
    //省略get/set()方法
    public String execute()throws Exception{
        return "success";
    }
}

