package action_xgl;

import bean_xgl.Category;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service_xgl.AdminService;

import java.util.List;

/**
 * @Auther: sise.xgl
 * @Date: 2019/12/3/12:40
 * @Description:
 */
@Data
public class CategoryAction extends ActionSupport implements ModelDriven<Category> {
    public int id;
    public String error;
    public Category category;
    public List<Category> categories;

    @Autowired
    public AdminService adminService;


    @Override
    public Category getModel() {
        return category;
    }

    //新闻类型的发布
    public String addCategory() throws Exception{
        if(category.getCategoryName().isEmpty()){
            error="该类型为空，请重新输入！";
            addFieldError("category.categoryName",error);
            return "adderror";
        }
        else {
            if (adminService.CategoryIsNull(category)){
                adminService.addCategory(category);
                return SUCCESS;
            }
        }
        error="该类型已经存在，请重新输入！";
        addFieldError("category.categoryName",error);
        return "adderror";
    }

    //查询所有新闻类型
    public String listCategory() throws Exception{
        categories = adminService.listCategory();
        return "list";
    }

    //修改前根据id查询新闻类型
    public String updateCategory() throws Exception{
        category = adminService.getCategoryByid(id);
        return "update";
    }

    //修改新闻类型
    public String updatedCategory() throws Exception{
        if(category.getCategoryName().isEmpty()){
            error="该类型为空，请重新输入";
            addFieldError("category.categoryName",error);
            return "updaterror";
        }else {
            if (adminService.CategoryIsNull(category)){
                adminService.updateCategory(category);
                return SUCCESS;
            }
            error = "该类型已经存在，重新输入";
            addFieldError("category.categoryName",error);
            return "updaterror";
        }
    }

    //删除新闻类型
    public String deleteCategory() throws Exception{
        //根据传递过来的新闻类型id查询新闻的全部内容
        category = adminService.getCategoryByid(id);
        //判断新闻类型所绑定的 具体新闻 是否为空
        if (adminService.listNewsByCategory(category).isEmpty()){
            //如果为空，则删除此新闻类型
            adminService.deleteCategory(category);
        }
        else {
            error = "该类型已经绑定数据，请解除数据后再删除！";
            return "error";
        }
        return SUCCESS;
    }


}
