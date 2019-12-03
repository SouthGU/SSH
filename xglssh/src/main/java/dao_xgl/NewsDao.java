package dao_xgl;

import bean_xgl.Category;
import bean_xgl.News;

import java.util.List;

/**
 * @Auther: sise.xgl
 * @Date: 2019/12/3/12:47
 * @Description:
 */
public interface NewsDao {
    //通过新闻类型查看 具体新闻列表
    List<News> findNewsByCategoryId(Category category);
    //添加新闻
    void addNews(News news);

    //更新新闻
    void updateNews(String title, String content, String source, Category c, int id);

    //根据id查询新闻内容
    News getNewsByid(int id);

    //删除新闻
    void deleteNews(News news);

    //查询新闻信息的数目
    int findcount();

    int findcountWithCid(Category category);

    List<News> findNewsByPageWithCid(int begin, int limit, Category category);

    List<News> findNewsByPage(int begin, int limit);
}
