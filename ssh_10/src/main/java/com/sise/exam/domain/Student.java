package com.sise.exam.domain;

/**
 * @Auther: sise.xgl
 * @Date: 2019/10/24/16:47
 * @Description:
 */
public class Student {
    private Integer id;
    private String name;
    private String sno;
   //省略get/set()方法...
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }
}
