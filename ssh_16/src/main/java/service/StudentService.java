package service;

import domain.Student;

/**
 * @Auther: sise.xgl
 * @Date: 2019/10/24/9:29
 * @Description:
 */
public interface StudentService {
    public void saveStudent(Student student);
    public void updateStudent(Student student);
    public void deleteStudent(int id) throws Exception;
    public Student findStudentById(int id);

}
