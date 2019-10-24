package domain;

import java.io.Serializable;

/**
 * @Auther: sise.xgl
 * @Date: 2019/10/24/23:17
 * @Description:
 */
public class OrderItem implements Serializable {
    private Integer id;
    private Order order;
    private Product product;
    private int quantity;
    private double purchase;

    public OrderItem() {
    }

    public OrderItem(Order order, Product product, int quantity, double purchase) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.purchase = purchase;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPurchase() {
        return purchase;
    }

    public void setPurchase(double purchase) {
        this.purchase = purchase;
    }
}
