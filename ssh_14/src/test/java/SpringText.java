import com_xgl.Person;
import com_xgl.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @Auther: sise.xgl
 * @Date: 2019/12/4/22:11
 * @Description:
 */
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class SpringText {

    @Resource
    PersonService personService;

    @Test
    public void add(){
        Person p1 = new Person();
        p1.setName("张三");
        personService.addPerson(p1);
        Person p2 = new Person();
        p2.setName("李四");
        personService.addPerson(p2);
        Person p3 = new Person();
        p3.setName("王五");
        personService.addPerson(p3);
        Person p4 = new Person();
        p4.setName("赵六");
        personService.addPerson(p4);
        List<Person> persons = personService.findAllPerson();
        for (Person person :
                persons) {
            System.out.println(person.getId()+". "+person.getName());
        }
    }
}
