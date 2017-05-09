package cn.xhbuy.fx.web.action.base;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author zhenggg on 2017/5/6.
 */
public class BaseAction<T> extends ActionSupport implements ModelDriven{

    public static final String HOME = "home";
    public static final String LIST = "list";
    //模型对象
    protected T model;

    public T getModel() {
        return model;
    }

    //在构造方法中动态获取实体类型，东莞反射创建model对象
    public BaseAction(){
        ParameterizedType genericSuperclass = (ParameterizedType) this.getClass().getGenericSuperclass();
        Type[] actualTypeArguments = genericSuperclass.getActualTypeArguments();
        Class<T> entityClass = (Class<T>) actualTypeArguments[0];
        try {
            model = entityClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
