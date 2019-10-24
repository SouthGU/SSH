package com;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: sise.xgl
 * @Date: 2019/10/24/14:55
 * @Description:
 */

public interface PersonService {
    public void addPerson(Person person);
    public void updatePerson(Integer id);
    public void removePerson(Integer id);
    public List<Person> findAllPerson();
    public Person findById(Integer id);
}
