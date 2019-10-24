package domain;

import java.util.HashSet;
import java.util.Set;

/**
 * @Auther: sise.xgl
 * @Date: 2019/10/24/23:16
 * @Description:
 */
public class Order {
    private Integer id;
    private double toatal;
    private String realname;
    private String phone;
    private String address;
    private String postcode;
    private Set<OrderItem> orderItem = new HashSet<OrderItem>();

    public Order() {
    }

    public Order(String realname, String phone, String address, String postcode) {
        this.realname = realname;
        this.phone = phone;
        this.address = address;
        this.postcode = postcode;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getToatal() {
        return toatal;
    }

    public void setToatal(double toatal) {
        this.toatal = toatal;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public Set<OrderItem> getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(Set<OrderItem> orderItem) {
        this.orderItem = orderItem;
    }
}
