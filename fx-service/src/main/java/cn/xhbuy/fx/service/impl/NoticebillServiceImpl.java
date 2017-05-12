package cn.xhbuy.fx.service.impl;

import cn.xhbuy.fx.dao.NoticebillDao;
import cn.xhbuy.fx.service.NoticebillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhenggg on 2017/5/11.
 */
@Service
@Transactional
public class NoticebillServiceImpl implements NoticebillService {

    @Autowired
    private NoticebillDao noticebillDao;
}
