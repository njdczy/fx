package cn.xhbuy.fx.dao.impl;

import cn.xhbuy.fx.dao.SubareaDao;
import cn.xhbuy.fx.dao.base.impl.BaseDaoImpl;
import cn.xhbuy.fx.domain.Subarea;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhenggg on 2017/5/10.
 */
@Repository
public class SubareaDaoImpl extends BaseDaoImpl<Subarea> implements SubareaDao  {
    @Override
    public List<Object> findSubareasGroupByProvince() {
        String hql = "SELECT r.province ,count(*) FROM Subarea s " +
                "LEFT OUTER JOIN s.region r Group BY r.province";
        return (List<Object>) this.getHibernateTemplate().find(hql);
    }
}
