import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther: sise.xgl
 * @Date: 2019/10/23/20:52
 * @Description:
 */
public class SpringTest {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        PersonServiceBean psb = (PersonServiceBean)ctx.getBean("personServiceBean");
        psb.sayhello("李四");
    }
}
