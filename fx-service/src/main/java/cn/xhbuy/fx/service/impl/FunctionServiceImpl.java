package cn.xhbuy.fx.service.impl;

import cn.xhbuy.fx.dao.FunctionDao;
import cn.xhbuy.fx.domain.Function;
import cn.xhbuy.fx.service.FunctionService;
import cn.xhbuy.fx.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhenggg on 2017/5/12.
 */
@Service
public class FunctionServiceImpl implements FunctionService {

    @Autowired
    private FunctionDao functionDao;
    @Override
    public List<Function> findAll() {
        return functionDao.findAll();
    }

    @Override
    public void add(Function model) {
        Function parentFunction = model.getParentFunction();
        if (parentFunction != null && parentFunction.getId().equals("")){
            model.setParentFunction(null);
        }
        functionDao.save(model);
    }

    @Override
    public void pageQuery(PageBean pageBean) {
        functionDao.pageQuery(pageBean);
    }
}
