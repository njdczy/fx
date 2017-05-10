package cn.xhbuy.fx.dao.impl;

import cn.xhbuy.fx.dao.RegionDao;
import cn.xhbuy.fx.dao.base.impl.BaseDaoImpl;
import cn.xhbuy.fx.domain.Region;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhenggg on 2017/5/10.
 */
@Repository
public class RegionDaoImpl extends BaseDaoImpl<Region> implements RegionDao {
    @Override
    public List<Region> findListByQ(String q) {
        String hql = "FROM Region r WHERE r.shortcode LIKE ? "
                + "	OR r.citycode LIKE ? OR r.province LIKE ? "
                + "OR r.city LIKE ? OR r.district LIKE ?";
        List<Region> list = (List<Region>) this.getHibernateTemplate().
                find(hql, "%"+q+"%","%"+q+"%","%"+q+"%","%"+q+"%","%"+q+"%");
        return list;
    }
}
