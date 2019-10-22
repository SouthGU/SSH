package main;

import dao.HibernateDao_demo08;
import dao.HibernateDao_demo08_02;
import dao.impl.HibernateDaoImpl_demo08;
import dao.impl.HibernateDaoImpl_demo08_02;
import domain.demo08.*;

import java.util.List;


/**
 * @Auther: sise.xgl
 * @Date: 2019/10/23/0:43
 * @Description:
 */
public class HibernateTest_demo08_02 {
    public static void main(String[] args) {
    Worker_demo08_02 worker_demo08_02 = new Worker_demo08_02("P00001","李然","女",28,6000);
    Student_demo08_02 student_demo08_02 = new Student_demo08_02("王浩","男",19,"SP001","广大华软");
    HibernateDao_demo08_02 hibernateDao_demo08 = new HibernateDaoImpl_demo08_02();
    hibernateDao_demo08.addPerson_demo08(worker_demo08_02);
    hibernateDao_demo08.addPerson_demo08(student_demo08_02);

    String hql="from Person_demo08_02";
    List<Person_demo08_02> person_demo08_02s = hibernateDao_demo08.getAllPerson_demo08(hql);
        System.out.println("=======================学生和工人信息==================");
        for(Person_demo08_02 p : person_demo08_02s){
            System.out.println("姓名："+p.getName()+",性别："+p.getSex()+",年龄："+p.getAge());
        }

        hql="from Worker_demo08_02";
        List<Worker_demo08_02> worker_demo08_02s = hibernateDao_demo08.getAllPerson_demo08(hql);
        System.out.println("=======================工人信息==================");
        for(Worker_demo08_02 w : worker_demo08_02s){
            System.out.println("姓名："+w.getName()+",性别："+w.getSex()+",年龄："+w.getAge()+"，工号："+w.getNo()+"，薪水："+w.getSalary());
        }

        hql="from Student_demo08_02";
        List<Student_demo08_02> student_demo08_02s = hibernateDao_demo08.getAllPerson_demo08(hql);
        System.out.println("=======================工人信息==================");
        for(Student_demo08_02 s : student_demo08_02s){
            System.out.println("姓名："+s.getName()+",性别："+s.getSex()+",年龄："+s.getAge()+"，学号："+s.getSno()+"，学校："+s.getSchool());
        }
    }






}
