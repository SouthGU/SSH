package AOP;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther: sise.xgl
 * @Date: 2019/10/23/22:56
 * @Description:
 */
public class SpringAOPTest {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        LoginService loginService = (LoginService) ctx.getBean("LoginServiceImpl");
        //loginService.login("AAA");
        loginService.login("sise");
    }
}
