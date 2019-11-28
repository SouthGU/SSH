package daoImp;

import bean.User;
import dao.LoginDao;
import lombok.Data;
import org.hibernate.SessionFactory;

import java.util.List;

@Data
public class LoginDaoImp implements LoginDao {
    private SessionFactory sessionFactory;
    @Override
    public List<User> isUser(User user) {
        List<User> user1 = sessionFactory.getCurrentSession().createQuery("from User u where u.username=:username and u.password = :password")
                .setParameter("username",user.getUsername())
                .setParameter("password",user.getPassword())
                .list();
        return user1;
    }
}
