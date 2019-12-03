package daoImp_xgl;

import bean_xgl.Category;
import dao_xgl.CategoryDao;
import lombok.Data;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: sise.xgl
 * @Date: 2019/12/3/12:41
 * @Description:
 */
@Data
public class CategoryDaoImp implements CategoryDao {

    @Autowired
    public SessionFactory sessionFactory;

    //查看所有的新闻类型
    public List<Category> listCategory() {
        List<Category>  categories = (List<Category>)sessionFactory.getCurrentSession()
                                                    .createQuery("from Category")
                                                    .list();
        return categories;
    }

    //添加新闻类型
    public void addCategory(Category category) {
       sessionFactory.getCurrentSession().save(category);
    }

    //查询指定id的新闻类型
    public Category getCategoryByid(int id) {
        Category category = (Category)sessionFactory.getCurrentSession()
                            .createQuery("from Category where id = :id ")
                            .setParameter("id", id).uniqueResult();
        return category;

    }

    //修改新闻类型
    public void updateCategory(Category category) {
        sessionFactory.getCurrentSession().update(category);
    }

    //删除新闻类型
    public void deleteCategory(Category category) {
        sessionFactory.getCurrentSession().delete(category);
    }
}
