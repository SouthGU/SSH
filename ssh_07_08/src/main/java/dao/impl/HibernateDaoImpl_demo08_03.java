package dao.impl;

import dao.HibernateDao_demo08_02;
import dao.HibernateDao_demo08_03;
import domain.demo08.Person_demo08_02;
import domain.demo08.Person_demo08_03;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateUtil;

import java.util.List;

/**
 * @Auther: sise.xgl
 * @Date: 2019/10/22/23:23
 * @Description:
 */
public class HibernateDaoImpl_demo08_03 implements HibernateDao_demo08_03 {
    public void addPerson_demo08(Person_demo08_03 person_demo08_03) {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(person_demo08_03);
            tx.commit();
        }catch (Exception e){
            if(null!=tx) tx.rollback();
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public List getAllPerson_demo08(String hql) {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery(hql);
        List person_demo08 = query.list();
        tx.commit();
        return person_demo08;
    }
}
