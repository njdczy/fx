package cn.xhbuy.fx.service;

import cn.xhbuy.fx.domain.Subarea;
import cn.xhbuy.fx.utils.PageBean;

import java.util.List;

/**
 * @author zhenggg on 2017/5/10.
 */
public interface SubareaService {
    public void save(Subarea model);

    void pageQuery(PageBean pageBean);

    List<Subarea> findAll();

    List<Subarea> findListNotAssociation();

    List<Object> findSubareasGroupByProvince();
}
