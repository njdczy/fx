package cn.xhbuy.fx.dao.base;


import cn.xhbuy.fx.utils.PageBean;
import org.hibernate.criterion.DetachedCriteria;

import java.io.Serializable;
import java.util.List;
/**
 * @author zhenggg on 2017/5/6.
 *
 * @param <T>
 */
public interface BaseDao <T> {
    public void save(T entity);
    public void delete(T entity);
    public void update(T entity);
    public T findById(Serializable id);
    public List<T> findAll();

    void executeUpdate(String queryName, Object... objects);
    void pageQuery(PageBean pageBean);
    void saveOrUpdate(T entity);

    List<T> findByCriteria(DetachedCriteria detachedCriteria);
}
