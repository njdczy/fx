package cn.xhbuy.fx.dao;

import cn.xhbuy.fx.dao.base.BaseDao;
import cn.xhbuy.fx.domain.User;


/**
 * @author zhenggg on 2017/5/6.
 */
public interface UserDao extends BaseDao<User> {

    public User findUserByUsernameAndPassword(String username, String password);

    User findUserByUserName(String username);
}
