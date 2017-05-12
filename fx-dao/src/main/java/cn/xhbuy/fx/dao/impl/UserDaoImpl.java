package cn.xhbuy.fx.dao.impl;

import cn.xhbuy.fx.dao.UserDao;
import cn.xhbuy.fx.dao.base.impl.BaseDaoImpl;
import cn.xhbuy.fx.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhenggg on 2017/5/6.
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

    /**
     * 根据用户名密码查用户
     * @param username
     * @param password
     * @return
     */
    public User findUserByUsernameAndPassword(String username, String password) {
        String hql = "FROM User u WHERE u.username = ? AND u.password = ?";
        List<User> list = (List<User>) this.getHibernateTemplate().find(hql, username, password);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public User findUserByUserName(String username) {
        String hql = "FROM User u WHERE u.username = ?";
        List<User> list = (List<User>) this.getHibernateTemplate().find(hql, username);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
}
