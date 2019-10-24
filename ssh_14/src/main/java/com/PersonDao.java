package com;

import java.util.List;

/**
 * @Auther: sise.xgl
 * @Date: 2019/10/24/14:41
 * @Description:
 */
public interface PersonDao {
    public List<Person> getPersons();
    public Person getPerson(Integer pid);
    public void saveOrUpdatePerson(Person person);
    public void removePerson(Person person);

}
