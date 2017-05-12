package cn.xhbuy.fx.service;

import cn.xhbuy.fx.domain.User;

/**
 * @author zhenggg on 2017/5/7.
 */
public interface UserService {

    public User login(User model);

    void editPassword(String id, String password);
}
