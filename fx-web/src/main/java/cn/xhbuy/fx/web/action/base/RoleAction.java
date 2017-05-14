package cn.xhbuy.fx.web.action.base;

import cn.xhbuy.fx.domain.Role;
import cn.xhbuy.fx.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * @author zhenggg on 2017/5/12.
 */
@Controller
@Scope("prototype")
public class RoleAction extends BaseAction<Role> {

    @Autowired
    private RoleService roleService;

    private String functionids;


    public void setFunctionids(String functionids) {
        this.functionids = functionids;
    }
    /**
     * add role
     */
    public String add(){
        roleService.save(model,functionids);
        return LIST;
    }
    /**
     * role list
     */
    public String pageQuery(){
        roleService.pageQuery(pageBean);
        this.java2Json(pageBean, new String[]{"functions","users"});
        return NONE;
    }
    /**
     * 查询所有的角色数据
     */
    public String listajax()
    {
        List<Role> list = roleService.findAll();
        this.java2Json(list, new String[]{"functions","users"});
        return NONE;
    }
}
