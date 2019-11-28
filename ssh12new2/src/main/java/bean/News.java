package bean;

import lombok.Getter;
import lombok.Setter;

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
