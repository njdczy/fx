package cn.xhbuy.fx.service;

import cn.xhbuy.fx.domain.Function;
import cn.xhbuy.fx.utils.PageBean;

import java.util.List;

/**
 * @author zhenggg on 2017/5/12.
 */
public interface FunctionService {
    List<Function> findAll();

    void add(Function model);

    void pageQuery(PageBean pageBean);

    List<Function> findMenu();
}
