package daoImp;


import bean.Category;
import bean.News;
import dao.NewsDao;
import lombok.Data;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

@Data
public class NewsDaoImp implements NewsDao {
    public SessionFactory sessionFactory;
    @Override
    public void addNews(News news) {
        sessionFactory.getCurrentSession().save(news);
    }

    @Override
    public News getNewsByid(int id) {
        News news = (News) sessionFactory.getCurrentSession()
                .createQuery("from News n where n.id = :id")
                .setParameter("id",id).uniqueResult();
        return news;
    }

    @Override
    public void updateNews(String title, String content, String source, Category category, int id) {
        sessionFactory.getCurrentSession().createQuery("update News n set n.title=:title,n.content=:content,n.source=:source ,n.category=:category where n.id=:id")
                .setParameter("title",title)
                .setParameter("content",content)
                .setParameter("source",source)
                .setParameter("category",category)
                .setParameter("id",id)
                .executeUpdate();
    }

    @Override
    public void deleteNews(News news) {
        sessionFactory.getCurrentSession().delete(news);
    }

    @Override
    public List<News> findNews() {
        List<News> news = sessionFactory.getCurrentSession().createQuery("from News n order by n.issueTime desc")
                .list();
        return news;
    }

    @Override
    public List<News> findNewsByCategoryId(Category id) {
        List<News> news = sessionFactory.getCurrentSession()
                .createQuery("from News n where n.category=:id")
                .setParameter("id",id)
                .list();
        return news;
    }

    @Override
    public List<News> findNewsByCategoryName(String name) {
        List<News> news = sessionFactory.getCurrentSession()
                .createQuery("from News n where n.title like :title")
                .setParameter("title","%"+name+"%")
                .list();
        return news ;
    }

    @Override
    public List<News> findNewsByTime(String start, String end) {
        List<News> news = sessionFactory.getCurrentSession()
                .createQuery("from News n where n.issueTime between :start and :endtime ")
                .setParameter("start",start)
                .setParameter("endtime",end)
                .list();
        return news;
    }
    //查询最新信息
    @Override
    public List<News> findNewsLimitTime() {
        List<News> news = sessionFactory.getCurrentSession()
                .createQuery("from News n order by n.issueTime desc")
                .setMaxResults(11)
                .list();
        return news;
    }

    @Override
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

    @Override
    public int findcount() {
        String hql = "select count(*)  from News ";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        int count = ((Long) query.iterate().next()).intValue();
        return count;
    }

    @Override
    public List<News> findNewsByPageWithCid(int begin, int limit, Category category) {
        List<News> news = sessionFactory.getCurrentSession()
                .createQuery("from News n where n.category= :category order by n.issueTime desc")
                .setParameter("category",category)
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

    @Override
    public int findcountWithCid(Category category) {
        String hql = "select count(*)  from News n where n.category.id='"+category.getId()+"'";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        int count = ((Long) query.iterate().next()).intValue();
        return count;
    }
}
