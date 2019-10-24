package dao.impl;

import dao.HibernateDao;
import domain.Person;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

/**
 * @Auther: sise.xgl
 * @Date: 2019/10/22/11:00
 * @Description:
 */
public class HibernateDaoImpl implements HibernateDao {
    public void addPerson(Person person) {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        try {
        session.persist(person);
        tx.commit();
        }catch (Exception e){
            if(null!=tx) tx.rollback();
            e.printStackTrace();
        }
    }

    public void updatePerson(Person person) {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        try {
            session.update(person);
            tx.commit();
        }catch (Exception e){
            if(null!=tx) tx.rollback();
            e.printStackTrace();
        }
    }

    public void deletePerson(Person person) {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        try {
            session.delete(person);
            tx.commit();
        }catch (Exception e){
            if(null!=tx) tx.rollback();
            e.printStackTrace();
        }
    }

    public Person getPersonById(Integer id) {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        Person person = (Person) session.get(Person.class, id);
        tx.commit();
        return person;
    }
}
