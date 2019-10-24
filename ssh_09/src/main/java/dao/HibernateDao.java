package dao;

import domain.Order;
import domain.Product;

/**
 * @Auther: sise.xgl
 * @Date: 2019/10/24/23:43
 * @Description:
 */
public interface HibernateDao {

    public Product findProductById(int id);

    public void addOrder(Order order);

    public Order findOrderById(int id);

}
