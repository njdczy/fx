package cn.xhbuy.fx.web.action.base;

import cn.xhbuy.fx.domain.User;
import cn.xhbuy.fx.service.UserService;
import cn.xhbuy.fx.utils.FXUtils;
import cn.xhbuy.fx.utils.MD5Utils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.IOException;

/**
 * @author zhenggg on 2017/5/6.
 */

@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User> {

    private String checkcode;

    public void setCheckcode(String checkcode) {
        this.checkcode = checkcode;
    }

    @Autowired
    private UserService userService;

    /**
     * 用户登录
     */
    public String login(){
        //检验验证码
        String vaildatecode = (String) ServletActionContext.getRequest().getSession().getAttribute("key");
        if(StringUtils.isNotBlank(checkcode) && checkcode.equals(vaildatecode)){
            Subject subject = SecurityUtils.getSubject();//获得当前用户对象,状态为“未认证”
            AuthenticationToken token = new UsernamePasswordToken(model.getUsername(), MD5Utils.md5(model.getPassword()));//创建用户名密码令牌对象
            try{
                subject.login(token);
            }catch(Exception e){
                e.printStackTrace();
                return LOGIN;
            }
            User user = (User) subject.getPrincipal();
            ServletActionContext.getRequest().getSession().setAttribute("loginUser", user);
            return HOME;
        }else{
            //输入的验证码错误,设置提示信息，跳转到登录页面
            this.addActionError("输入的验证码错误！");
            return LOGIN;
        }
    }
    /**
     * 用户登录
     */
    public String login_bak(){
        //检验验证码
        String vaildatecode = (String) ServletActionContext.getRequest().getSession().getAttribute("key");
        if(StringUtils.isNotBlank(checkcode) && checkcode.equals(vaildatecode)){
            User user = userService.login(model);
            if (user != null) {
                //User session
                ServletActionContext.getRequest().getSession()
                        .setAttribute("loginUser",user);
                return HOME;
            }else {
                this.addActionError("用户名或者密码错误");
                return LOGIN;
            }
        }else{
            this.addActionError("输入的验证码错误");
            return LOGIN;
        }
    }

    /**
     * 用户退出
     */
    public String logout()
    {
        ServletActionContext.getRequest().getSession().invalidate();
        return LOGIN;
    }

    public String editPassword () throws IOException {
        String f = "1";
        User user = FXUtils.getLoginUser();
        try{
            userService.editPassword(user.getId(),model.getPassword());
        }catch(Exception e){
            f = "0";
            e.printStackTrace();
        }
        ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
        ServletActionContext.getResponse().getWriter().print(f);
        return NONE;
    }


    private String[] roleIds;
    public void setRoleIds(String[] roleIds) {
        this.roleIds = roleIds;
    }

    /**
     * add user
     */
    public String add()
    {
        userService.save(model, roleIds);
        return LIST;
    }

    /**
     * user list
     */
    public String pageQuery(){
        userService.pageQuery(pageBean);
        this.java2Json(pageBean,new String[]{"noticebills","roles"});
        return NONE;
    }
}
