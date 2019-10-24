package dao;

import domain.Person;

/**
 * @Auther: sise.xgl
 * @Date: 2019/10/22/10:58
 * @Description:
 */
public interface HibernateDao {
    public void addPerson(Person person);
    public void updatePerson(Person person);
    public void deletePerson(Person person);
    public Person getPersonById(Integer id);
}
