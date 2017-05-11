package cn.xhbuy.fx.service.impl;

import cn.xhbuy.fx.dao.DecidedzoneDao;
import cn.xhbuy.fx.dao.SubareaDao;
import cn.xhbuy.fx.domain.Decidedzone;
import cn.xhbuy.fx.domain.Subarea;
import cn.xhbuy.fx.service.DecidedzoneService;
import cn.xhbuy.fx.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhenggg on 2017/5/10.
 */
@Service
@Transactional
public class DecidedzoneServiceImpl implements DecidedzoneService {

    @Autowired
    private DecidedzoneDao decidedzoneDao;
    @Autowired
    private SubareaDao subareaDao;
    @Override
    public void save(Decidedzone model, String[] subareaid) {
        decidedzoneDao.save(model);
        for (String id:
                subareaid) {
            Subarea subarea = subareaDao.findById(id);
            subarea.setDecidedzone(model);

        }
    }

    /**
     * 定区分页
     * @param pageBean
     */
    @Override
    public void pageQuery(PageBean pageBean) {
        decidedzoneDao.pageQuery(pageBean);
    }
}
