package com;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: sise.xgl
 * @Date: 2019/10/24/15:31
 * @Description:
 */

public class PersonDaoImpl2 extends HibernateDaoSupport implements PersonDao{


    public List<Person> getPersons() {
        List<Person> persons = (List<Person>)getHibernateTemplate().find("from Person");
        return persons;
    }

    public Person getPerson(Integer pid) {
        return getHibernateTemplate().get(Person.class,pid);
    }

    public void saveOrUpdatePerson(Person person) {
        getHibernateTemplate().saveOrUpdate(person);
    }

    public void removePerson(Person person) {
        getHibernateTemplate().delete(person);
    }
}
