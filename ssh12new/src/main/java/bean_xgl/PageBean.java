package bean_xgl;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class PageBean<T> {
    private int page;//当前页数
    private int totalCount;//总记录数
    private int totalPage;//总页数
    private int limit;//每页显示的记录数
    private List<T> list;//每页显示数据的集合
}
