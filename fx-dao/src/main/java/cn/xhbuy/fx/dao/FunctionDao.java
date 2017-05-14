package cn.xhbuy.fx.dao;

import cn.xhbuy.fx.dao.base.BaseDao;
import cn.xhbuy.fx.domain.Function;

import java.util.List;

/**
 * @author zhenggg on 2017/5/12.
 */
public interface FunctionDao extends BaseDao<Function> {
    List<Function> findFunctionListByUserId(String id);

    List<Function> findAllMenu();

    List<Function> findMenuByUserId(String id);
}
