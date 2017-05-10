package cn.xhbuy.fx.web.action.base;

import cn.xhbuy.fx.domain.Staff;
import cn.xhbuy.fx.service.StaffService;

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

    /**
     * 分页查询方法
     * @throws IOException
     */
    public String pageQuery() throws IOException{
        staffService.pageQuery(pageBean);
        this.java2Json(pageBean, new String[]{"currentPage","detachedCriteria","pageSize"});

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


}
