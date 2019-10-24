package service.Impl;

import dao.StudentDao;
import domain.Student;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import service.StudentService;

import javax.annotation.Resource;

/**
 * @Auther: sise.xgl
 * @Date: 2019/10/24/9:31
 * @Description:
 */
@Transactional
public class StudentServiceImpl implements StudentService {
    @Resource
    StudentDao studentDao;

    //新开事务 --> REQUIRES_NEW新开一个事务，即使用自己的事务，调用的事方法的事务被挂起
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveStudent(Student student) {
        studentDao.saveOrUpdateStudent(student);
    }

    //使用readOnly指定事务是否为只读，表示这个事务只读数据但不更新数据，
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Student findStudentById(int id) {
        return studentDao.getStudent(id);
    }



    //回滚规则属性，遇到指定的异常类时回滚，@Transactional (rollbackFor={SQLException.class})
    @Transactional(rollbackFor = Exception.class)
    public void deleteStudent(int id) throws Exception {
        try {
        Student student = findStudentById(id);
        //测试应用异常开启以下错误代码 --> 控制台打印应用异常
        //int i = 1 / 0 ;
        studentDao.removeStudent(student);
        }catch (Exception e){
            throw new Exception("应用异常");
        }

    }

    //默认取值为REQUIRED,即使用调用方法的事务
    //在@Transactional注解中如果不配置rollbackFor属性,那么事物只会在遇到RuntimeException的时候才会回滚,
    //加上rollbackFor=Exception.class,可以让事物在遇到非运行时异常时也回滚
    //回滚规则属性，遇到指定的异常类时不回滚，@Transactional (noRollbackFor={RuntimException.class})
    @Transactional(noRollbackFor = RuntimeException.class)
    public void updateStudent(Student student) {
        try {
        //int i = 1 / 0;
        studentDao.saveOrUpdateStudent(student);
        }catch (RuntimeException e) {
            throw new RuntimeException("运行时异常");
        }
    }

}
