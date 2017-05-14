package cn.xhbuy.fx.web.action.base;

import java.io.IOException;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import cn.xhbuy.fx.domain.Staff;
import cn.xhbuy.fx.service.StaffService;
import cn.xhbuy.fx.utils.PageBean;
import cn.xhbuy.fx.web.action.base.BaseAction;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import javax.annotation.Resource;

/**
 * @author zhenggg on 2017/5/8.
 */

@Controller
@Scope("prototype")
public class StaffAction extends BaseAction<Staff>{

    @Resource
    private StaffService staffService;

    public String add (){
        staffService.save(model);
        return LIST;
    }

    /**
     * 分页查询方法
     * @throws IOException
     */
    public String pageQuery() throws IOException{
        staffService.pageQuery(pageBean);
        this.java2Json(pageBean, new String[]{"decidedzones","currentPage","detachedCriteria","pageSize"});

        return NONE;
    }

    private String ids;

    public String getIds() {
        return ids;
    }
    public void setIds(String ids) {
        this.ids = ids;
    }


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

    /**
     * 查询所有未删除的取派员，返回json
     */
    public String listajax(){
        List<Staff> list = staffService.findListNotDelete();
        this.java2Json(list, new String[]{"decidedzones"});
        return NONE;
    }


}
