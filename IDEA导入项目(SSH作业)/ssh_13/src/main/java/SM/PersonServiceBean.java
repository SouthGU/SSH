package SM;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Auther: sise.xgl
 * @Date: 2019/10/23/21:19
 * @Description:
 */
@Service("personServiceSM")
public class PersonServiceBean implements PersonService {
    private String name;
    private int age;

    //自动扫描
    @Resource
    private PersonDao personDao;
    public PersonServiceBean(){
        this.name = "李四";
        this.age = 33;
    }

    //构造器注入
    public PersonServiceBean(String name, int age, PersonDao personDao) {
        this.name = name;
        this.age = age;
        this.personDao = personDao;
    }

    //以下为set注入
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }


    public void persist() {
        personDao.insert();
    }

    public void printMsg() {
        System.out.println("姓名："+name );
        System.out.println("年龄："+age);
    }





}
