package cn.xhbuy.fx.service.impl;

import cn.xhbuy.fx.dao.RoleDao;
import cn.xhbuy.fx.domain.Function;
import cn.xhbuy.fx.domain.Role;
import cn.xhbuy.fx.service.RoleService;
import cn.xhbuy.fx.utils.PageBean;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zhenggg on 2017/5/12.
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    @Override
    public void save(Role role, String functionids) {
        roleDao.save(role);
        if (StringUtils.isNoneBlank(functionids)) {
            String[] fids = functionids.split(",");
            for (String functionid:fids) {

                Function function = new Function(functionid);
                //角色关联权限
                role.getFunctions().add(function);
            }

        }
    }

    @Override
    public void pageQuery(PageBean pageBean) {
        roleDao.pageQuery(pageBean);
    }

    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }
}
