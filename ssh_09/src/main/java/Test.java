import com.sun.org.apache.xpath.internal.operations.Or;
import dao.HibernateDao;
import dao.HibernateDaoImpl;
import domain.Order;
import domain.OrderItem;
import domain.Product;

/**
 * @Auther: sise.xgl
 * @Date: 2019/10/24/23:38
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        HibernateDao hibernateDao = new HibernateDaoImpl();
        Order order1 = new Order("李浩然","13015978361","广大华软","510990");
        Order order2 = new Order("李明","1591238362","清华大学","530250");

        //手动设置数据库后调用，修改。
//        Product product1 =  hibernateDao.findProductById(1);
//        Product product2 =  hibernateDao.findProductById(2);
//        Product product3 =  hibernateDao.findProductById(3);

        //调用插入方法，将Product数据插入到数据库中
        Product product1 = new Product();
        product1.setName("ThinkPad笔记本电脑");
        product1.setPrice(6780.0);
        product1.setDescription("ThinkPad笔记本电脑散热性能好");
        Product product2 = new Product();
        product2.setName("32寸长虹彩电");
        product2.setPrice(3699.0);
        product2.setDescription("长虹彩电的性价比高");
        Product product3 = new Product();
        product3.setName("39寸TCL彩电");
        product3.setPrice(3600.0);
        product3.setDescription("TCL彩电的性价比天下无敌");
        hibernateDao.addProduct(product1);
        hibernateDao.addProduct(product2);
        hibernateDao.addProduct(product3);


        OrderItem item1 = new OrderItem(order1,product1,100,6000);
        OrderItem item2 = new OrderItem(order1,product2,200,3000);
        OrderItem item3 = new OrderItem(order2,product1,60,6200);
        OrderItem item4 = new OrderItem(order2,product3,30,3300);

        double total1 = 100 * 6000 + 200 * 3000;
        double total2 = 60 * 6200 + 30 * 3300 ;

        order1.setToatal(total1);
        order2.setToatal(total2);

        //设置订单和订单项的一对多关联关系
        order1.getOrderItem().add(item1);
        order1.getOrderItem().add(item2);
        order2.getOrderItem().add(item3);
        order2.getOrderItem().add(item4);

        //设置商品和订单项的单向一对多关联关系
        item1.setProduct(product1);
        item2.setProduct(product2);
        item3.setProduct(product3);

        hibernateDao.addOrder(order1);
        hibernateDao.addOrder(order2);

        Order order666 = hibernateDao.findOrderById(1);
        System.out.println("订单号："+ order666.getId());

        System.out.println("订单总金额："+order666.getToatal());
        System.out.println("该订单共购买了以下商品：");
        for (OrderItem items : order666.getOrderItem()){
            System.out.println("商品名："+items.getProduct().getName());
        }
    }


}
