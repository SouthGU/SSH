package domain.demo08;

/**
 * @Auther: sise.xgl
 * @Date: 2019/10/22/23:08
 * @Description:
 */
public class Student_demo08  extends  Person_demo08{
    private String sno;
    private String school;

    public Student_demo08() {}
    public Student_demo08(String sno, String name, String sex, int age , String school) {
        super(name,sex,age);
        this.sno = sno;
        this.school = school;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}
