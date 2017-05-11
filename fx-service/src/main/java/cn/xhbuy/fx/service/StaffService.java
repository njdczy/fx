package cn.xhbuy.fx.service;

import cn.xhbuy.fx.domain.Staff;
import cn.xhbuy.fx.utils.PageBean;

import java.util.List;

/**
 * @author zhenggg on 2017/5/8.
 */
public interface StaffService {
    void save(Staff model);

    void pageQuery(PageBean pageBean);

    void deleteBatch(String ids);

    Staff findById(String id);

    void update(Staff staff);

    List<Staff> findListNotDelete();
}
