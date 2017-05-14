package cn.xhbuy.fx.realm;

import cn.xhbuy.fx.dao.FunctionDao;
import cn.xhbuy.fx.dao.UserDao;
import cn.xhbuy.fx.domain.Function;
import cn.xhbuy.fx.domain.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author zhenggg on 2017/5/11.
 */
public class FxRealm  extends AuthorizingRealm{
    @Autowired
    private UserDao userDao;
    @Autowired
    private FunctionDao functionDao;
    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取当前用户的权限
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        List<Function> list = null;
        if (user.getUsername().equals("admin")) {
            DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Function.class);
            list = functionDao.findByCriteria(detachedCriteria);
        }else {
            list = functionDao.findFunctionListByUserId(user.getId());
        }
        for (Function function : list) {
            info.addStringPermission(function.getCode());
        }
        return info;

    }

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken mytoken = (UsernamePasswordToken)authenticationToken;
        String username = mytoken.getUsername();
        //根据用户名查询数据库中的密码
        User user = userDao.findUserByUserName(username);
        if(user == null){
            //用户名不存在
            return null;
        }
        //如果能查询到，再由框架比对数据库中查询到的密码和页面提交的密码是否一致
        AuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), this.getName());
        return info;
    }
}
