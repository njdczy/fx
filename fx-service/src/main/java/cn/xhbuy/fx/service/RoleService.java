package cn.xhbuy.fx.service;

import cn.xhbuy.fx.domain.Role;
import cn.xhbuy.fx.utils.PageBean;

import java.util.List;

/**
 * @author zhenggg on 2017/5/12.
 */
public interface RoleService {
    void save(Role role, String functionids);

    void pageQuery(PageBean pageBean);

    List<Role> findAll();
}
