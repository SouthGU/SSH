package bean;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
public class Category {
    private Integer id;
    private String CategoryName;
    private Set<News> newses;
}
