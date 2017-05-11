package cn.xhbuy.fx.web.action.base;

import cn.xhbuy.fx.domain.Decidedzone;
import cn.xhbuy.fx.service.DecidedzoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * @author zhenggg on 2017/5/10.
 */
@Controller
@Scope("prototype")
public class DecidedzoneAction extends BaseAction<Decidedzone> {
    //属性驱动 获取多个分区ID
    private String[] subareaid;

    public void setSubareaid(String[] subareaid) {
        this.subareaid = subareaid;
    }

    @Autowired
    private DecidedzoneService decidedzoneService;

    /**
     * 添加定区
     */
    public String add(){
        decidedzoneService.save(model,subareaid);
        return LIST;
    }
    /**
     * 定区分页
     */
    public String pageQuery(){
        decidedzoneService.pageQuery(pageBean);
        this.java2Json(pageBean, new String[]{"currentPage","detachedCriteria",
                "pageSize","subareas","decidedzones"});
        return NONE;
    }

}
