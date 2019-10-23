package test;

import dao.UserDao;
import domain.User;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class UserDaoTest {

    private UserDao userDao = new UserDao();

    @Test
    public void save() {
        User user = new User();
        user.setUsername("HIBERNATE");
        user.setBirthday(new Date());
        user.setSex("妖");
        user.setAddress("BEIJING");
        userDao.save(user);
    }

    @Test
    public void update() {
        User byId = userDao.getById(1);
        byId.setSex("人");
        userDao.update(byId);
    }

    @Test
    public void delete() {
        userDao.delete(63);
    }

    @Test
    public void getById() {
        System.out.println(userDao.getById(63));
    }

    @Test
    public void findAll() {
        List<User> list = userDao.findAll();
        for (User user : list) {
            System.out.println(user);
        }
    }




}
