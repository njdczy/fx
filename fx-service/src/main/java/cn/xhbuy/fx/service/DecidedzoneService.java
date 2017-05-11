package cn.xhbuy.fx.service;

import cn.xhbuy.fx.domain.Decidedzone;
import cn.xhbuy.fx.utils.PageBean;

/**
 * @author zhenggg on 2017/5/10.
 */
public interface DecidedzoneService {
    void save(Decidedzone model, String[] subareaid);

    void pageQuery(PageBean pageBean);
}
