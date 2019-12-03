package dao_xgl;

import bean_xgl.Category;

import java.util.List;

/**
 * @Auther: sise.xgl
 * @Date: 2019/12/3/12:43
 * @Description:
 */
public interface CategoryDao {

    //查看所有新闻的类型
    List<Category> listCategory();

    //新增新闻类型
    void addCategory(Category category);

    //修改前根据id查询新闻类型
    Category getCategoryByid(int id);

    //修改新闻类型
    void updateCategory(Category category);

    //删除新闻类型
    void deleteCategory(Category category);
}
