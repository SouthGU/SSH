//package com;
//
//import org.springframework.orm.hibernate5.HibernateTemplate;
//
//import java.util.List;
//
///**
// * @Auther: sise.xgl
// * @Date: 2019/10/24/14:42
// * @Description:
// */
//public class PersonDaoImpl implements PersonDao {
//
//    private HibernateTemplate hibernateTemplate;
//    public void setHibernateTemplate(HibernateTemplate hibernateTemplate){
//        this.hibernateTemplate = hibernateTemplate;
//    }
//
//    public List<Person> getPersons() {
//        List<Person> persons = (List<Person>) hibernateTemplate.find("from Person");
//        return persons;
//    }
//
//    public Person getPerson(Integer pid) {
//        return hibernateTemplate.get(Person.class,pid);
//    }
//
//    public void saveOrUpdatePerson(Person person) {
//        hibernateTemplate.saveOrUpdate(person);
//    }
//
//    public void removePerson(Person person) {
//        hibernateTemplate.delete(person);
//    }
//}
