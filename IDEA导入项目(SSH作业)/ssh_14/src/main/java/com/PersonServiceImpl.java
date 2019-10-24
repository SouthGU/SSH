package com;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: sise.xgl
 * @Date: 2019/10/24/14:57
 * @Description:
 */
@Transactional(readOnly = false)
public class PersonServiceImpl  implements PersonService{
    @Resource
    private PersonDao personDao;

    public void addPerson(Person person){
        personDao.saveOrUpdatePerson(person);
    }

    public void updatePerson(Integer id){
        Person person = findById(id);
        person.setName("AAA");
        personDao.saveOrUpdatePerson(person);
    }

    public void removePerson(Integer id){
        Person person = findById(id);
        personDao.removePerson(person);
    }

    public List<Person> findAllPerson(){
        return personDao.getPersons();
    }



    public Person findById(Integer id){
        return personDao.getPerson(id);
    }
}

