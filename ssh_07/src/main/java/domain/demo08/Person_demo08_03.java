package domain.demo08;

/**
 * @Auther: sise.xgl
 * @Date: 2019/10/23/0:04
 * @Description:
 */
public   class Person_demo08_03 {
    private int id;
    private String name;
    private String sex;
    private int age;

    public Person_demo08_03() {
    }

    public Person_demo08_03(String name, String sex, int age) {

        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
