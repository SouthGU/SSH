package dao;

import domain.Student;

/**
 * @Auther: sise.xgl
 * @Date: 2019/10/24/9:10
 * @Description:
 */
public interface StudentDao {
    public Student getStudent(int id);
    public void saveOrUpdateStudent(Student student);
    public void removeStudent(Student student);
}
