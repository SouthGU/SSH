package action_xgl;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import bean_xgl.Category;
import lombok.Data;
import service_xgl.AdminService;

import java.util.List;

@Data
public class CategoryAction extends ActionSupport implements ModelDriven {
    public int id;
    public String error;
    public AdminService adminService;
    public Category category;
    public List<Category> categories;
    @Override
    public Object getModel() {
        return category;
    }

    //新闻类型发布
    public String addCategory() throws Exception{
        if (category.getCategoryName().isEmpty()){
            error="该类型为空，请重新输入!";
            addFieldError("category.categoryName",error);
            return "adderror";
        }
        else {
            if (adminService.CategoryIsNull(category)) {
                adminService.addCategory(category);
                return SUCCESS;
            }
            error="该类型已经存在，重新输入！";
            addFieldError("category.categoryName",error);
            return "adderror";
        }

    }

    //查询所有新闻类型
    public String listCategory()throws Exception{
        categories = adminService.listCategory();
        return "list";
    }

    //修改前根据id查询新闻类型
    public String updateCategory()throws Exception{
        category = adminService.getCategoryByid(id);
        return "update";
    }

    //修改新闻类型
    public String updatedCategory()throws Exception{
        if (category.getCategoryName().isEmpty()){
            error="该类型为空，请重新输入!";
            addFieldError("category.categoryName",error);
            return "updaterror";
        }else {
            if (adminService.CategoryIsNull(category)) {
                adminService.updateCategory(category);
                return SUCCESS;
            }
            error="该类型已经存在，重新输入！";
            addFieldError("category.categoryName",error);
            return "updaterror";
        }
    }

    //删除新闻类型
    public String deleteCategory()throws Exception{
        category = adminService.getCategoryByid(id);
        if(adminService.listNewsByCategory(category).isEmpty()){
            adminService.deleteCategory(category);
        }
        else {
            error="该类型已经绑定数据，请解除数据再删除！";
            return "error";
        }
        return SUCCESS;
    }
}
