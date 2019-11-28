package serviceImp;


import bean.Category;

import bean.News;
import bean.PageBean;
import bean.User;
import dao.CategoryDao;
import dao.LoginDao;
import dao.NewsDao;
import service.AdminService;
import lombok.Data;


import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Transactional
public class AdminServiceImp implements AdminService {

    private CategoryDao categoryDao;
    private NewsDao newsDao;
    private LoginDao loginDao;

    //判断用户是否存在
    @Override
    public Boolean isUser(User user) {
        if (loginDao.isUser(user).isEmpty())return false;
        return true;
    }

    //新增新闻类型
    @Override
    public void addCategory(Category category) {
        categoryDao.addCategory(category);
    }

    //查询所有新闻类型
    @Override
    public List<Category> listCategory() {
        return categoryDao.listCategory();
    }

    //修改新闻类型
    @Override
    public void updateCategory(Category category) {
        categoryDao.updateCategory(category);
    }

    //根据id查询新闻类型
    @Override
    public Category getCategoryByid(int id) {
        return categoryDao.getCategoryByid(id);
    }

    //删除新闻类型
    @Override
    public void deleteCategory(Category category) {
        categoryDao.deleteCategory(category);
    }

    //判断新闻类型是否存在
    @Override
    public Boolean CategoryIsNull(Category category) {
        List<Category> c = categoryDao.listCategory();
        List<Map<String,Object>> result = new ArrayList<>();
        for (Category n : c) {
            Map<String, Object> map = new HashMap<>();
            if (n.getCategoryName().contains(category.getCategoryName())){
                map.put("CategroyName", n.getCategoryName());
                result.add(map);
            }
        }
        if (result.isEmpty())return true;
        return false;
    }


    //新增新闻内容
    @Override
    public void addNews(News news) {
        newsDao.addNews(news);
    }

    //查询所有新闻内容
    @Override
    public List<Map<String,Object>> listNews() {
        List<News> news = newsDao.findNews();
        return listNews4Map(news);
    }

    //修改新闻内容
    @Override
    public void updateNews(String title,String content,String source,Category category,int id) {
        newsDao.updateNews(title, content, source, category, id);
    }

    //根据id查询新闻内容
    @Override
    public News getNewsByid(int id) {
        return newsDao.getNewsByid(id);
    }

    @Override
    public void deleteNews(News news) {
        newsDao.deleteNews(news);
    }

    @Override
    public List<Map<String,Object>> listNewsByCategoryId(Category category) {
        List<News> news= newsDao.findNewsByCategoryId(category);
        return listNews4Map(news);
    }

    @Override
    public List<News> listNewsByCategory(Category category) {
        return newsDao.findNewsByCategoryId(category);
    }

    @Override
    public List<Map<String,Object>> findNewsByTitle(String name) {
        List<News> news =  newsDao.findNewsByCategoryName(name);
        return listNews4Map(news);
    }

    @Override
    public List<Map<String, Object>> findNewsByTime(String start, String end) {
        List<News> news = newsDao.findNewsByTime(start,end);
        return listNews4Map(news);
    }

    @Override
    public List<Map<String, Object>> findNewsLimitTime() {
        List<News> news = newsDao.findNewsLimitTime();
        return listNews4Map(news);
    }

    @Override
    public List<News> ListNews1() {
        return newsDao.findNews();
    }


    //分页查询
    @Override
    public PageBean<News> findNewsByPage(Integer page) {
            //业务层查询新闻数据带分页的方法
            PageBean<News> pageBean=new PageBean<News>();
            //设置当前页数；
            pageBean.setPage(page);
            //设置每页显示记录数
            int limit=5;
            pageBean.setLimit(limit);
            //设置总记录条数
            int totalCount=newsDao.findcount();
            pageBean.setTotalCount(totalCount);
            //设置总页数
            int totalPage=0;
            if(totalCount % limit==0){
                totalPage=totalCount/limit;
            }else{
                totalPage=totalCount/limit+1;
            }
            pageBean.setTotalPage(totalPage);
            //设置显示到页面的数据的集合
            int begin=(page-1)*limit;
            List<News> list=newsDao.findNewsByPage(begin,limit);
            pageBean.setList(list);
            return pageBean;
        }

    @Override
    public PageBean<News> findNewsByPageandCid(Integer page,Category category) {
        //业务层查询新闻数据带分页的方法
        PageBean<News> pageBean=new PageBean<News>();
        //设置当前页数；
        pageBean.setPage(page);
        //设置每页显示记录数
        int limit=4;
        pageBean.setLimit(limit);
        //设置总记录条数
        int totalCount=newsDao.findcountWithCid(category);
        System.out.println("Cid totalCount:"+totalCount);
        pageBean.setTotalCount(totalCount);
        //设置总页数
        int totalPage=0;
        if(totalCount % limit==0){
            totalPage=totalCount/limit;
        }else{
            totalPage=totalCount/limit+1;
        }
        pageBean.setTotalPage(totalPage);
        //设置显示到页面的数据的集合
        int begin=(page-1)*limit;
        List<News> list=newsDao.findNewsByPageWithCid(begin,limit,category);
        pageBean.setList(list);
        return pageBean;
    }


    //将查询出来的新闻结果进行封装
    public List<Map<String , Object>> listNews4Map(List<News> news){
        List<Map<String,Object>> result = new ArrayList<>();
        for (News n : news){
            Map<String,Object> map = new HashMap<>();
            map.put("id",n.getId());
            map.put("title",n.getTitle());
            map.put("content",n.getContent());
            map.put("source",n.getSource());
            map.put("issueTime",n.getIssueTime());
            map.put("category_id",categoryDao.getCategoryByid(n.getCategory().getId()).getId());
            map.put("category",categoryDao.getCategoryByid(n.getCategory().getId()).getCategoryName());
            result.add(map);
        }
        return result;
    }
}
