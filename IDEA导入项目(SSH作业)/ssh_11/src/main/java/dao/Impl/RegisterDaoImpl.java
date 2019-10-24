package dao.Impl;

import dao.RegisterDao;
import domain.Register;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateUtil;

import java.util.List;

/**
 * @Auther: sise.xgl
 * @Date: 2019/10/23/18:41
 * @Description:
 */
public class RegisterDaoImpl implements RegisterDao {
    public void addRegister(Register register) {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        try {
            session.persist(register);
            tx.commit();
        }catch (Exception e){
            tx.rollback();
            e.printStackTrace();
        }

    }

    @Override
    public List<Register> getAllRegister() {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("FROM Register");
        List<Register> users = query.list();
        tx.commit();
        return users;
    }
}
