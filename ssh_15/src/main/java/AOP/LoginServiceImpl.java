package AOP;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @Auther: sise.xgl
 * @Date: 2019/10/23/22:54
 * @Description:
 */

@Component("LoginServiceImpl")
public class LoginServiceImpl implements LoginService {
    public LoginServiceImpl() {
    }

    public void login(String name) {
        System.out.println("执行login()方法 : ");
    }
}
