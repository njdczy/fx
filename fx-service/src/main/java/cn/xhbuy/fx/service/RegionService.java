package cn.xhbuy.fx.service;

import cn.xhbuy.fx.domain.Region;
import cn.xhbuy.fx.utils.PageBean;

import java.util.List;

/**
 * @author zhenggg on 2017/5/9.
 */
public interface RegionService {
    public void saveBatch(List<Region> regionList);

    void pageQuery(PageBean pageBean);

    public List<Region> findListByQ(String q);

    List<Region> findAll();
}
