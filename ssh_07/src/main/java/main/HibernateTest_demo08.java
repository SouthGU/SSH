package main;

import dao.HibernateDao_demo08;
import dao.impl.HibernateDaoImpl_demo08;
import domain.demo08.Person_demo08;
import domain.demo08.Student_demo08;
import domain.demo08.Worker_demo08;

import java.util.List;

/**
 * @Auther: sise.xgl
 * @Date: 2019/10/22/23:27
 * @Description:
 */
public class HibernateTest_demo08 {
    public static void main(String[] args) {
        Person_demo08 person_demo08 = new Person_demo08("何洁","女",23);
        Worker_demo08 worker_demo08 = new Worker_demo08("SD0001","李然","女",28,6000);
        Student_demo08 student_demo08 = new Student_demo08("SD0001","王浩","男",19,"广大华软");
        HibernateDao_demo08 hibernateDao_demo08 = new HibernateDaoImpl_demo08();
        hibernateDao_demo08.addPerson_demo08(person_demo08);
        hibernateDao_demo08.addPerson_demo08(worker_demo08);
        hibernateDao_demo08.addPerson_demo08(student_demo08);
        String hql = "from Person_demo08";
        List<Person_demo08> person_demo08s = hibernateDao_demo08.getAllPerson_demo08(hql);
        System.out.println("===========所有人信息=========");
        for (Person_demo08 p : person_demo08s) {
            System.out.println("姓名:"+p.getName()+",性别："+p.getSex()+",年龄："+p.getAge());
        }

        hql = "from Worker_demo08";
        List<Worker_demo08> Worker_demo08s = hibernateDao_demo08.getAllPerson_demo08(hql);
        System.out.println("==========工人信息=======");
        for (Worker_demo08 w : Worker_demo08s){
            System.out.println("姓名："+w.getName()+"，性别："+w.getSex()+"，年龄："+w.getAge()+"，工号："+w.getNo()+"，薪水："+w.getSalary());
        }

        hql = "from Student_demo08";
        List<Student_demo08> student_demo08s = hibernateDao_demo08.getAllPerson_demo08(hql);
        System.out.println("============学生信息==========");
        for(Student_demo08 s : student_demo08s){
            System.out.println("姓名："+s.getName()+"，性别"+s.getSex()+"，年龄"+s.getAge()+"，学号"+s.getSno()+"学校："+s.getSchool());
        }
    }
}
