package dao;

import bean.Category;
import bean.News;

import java.util.List;

public interface NewsDao {
    //新增新闻文章
    public void addNews(News news);

    //根据id查询文章内容
    public News getNewsByid(int id);

    //修改文章内容
    public void updateNews(String title,String content,String source,Category category,int id);

    //删除文章内容
    public void deleteNews(News news);

    //查询所有文章
    public List<News> findNews();

    //根据文章类型查询文章
    public List<News> findNewsByCategoryId(Category id);

    public List<News> findNewsByCategoryName(String name);

    public List<News> findNewsByTime(String start,String end);

    //查询最新信息
    public List<News> findNewsLimitTime();

    //分页查询新闻数据
    public List<News> findNewsByPage(int begin,int limit);

    //查询新闻信息的数目
    public int findcount();

    public List<News> findNewsByPageWithCid(int begin,int limit,Category category);

    public int findcountWithCid(Category category);

}
