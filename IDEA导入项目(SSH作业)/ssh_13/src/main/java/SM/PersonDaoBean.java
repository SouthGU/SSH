package SM;

import org.springframework.stereotype.Repository;

/**
 * @Auther: sise.xgl
 * @Date: 2019/10/23/21:22
 * @Description:
 */

//自动扫描-->注解
@Repository
public class PersonDaoBean implements PersonDao {

    public void insert() {
        System.out.println("持久化以上数据");
    }
}
