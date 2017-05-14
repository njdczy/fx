package cn.xhbuy.fx.service;

import cn.xhbuy.fx.domain.User;
import cn.xhbuy.fx.utils.PageBean;

/**
 * @author zhenggg on 2017/5/7.
 */
public interface UserService {

    public User login(User model);

    void editPassword(String id, String password);

    void save(User model, String[] roleIds);

    void pageQuery(PageBean pageBean);
}
