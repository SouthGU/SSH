package action;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import bean.Category;
import bean.News;
import bean.PageBean;
import lombok.Getter;
import lombok.Setter;
import service.AdminService;

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
    public int category_id;//新闻类型id
    public List<Map<String,Object>> newsList,newsList1;
    public List<Category> categories;
    public List<News> newses;
    public AdminService adminService;
    public Map<String,Object> map;


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
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
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

    //显示新闻
    public String listNews(){
        //newsList = adminService.listNews();
        //查询所有的新闻类型
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

    //获取新闻
    public String deleteNews(){
        news = adminService.getNewsByid(id);
        adminService.deleteNews(news);
        return SUCCESS;
    }

    //根据新闻类型来查询新闻
    public String findNewsByCategoryName(){
        if (category_id==0){
            error="请选择类型再确定！";
            return "error";
        }
        Category c = adminService.getCategoryByid(category_id);
        //newsList=adminService.listNewsByCategoryId(c);
        categories = adminService.listCategory();
        PageBean pagebean1;
        if(page!=0){
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

    //查询指定新闻内容
    public String findNewsContent(){
        news = adminService.getNewsByid(id);
        return "content";
    }

    //前端查询指定新闻内容
    public String findNews(){
        news = adminService.getNewsByid(id);
        return "second";
    }


    //模糊查询
    public String findNewsByTitle(){
        //categories = adminService.listCategory();
        newsList = adminService.findNewsByTitle(title);
        return "list1";
    }

    //展示页面
    public String show(){
        System.out.println("page:"+page);
        categories = adminService.listCategory();
        newses = adminService.ListNews1();
        newsList = adminService.listNews();
        newsList1 = adminService.findNewsLimitTime();
        return "show";
    }

    public String findNewsByTime(){
        categories = adminService.listCategory();
        newses = adminService.ListNews1();
        newsList = adminService.findNewsByTime(start,end);
        newsList1 = adminService.findNewsLimitTime();
        return "show";
    }

}
