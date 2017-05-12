package cn.xhbuy.fx.web.action.base;

import cn.xhbuy.fx.domain.Noticebill;
import cn.xhbuy.fx.service.NoticebillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * @author zhenggg on 2017/5/11.
 */
@Controller
@Scope("prototype")
public class NoticebillAction extends BaseAction<Noticebill> {

    @Autowired
    private NoticebillService noticebillService;

}
