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

    /**
     * user_id 查询 权限
     * @param id
     * @return
     */
    @Override
    public List<Function> findFunctionListByUserId(String id) {
        String hql = "SELECT distinct f FROM Function f LEFT OUTER JOIN f.roles r LEFT OUTER JOIN r.users u WHERE u.id = ?";
        List<Function> list = (List<Function>) this.getHibernateTemplate().find(hql);
        return list;
    }

    @Override
    public List<Function> findAllMenu() {
        String hql = "FROM Function f WHERE f.generatemenu = '1' order by f.zindex DESC ";
        List<Function> list = (List<Function>) this.getHibernateTemplate().find(hql);
        return list;
    }

    @Override
    public List<Function> findMenuByUserId(String userId) {
        String hql = "SELECT distinct f FROM Function f " +
                "LEFT OUTER JOIN f.roles r LEFT OUTER JOIN r.users u WHERE u.id = ?" +
                "AND f.generatemenu = '1' order by f.zindex DESC";
        List<Function> list = (List<Function>) this.getHibernateTemplate().find(hql);
        return list;
    }
}
