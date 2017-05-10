package cn.xhbuy.fx.web.action.base;

import cn.xhbuy.fx.domain.Subarea;
import cn.xhbuy.fx.service.SubareaService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * @author zhenggg on 2017/5/10.
 */
@Controller
@Scope("prototype")
public class SubareaAction extends BaseAction<Subarea> {

    @Resource
    private SubareaService subareaService;
    public String add(){
        subareaService.save(model);
        return LIST;
    }
}
