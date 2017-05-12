package cn.xhbuy.fx.service.impl;

import cn.xhbuy.fx.dao.UserDao;
import cn.xhbuy.fx.domain.User;
import cn.xhbuy.fx.service.UserService;
import cn.xhbuy.fx.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhenggg on 2017/5/7.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    public User login(User user) {
        String password = MD5Utils.md5(user.getPassword());
        return  userDao.findUserByUsernameAndPassword(user.getUsername(),password);
    }

    public void editPassword(String id, String password) {
        //使用MD5加密密码
        password = MD5Utils.md5(password);
        userDao.executeUpdate("user.editpassword", password,id);
    }
}
