package daoImp_xgl;

import dao_xgl.LoginDao;
import lombok.Data;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @Auther: sise.xgl
 * @Date: 2019/12/3/12:41
 * @Description:
 */
@Data
public class LoginDaoImp implements LoginDao {
    @Autowired
    public SessionFactory sessionFactory;
}
