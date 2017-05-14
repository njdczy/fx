package cn.xhbuy.fx.dao.impl;

import cn.xhbuy.fx.dao.FunctionDao;
import cn.xhbuy.fx.dao.base.impl.BaseDaoImpl;
import cn.xhbuy.fx.domain.Function;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhenggg on 2017/5/12.
 */
@Repository
public class FunctionDaoImpl extends BaseDaoImpl<Function> implements FunctionDao {
    public List<Function> findAll() {
        String hql = "FROM Function f WHERE f.parentFunction IS NULL";
        List<Function> list = (List<Function>) this.getHibernateTemplate().find(hql);
        return list;
    }
}
