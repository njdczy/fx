package cn.xhbuy.fx.web.action.base;

import cn.xhbuy.fx.domain.Function;
import cn.xhbuy.fx.service.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * @author zhenggg on 2017/5/12.
 */
@Controller
@Scope("prototype")
public class FunctionAction extends BaseAction<Function> {
    @Autowired
    private FunctionService functionService;

    public String ajaxlist(){
        List<Function> functionList = functionService.findAll();
        this.java2Json(functionList, new String[]{"parentFunction","roles"});
        return NONE;
    }
    public String add()
    {
        functionService.add(model);
        return LIST;
    }
    public String pageQuery()
    {
        String page = model.getPage();
        pageBean.setCurrentPage(Integer.parseInt(page));
        functionService.pageQuery(pageBean);
        this.java2Json(pageBean, new String[]{"parentFunction","roles","children"});
        return NONE;
    }
    /**
     * 根据当前用户查出对应菜单
     */
    public String findMenu() {
        List<Function> list = functionService.findMenu();
        this.java2Json(list, new String[]{"parentFunction","roles","children"});
        return NONE;
    }
}
