package service;

import bean.Category;
import bean.News;
import bean.PageBean;
import bean.User;

import java.util.List;
import java.util.Map;

public interface AdminService {
    //用户登录操作接口
    public Boolean isUser(User user);

    //新闻类型操作接口
    public void addCategory(Category category);
    public List<Category> listCategory();
    public void updateCategory(Category category);
    public Category getCategoryByid(int id);
    public void deleteCategory(Category category);
    //    public List<Category> findCategoryByName();
    public Boolean CategoryIsNull(Category category);

    //新闻内容操作接口
    public void addNews(News news);
    public List<Map<String,Object>> listNews();
    public void updateNews(String title,String content,String source,Category category,int id);
    public News getNewsByid(int id);
    public void deleteNews(News news);
    public List<Map<String,Object>> listNewsByCategoryId(Category category);
    public List<News> listNewsByCategory(Category category);
    public List<Map<String,Object>> findNewsByTitle(String name);
    public List<Map<String,Object>> findNewsByTime(String start,String end);
    public List<Map<String,Object>> findNewsLimitTime();;
    public List<News> ListNews1();
    public PageBean<News> findNewsByPage(Integer page);
    public PageBean<News> findNewsByPageandCid(Integer page,Category category);
}
