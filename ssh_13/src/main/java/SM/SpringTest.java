package SM;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther: sise.xgl
 * @Date: 2019/10/23/21:26
 * @Description:
 */
public class SpringTest {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        //set注入和构造器注入为同一命名
        //PersonService personService = (PersonService) ctx.getBean("personServiceBean");

        //自动扫描机制开启-->目前是开启自动扫描，自主修改applicationContext.xml选择后注入方式
        PersonService personService = (PersonService) ctx.getBean("personServiceSM");

        personService.printMsg();
        System.out.println("-----");
        personService.persist();
    }
}
