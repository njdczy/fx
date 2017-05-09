package cn.xhbuy.fx.web.action.base;

import cn.xhbuy.fx.domain.Staff;
import cn.xhbuy.fx.service.StaffService;
import cn.xhbuy.fx.utils.PageBean;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.IOException;

/**
 * @author zhenggg on 2017/5/8.
 */

@Controller
@Scope("prototype")
public class StaffAction extends BaseAction<Staff>{

    @Autowired
    private StaffService staffService;

    public String add (){
        staffService.save(model);
        return LIST;
    }

    //属性驱动，接收页面提交的分页参数
    private int page;
    private int rows;
    /**
     * list
     */
    public String pageQuery() throws IOException {
        PageBean pageBean = new PageBean();
        pageBean.setCurrentPage(page);
        pageBean.setPageSize(rows);
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Staff.class);
        pageBean.setDetachedCriteria(detachedCriteria);
        staffService.pageQuery(pageBean);
        //pageBean to json
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setExcludes(new String[]{"currentPage","detachedCriteria","pageSize"});
        String json = JSONObject.fromObject(pageBean,jsonConfig).toString();
        ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
        ServletActionContext.getResponse().getWriter().print(json);
        return NONE;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    private String ids;
    public String deleteBatch()
    {
        staffService.deleteBatch(ids);
        return LIST;
    }

    /**
     * 修改
     * @return
     */
    public String edit(){
        //先查后插
        Staff staff = staffService.findById(model.getId());
        staff.setName(model.getName());
        staff.setTelephone(model.getTelephone());
        staff.setHaspda(model.getHaspda());
        staff.setStandard(model.getStandard());
        staff.setStation(model.getStation());
        staffService.update(staff);
        return LIST;
    }
    public  int  getPage() {
        return page;
    }public void setPage(int page) {
        this.page = page;
    }public int  getRows() {
        return rows;
    }public void setRows(int rows) {
        this.rows = rows;
    }
}
