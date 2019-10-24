import dao.HibernateDao;
import dao.impl.HibernateDaoImpl;
import domain.Person;
import org.junit.Test;

/**
 * @Auther: sise.xgl
 * @Date: 2019/10/22/11:05
 * @Description:
 */

public class HiernateTest {

        HibernateDao hibernateDao = new HibernateDaoImpl();

        @Test
        public void addPerson(){
            Person person1 = new Person();
            person1.setName("Jack");
            person1.setSno("200192001");
            person1.setSex('男');
            person1.setAge(22);
            Person person2 = new Person();
            person2.setName("John");
            person2.setSno("20192001");
            person2.setSex('女');
            person2.setAge(22);
            hibernateDao.addPerson(person1);
            hibernateDao.addPerson(person2);
        }

        @Test
        public void getPersonById(){
           // Person p1 = hibernateDao.getPersonById(1);
           // System.out.println(p1.getId()+"."+p1.getName()+":"+p1.getAge());
            Person p2 = hibernateDao.getPersonById(2);
            System.out.println(
                            "学号："+p2.getSno()+ "\n"+
                            "姓名："+p2.getName()+"\n"+
                            "性别："+p2.getSex()+"\n"+
                            "年龄："+p2.getAge()
            );
        }

        @Test
        public void updatePerson(){
            Person person = hibernateDao.getPersonById(2);
            person.setAge(39);
            hibernateDao.updatePerson(person);
            System.out.println("修改后："+person.getId()+"."+person.getName()+":"+person.getAge());
        }

        @Test
        public void deletePerson(){
            Person p2 = hibernateDao.getPersonById(1);
            hibernateDao.deletePerson(p2);
            Person p22 = hibernateDao.getPersonById(1);
            if(p22==null) System.out.println("Sorry,John已被删除！");

        }
}
