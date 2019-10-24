package dao;

import domain.demo08.Person_demo08;

import java.util.List;

/**
 * @Auther: sise.xgl
 * @Date: 2019/10/22/23:21
 * @Description:
 */
public interface HibernateDao_demo08 {
    public void addPerson_demo08(Person_demo08 person_demo08);
    @SuppressWarnings("unchecked")
    public List getAllPerson_demo08(String hql);
}
