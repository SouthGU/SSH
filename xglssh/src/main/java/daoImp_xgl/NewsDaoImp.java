package daoImp_xgl;

import bean_xgl.Category;
import bean_xgl.News;
import dao_xgl.NewsDao;
import lombok.Data;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Auther: sise.xgl
 * @Date: 2019/12/3/12:41
 * @Description:
 */
@Data
public class NewsDaoImp implements NewsDao {

    @Autowired
    public SessionFactory sessionFactory;

    //通过新闻类型查询所绑定的新闻，Category一整个类型都知识news中的一部分，故此类型为Category
    public List<News> findNewsByCategoryId(Category id) {
        List<News> news =sessionFactory.getCurrentSession().createQuery("from News n where n.category=:id")
                        .setParameter("id",id)
                        .list();
        return news;

    }

    //添加新闻
    public void addNews(News news) {
        sessionFactory.getCurrentSession().save(news);
    }

    //更新新闻
    public void updateNews(String title, String content, String source, Category category, int id) {
        sessionFactory.getCurrentSession().createQuery("update News n set n.title=:title,n.content=:content,n.source=:source ,n.category=:category where n.id=:id")
                .setParameter("title",title)
                .setParameter("content",content)
                .setParameter("source",source)
                .setParameter("category",category)
                .setParameter("id",id)
                .executeUpdate();
    }

    //根据id查询新闻内容
    public News getNewsByid(int id) {
        News news = (News) sessionFactory.getCurrentSession()
                .createQuery("from News n where n.id = :id")
                .setParameter("id",id).uniqueResult();
        return news;
    }

    //删除新闻
    public void deleteNews(News news) {
        sessionFactory.getCurrentSession().delete(news);
    }

    //设置总记录数
    public int findcount() {
        String hql = "select count(*)  from News ";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        int count = ((Long) query.iterate().next()).intValue();
        return count;
    }

    //统计总记录数
    public int findcountWithCid(Category category) {
        String hql = "select count(*) from News n where n.category.id='"+category.getId()+"'";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        int count = ((Long)query.iterate().next()).intValue();
        return count;
    }

//    由新闻类型分页查询新闻列表，以开始数据，每页条数，新闻类型为参数。返回新闻列表
    public List<News> findNewsByPageWithCid(int begin, int limit, Category category) {
        List<News> news = sessionFactory.getCurrentSession()
                .createQuery("from News n where n.category= :category order by n.issueTime desc")
                .setParameter("category",category)//由新闻类型查询
                .setFirstResult(begin)  //设定从哪一个对象开始检索，
                // 参数firstResukt表示这个对象在查询结果中的索引位置，
                // 索引位置的起始值为0，默认情况下，Query从查询结果中的第一个对象开始检索。
                .setMaxResults(limit)
                .list();
        if (news!=null && news.size()>0){
            return news;
        }
        return null;
    }

    public List<News> findNewsByPage(int begin, int limit) {
        List<News> news = sessionFactory.getCurrentSession()
                .createQuery("from News n order by n.issueTime desc")
                .setFirstResult(begin)  //设定从哪一个对象开始检索，
                // 参数firstResukt表示这个对象在查询结果中的索引位置，
                // 索引位置的起始值为0，默认情况下，Query从查询结果中的第一个对象开始检索。
                .setMaxResults(limit)
                .list();
        if (news!=null && news.size()>0){
            return news;
        }
        return null;
    }
}
