package service_xgl;

import bean_xgl.Category;
import bean_xgl.News;
import bean_xgl.PageBean;
import org.hibernate.stat.internal.CategorizedStatistics;

import java.util.Collection;
import java.util.List;

/**
 * @Auther: sise.xgl
 * @Date: 2019/12/3/12:51
 * @Description:
 */
public interface AdminService {

    //---------------------新闻类型操作接口------------------------
    
    //判断新闻类型是否存在
    public Boolean CategoryIsNull(Category category);

    //添加新闻类型
    public void addCategory(Category category);

    //查询所有的新闻类型
    List<Category> listCategory();

    //修改新闻类型前根据id查询新闻类型
    Category getCategoryByid(int id);

    //修改新闻类型
    void updateCategory(Category category);

    //由新闻类型查出所绑定的新闻列表
    List<News> listNewsByCategory(Category category);

    //删除新闻类型
    void deleteCategory(Category category);


    //---------------------新闻操作接口------------------------
    //添加新闻
    void addNews(News news);

    //更新新闻
    void updateNews(String title, String content, String source, Category c, int id);

    //获取新闻
    News getNewsByid(int id);

    //删除新闻
    void deleteNews(News news);

        //需要页码和新闻类型
    PageBean findNewsByPageandCid(int page, Category c);

    PageBean findNewsByPage(int page);
}
