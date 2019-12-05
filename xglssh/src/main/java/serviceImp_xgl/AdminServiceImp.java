package serviceImp_xgl;

import bean_xgl.Category;
import bean_xgl.News;
import bean_xgl.PageBean;
import dao_xgl.CategoryDao;
import dao_xgl.LoginDao;
import dao_xgl.NewsDao;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service_xgl.AdminService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: sise.xgl
 * @Date: 2019/12/3/12:40
 * @Description:
 */
@Data
@Transactional
public class AdminServiceImp implements AdminService {
    private CategoryDao categoryDao;
    private NewsDao newsDao;
    private LoginDao loginDao;

    //判断新闻类型是否存在
    public Boolean CategoryIsNull(Category category) {
        //遍历出数据库中的所有新闻类型
        List<Category> c = categoryDao.listCategory();
        List<Map<String,Object>> result = new ArrayList<>();
        //对数据库中的新闻类型进行for循环
        for (Category n :c ){
            Map<String,Object> map = new HashMap<>();
            //遍历，取出数据中的新闻类型名称，如果等于传递过来的新闻类型名称，则添加到result中
            if(n.getCategoryName().contains(category.getCategoryName())){
                map.put("CategroyName",n.getCategoryName());
                result.add(map);
            }
        }
        //如果result中为空，则说明没有相同的新闻类型，那么就返回真
        if (result.isEmpty()) return true;
        return false;
    }

    //新增新闻类型
    public void addCategory(Category category) {
        categoryDao.addCategory(category);
    }

    //查询所有的新闻类型
    public List<Category> listCategory() {
        return categoryDao.listCategory();

    }

    //修改前根据id查询新闻类型
    public Category getCategoryByid(int id) {
        return categoryDao.getCategoryByid(id);
    }

    //修改新闻类型
    public void updateCategory(Category category) {
        categoryDao.updateCategory(category);
    }

    //由新闻类型查出所绑定的新闻列表
    public List<News> listNewsByCategory(Category category) {
        return newsDao.findNewsByCategoryId(category);
    }

    //删除新闻类型
    public void deleteCategory(Category category) {
        categoryDao.deleteCategory(category);
    }



    //---------------------新闻部分----------------------



    //添加新闻
    public void addNews(News news) {
        newsDao.addNews(news);
    }

    //更新新闻
    public void updateNews(String title, String content, String source, Category c, int id) {
        newsDao.updateNews(title, content, source, c, id);
    }

    //根据id查询新闻内容
    public News getNewsByid(int id) {
        return newsDao.getNewsByid(id);
    }

    //删除新闻
    public void deleteNews(News news) {
        newsDao.deleteNews(news);
    }


    //需要页码和新闻类型
    public PageBean<News> findNewsByPageandCid(int page, Category category) {
        //业务层查询新闻数据带分页的方法
        PageBean<News> pageBean = new PageBean<News>();
        //设置当前页数
        pageBean.setPage(page);
        //设置每页显示的记录条数
        int limit = 4;
        pageBean.setLimit(limit);
        //设置总记录数
        int totalCount = newsDao.findcountWithCid(category);
        System.out.println("总记录数： " + totalCount);
        pageBean.setTotalCount(totalCount);
        //设置总页数
        int totalPage = 0;
        //如果总记录数除以每页条数为0，那么就恰好为页数，否则为页数+1
        if(totalCount % limit ==0){
            totalPage = totalCount / limit;
        }else {
            totalPage = totalCount / limit + 1;
        }
        pageBean.setTotalCount(totalPage);
        //设置显示到页面的数据的集合，得到从第几条数据开始
        int begin = (page - 1 ) * limit;
        //将开始数据，每页条数，新闻类型作为参数
        List<News> list = newsDao.findNewsByPageWithCid(begin,limit,category);
        //将新闻列表放入Pagebean的List<News>中
        pageBean.setList(list);
        return pageBean;
    }

    //分页查询
    public PageBean<News> findNewsByPage(int page) {
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
}
