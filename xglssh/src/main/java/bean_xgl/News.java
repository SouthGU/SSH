package bean_xgl;

import lombok.Getter;
import lombok.Setter;

/**
 * @Auther: sise.xgl
 * @Date: 2019/12/3/11:22
 * @Description:
 */
@Setter
@Getter
public class News {
    private int id;
    private String title;
    private String content;
    private String issueTime;
    private Category category;
    private String source;


}
