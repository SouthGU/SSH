package daoImp;

import bean.Category;
import dao.CategoryDao;
import lombok.Data;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;

import java.util.List;


@Data
public class CategoryDaoImp implements CategoryDao {
    private SessionFactory sessionFactory;
    //增加新闻类型
    @Override
    public void addCategory(Category category) {
        try {
            sessionFactory.getCurrentSession().save(category);
        }catch (HibernateException e){
        }
    }
    //查看所有新闻类型
    @Override
    public List<Category> listCategory() {
        List<Category> categories = (List<Category>) sessionFactory.getCurrentSession()
                                        .createQuery("from Category").list();
        return categories;
    }
    //修改新闻类型
    @Override
    public void updateCategory(Category category) {
        sessionFactory.getCurrentSession().update(category);
    }
    //查询指定id的新闻类型
    @Override
    public Category getCategoryByid(int id) {
        Category category = (Category) sessionFactory.getCurrentSession().createQuery("from Category where id = :id ")
                            .setParameter("id",id).uniqueResult();
        return category;
    }

//    @Override
//    public List<Category> findCategoryByName() {
//        List<Category> categories = (List<Category>) sessionFactory.getCurrentSession()
//                .createQuery("select CategoryName from Category")
//                .list();
//        return categories;
//    }

    //删除新闻类型
    @Override
    public void deleteCategory(Category category) {
       sessionFactory.getCurrentSession().delete(category);
    }
}
