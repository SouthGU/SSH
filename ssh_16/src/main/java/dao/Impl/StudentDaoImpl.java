package dao.Impl;

import dao.StudentDao;
import domain.Student;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Auther: sise.xgl
 * @Date: 2019/10/24/9:13
 * @Description:
 */

public class StudentDaoImpl  implements StudentDao {
    @Resource
    HibernateTemplate hibernateTemplate;
    public Student getStudent(int id) {
        return hibernateTemplate.get(Student.class,id);
    }

    public void saveOrUpdateStudent(Student student) {
        hibernateTemplate.saveOrUpdate(student);
    }

    public void removeStudent(Student student) {
        hibernateTemplate.delete(student);
    }
}
