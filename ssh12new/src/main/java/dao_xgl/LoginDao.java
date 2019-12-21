package dao_xgl;

import bean_xgl.User;

import java.util.List;

public interface LoginDao {
    //判断用户是否存在
    public List<User> isUser(User user);
}
