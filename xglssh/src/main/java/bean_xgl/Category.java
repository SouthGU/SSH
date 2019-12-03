package bean_xgl;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 * @Auther: sise.xgl
 * @Date: 2019/12/3/11:21
 * @Description:
 */
@Setter
@Getter
public class Category {
    private Integer id;
    private String CategoryName;
    private Set<News> newses;


}
