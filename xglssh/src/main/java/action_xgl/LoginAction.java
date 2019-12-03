package action_xgl;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import service_xgl.AdminService;

/**
 * @Auther: sise.xgl
 * @Date: 2019/12/3/12:39
 * @Description:
 */
@Data
public class LoginAction {
    @Autowired
    public AdminService adminService;
}
