package cn.xhbuy.fx.service.impl;

import cn.xhbuy.fx.dao.SubareaDao;
import cn.xhbuy.fx.domain.Subarea;
import cn.xhbuy.fx.service.SubareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
