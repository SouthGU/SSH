package action_xgl;

import bean_xgl.Category;
import bean_xgl.News;
import bean_xgl.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import lombok.Getter;
import lombok.Setter;
import service_xgl.AdminService;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Setter
@Getter
public class NewsAction extends ActionSupport implements ModelDriven {
    public News news;
    public int id,page;
    public String error,title,start,end;
    public int category_id;//新闻类型id  --> 外键
    public List<Map<String,Object>> newsList,newsList1;
    public List<Category> categories;
    public List<News> newses;
    public Map<String,Object> map;
    public AdminService adminService;


    @Override
    public Object getModel() {
        return news;
    }

    //添加新闻
    public String addNews(){
        if (news.getTitle().isEmpty()||category_id==0
                ||news.getContent().isEmpty()|| news.getSource().isEmpty()){
            error = "所有选项必须填写";
            return "adderror";
        }else {
            Date date = new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Category a = adminService.getCategoryByid(category_id);
            news.setIssueTime(String.valueOf(df.format(date)));//生成当前系统时间
            news.setCategory(a);
            adminService.addNews(news);
            return SUCCESS;
        }
    }

    //查出所有新闻类型
    public String listCategoryName(){
        //以list形式输出所有新闻类型
        categories = adminService.listCategory();
        return "listCategoryName";
    }

    //点击第几页获取page 显示新闻，这里不接收新闻类型，每次点击上一页和下一页都只能查询全部
    public String listNews(){
        //newsList = adminService.listNews();
        //查询所有的新闻类型，方便前端下拉框获取数值
        categories = adminService.listCategory();
        PageBean pagebean;
        if(page!=0){
            pagebean = adminService.findNewsByPage(page);
        }
        else {
            pagebean = adminService.findNewsByPage(1);
        }
        //将数据传递到页面上
        ActionContext.getContext().getValueStack().set("pageBean", pagebean);
        return "list";
    }

    //更新新闻
    public String updateNews(){
        Category c = adminService.getCategoryByid(category_id);
        adminService.updateNews(news.getTitle(),news.getContent(),news.getSource(),c,news.getId());
        return SUCCESS;
    }

    //由新闻ID获取新闻
    public String getNewsByid(){
        int categoryid=(adminService.getNewsByid(id).getCategory()).getId();
        Category c = adminService.getCategoryByid(categoryid);
        news = adminService.getNewsByid(id);
        categories = adminService.listCategory();
        return "update";
    }

    //通过新闻ID 删除新闻
    public String deleteNews(){
        news = adminService.getNewsByid(id);
        adminService.deleteNews(news);
        return SUCCESS;
    }

    //根据新闻类型来查询新闻，首先会进行判断，再将其新闻放在分页里面
    public String findNewsByCategoryName(){
        if (category_id==0){
            error="请选择类型再确定！";
            return "error";
        }
        //由新闻类型的ID外键查询新闻类型，新闻类型ID由下拉框获取传递
        Category c = adminService.getCategoryByid(category_id);
        //newsList=adminService.listNewsByCategoryId(c);
        categories = adminService.listCategory();
        PageBean pagebean1;
        if(page!=0){
            //在service中查询新闻列表后再放入Pagebean中并返回
            pagebean1 = adminService.findNewsByPageandCid(page,c);
        }
        else {
            pagebean1 = adminService.findNewsByPageandCid(1,c);
        }
        //将数据传递到页面上
        ActionContext.getContext().getValueStack().set("pageBean1", pagebean1);
        ActionContext.getContext().getValueStack().set("cid", category_id);
        return "findAll";
    }

    //由新闻的ID 查询指定新闻内容
    public String findNewsContent(){
        news = adminService.getNewsByid(id);
        return "content";
    }



}
