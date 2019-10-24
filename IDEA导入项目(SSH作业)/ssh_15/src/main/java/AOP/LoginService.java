package AOP;

import org.springframework.stereotype.Service;

/**
 * @Auther: sise.xgl
 * @Date: 2019/10/23/22:53
 * @Description:
 */
@Service
public interface LoginService {
    public void login(String name);
}
