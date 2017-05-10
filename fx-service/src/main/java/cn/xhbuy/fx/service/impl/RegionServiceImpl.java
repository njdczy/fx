package cn.xhbuy.fx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.xhbuy.fx.dao.RegionDao;
import cn.xhbuy.fx.domain.Region;
import cn.xhbuy.fx.service.RegionService;
import cn.xhbuy.fx.utils.PageBean;
@Service
@Transactional
public class RegionServiceImpl implements RegionService{
    @Autowired
    private RegionDao regionDao;
    /**
     * 区域数据批量保存
     */
    public void saveBatch(List<Region> regionList) {
        for (Region region : regionList) {
            regionDao.saveOrUpdate(region);
        }
    }

    /**
     * 区域分页查询
     */
    public void pageQuery(PageBean pageBean) {
        regionDao.pageQuery(pageBean);
    }

    /**
     * 查询所有区域
     */
    public List<Region> findAll() {
        return regionDao.findAll();
    }

    /***
     * 根据页面输入进行模糊查询
     */
    public List<Region> findListByQ(String q) {
        return regionDao.findListByQ(q);
    }
}
