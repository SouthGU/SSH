package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @Auther: sise.xgl
 * @Date: 2019/10/24/15:05
 * @Description:
 */
public class SpringTest {
    private static ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    private static PersonService personService = (PersonService) ctx.getBean("personService");

    public static void main(String[] args) {
        //add();
        //findPersonById(3);
        //更新：数据库需有数据，这里没有设置事物判断语句
        //update(5);
        //delete(5);
        findAllpersons();
    }

    private static void add(){
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
    }

    private static void findPersonById(Integer id){
        Person person = personService.findById(id);
        System.out.println("编号："+person.getId()+"的姓名是："+person.getName());
    }

    private static void findAllpersons(){
        List<Person> persons = personService.findAllPerson();
        for (Person person :
             persons) {
            System.out.println(person.getId()+". "+person.getName());
        }
    }

    private static void update(Integer id){
        personService.updatePerson(id);
        Person person = personService.findById(id);
        System.out.println(person.getName());
    }

    private static void delete(Integer id){
        personService.removePerson(id);
        System.out.println("成功删除编号为："+id+"的数据");
    }
}
