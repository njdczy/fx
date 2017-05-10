package cn.xhbuy.fx.dao;

import cn.xhbuy.fx.dao.base.BaseDao;
import cn.xhbuy.fx.domain.Region;

import java.util.List;

/**
 * @author zhenggg on 2017/5/9.
 */
public interface RegionDao extends BaseDao<Region> {
    public List<Region> findListByQ(String q);
}
