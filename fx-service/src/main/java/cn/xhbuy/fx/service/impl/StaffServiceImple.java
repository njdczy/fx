package cn.xhbuy.fx.service.impl;

import cn.xhbuy.fx.dao.StaffDao;
import cn.xhbuy.fx.domain.Staff;
import cn.xhbuy.fx.service.StaffService;
import cn.xhbuy.fx.utils.PageBean;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhenggg on 2017/5/8.
 */
@Service
@Transactional
public class StaffServiceImple implements StaffService{
    @Autowired
    private StaffDao staffDao;

    @Override
    public void save(Staff model) {
        staffDao.save(model);
    }

    @Override
    public void pageQuery(PageBean pageBean) {
        staffDao.pageQuery(pageBean);
    }

    /**
     * 批量删除
     * @param ids
     */
    @Override
    public void deleteBatch(String ids) {
        if(StringUtils.isNoneBlank(ids)){
            String[] staffIds = ids.split(",");
            for (String id:staffIds) {
                staffDao.executeUpdate("staff.delect",id);
            }
        }
    }

    @Override
    public Staff findById(String id) {
        return staffDao.findById(id);
    }

    /**
     * 根据ID修改指派员
     * @param staff
     */
    @Override
    public void update(Staff staff) {
        staffDao.update(staff);
    }
}
