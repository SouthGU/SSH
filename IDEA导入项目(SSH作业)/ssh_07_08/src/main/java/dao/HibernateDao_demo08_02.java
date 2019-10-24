package dao;

import domain.demo08.Person_demo08;
import domain.demo08.Person_demo08_02;

import java.util.List;

/**
 * @Auther: sise.xgl
 * @Date: 2019/10/22/23:21
 * @Description:
 */
public interface HibernateDao_demo08_02 {
    public void addPerson_demo08(Person_demo08_02 person_demo08_02);
    @SuppressWarnings("unchecked")
    public List getAllPerson_demo08(String hql);
}
