package cn.xhbuy.fx.web.interceptor;


import cn.xhbuy.fx.domain.User;
import cn.xhbuy.fx.utils.FXUtils;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * 自定义拦截器，实现未登录跳转到登录页面
 * @author zhenggg on 2017/5/8.
 */
public class FXLoginInterceptor extends MethodFilterInterceptor {
    @Override
    protected String doIntercept(ActionInvocation invocation) throws Exception {
        User user = FXUtils.getLoginUser();
        if(user == null){
            return "login";
        }
        return invocation.invoke();
    }
}
