package domain.demo08;

/**
 * @Auther: sise.xgl
 * @Date: 2019/10/22/22:58
 * @Description:
 */
public class Worker_demo08 extends Person_demo08 {
    private String no;
    private double salary;
    public Worker_demo08(){}
    public Worker_demo08(String no, String name, String sex, int age , double salary) {
        super(name,sex,age);
        this.no = no;
        this.salary = salary;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
