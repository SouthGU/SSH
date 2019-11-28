package dao;

import bean.Category;

import java.util.List;

public interface CategoryDao {
    //添加新闻类型
    public void addCategory(Category category);
    //查看所有新闻的类型
    public List<Category> listCategory();
    //根据指定id修改新闻类型
    public void updateCategory(Category category);
    //查询指定id的新闻类型
    public Category getCategoryByid(int id);
    //查询指定新闻类型名称的新闻类型
//    public List<Category> findCategoryByName();
    //删除新闻类型
    public void deleteCategory(Category category);

}
