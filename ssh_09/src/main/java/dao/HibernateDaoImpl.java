package dao;

import domain.Order;
import domain.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

/**
 * @Auther: sise.xgl
 * @Date: 2019/10/24/23:44
 * @Description:
 */
public class HibernateDaoImpl implements HibernateDao {
    public Product findProductById(int id) {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        Product product = (Product) session.get(Product.class, id);
        tx.commit();
        return product;
    }

    public void addOrder(Order order) {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        try {
            session.persist(order);
            tx.commit();
        } catch (Exception e) {
            if (null != tx) tx.rollback();
            e.printStackTrace();
        }
    }

    public Order findOrderById(int id){
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        Order order = (Order) session.get(Order.class, id);
        tx.commit();
        return order;
    }

    public void addProduct(Product product) {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        try {
            session.persist(product);
            tx.commit();
        } catch (Exception e) {
            if (null != tx) tx.rollback();
            e.printStackTrace();
        }
    }
}
