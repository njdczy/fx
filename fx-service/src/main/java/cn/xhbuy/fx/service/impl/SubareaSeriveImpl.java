package cn.xhbuy.fx.service.impl;

import cn.xhbuy.fx.dao.SubareaDao;
import cn.xhbuy.fx.domain.Subarea;
import cn.xhbuy.fx.service.SubareaService;
import cn.xhbuy.fx.utils.PageBean;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zhenggg on 2017/5/10.
 */
@Service
@Transactional
public class SubareaSeriveImpl implements SubareaService {

    @Autowired
    private SubareaDao subareaDao;
    @Override
    public void save(Subarea model) {
        subareaDao.save(model);
    }

    @Override
    public void pageQuery(PageBean pageBean) {
        subareaDao.pageQuery(pageBean);
    }

    @Override
    public List<Subarea> findAll() {
        return subareaDao.findAll();

    }

    /**
     * 查询所有未关联到定区的分区
     * @return
     */
    @Override
    public List<Subarea> findListNotAssociation() {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Subarea.class);
        //添加过滤条件
        detachedCriteria.add(Restrictions.isNull("decidedzone"));
        return subareaDao.findByCriteria(detachedCriteria);
    }
}
