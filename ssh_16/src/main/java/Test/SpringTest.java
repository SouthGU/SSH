package Test;

import domain.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.StudentService;

/**
 * @Auther: sise.xgl
 * @Date: 2019/10/24/9:46
 * @Description:
 */
public class SpringTest {
    static ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    static StudentService studentService = (StudentService)ctx.getBean("studentService");
    public static void main(String[] args) {
        addStudent();
        //updateStudent(1);
        //deleteStudent(1);

    }

    private static void addStudent() {
        Student student = new Student();
        student.setName("张三");
        Student student1 = new Student();
        student1.setName("李四");
        studentService.saveStudent(student);
        studentService.saveStudent(student1);
    }
    private static void deleteStudent(int id) {
        try {
            studentService.deleteStudent(id);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private static void updateStudent(int id) {
        Student student = studentService.findStudentById(id);
        student.setName("李四Update");
        studentService.updateStudent(student);
    }
}
