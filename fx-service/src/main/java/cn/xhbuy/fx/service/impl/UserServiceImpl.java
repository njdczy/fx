package cn.xhbuy.fx.service.impl;

import cn.xhbuy.fx.dao.UserDao;
import cn.xhbuy.fx.domain.Role;
import cn.xhbuy.fx.domain.User;
import cn.xhbuy.fx.service.UserService;
import cn.xhbuy.fx.utils.MD5Utils;
import cn.xhbuy.fx.utils.PageBean;
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

    /**
     * 添加一个用户，关联角色
     * @param user
     * @param roleIds
     */
    @Override
    public void save(User user, String[] roleIds) {

        String password = MD5Utils.md5(user.getPassword());
        user.setPassword(password);
        userDao.save(user);
        if(roleIds != null && roleIds.length > 0){
            for (String roleId:roleIds) {
                Role role = new Role(roleId);
                user.getRoles().add(role);
            }
        }
    }

    /**
     * user list
     * @param pageBean
     */
    @Override
    public void pageQuery(PageBean pageBean) {
        userDao.pageQuery(pageBean);
    }
}
