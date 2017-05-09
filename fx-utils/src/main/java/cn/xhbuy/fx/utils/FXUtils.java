package cn.xhbuy.fx.utils;

import cn.xhbuy.fx.domain.User;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;

/**
 * FX工具类
 * @author zhenggg on 2017/5/8.
 */
public class FXUtils {
    //获取session对象
    public static HttpSession getSession(){
        return ServletActionContext.getRequest().getSession();
    }
    //获取登录用户对象
    public static User getLoginUser(){
        return (User) getSession().getAttribute("loginUser");
    }
}
