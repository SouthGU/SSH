package dao;

import domain.demo08.Person_demo08_02;
import domain.demo08.Person_demo08_03;

import java.util.List;

/**
 * @Auther: sise.xgl
 * @Date: 2019/10/22/23:21
 * @Description:
 */
public interface HibernateDao_demo08_03 {
    public void addPerson_demo08(Person_demo08_03 person_demo08_03);
    @SuppressWarnings("unchecked")
    public List getAllPerson_demo08(String hql);
}
