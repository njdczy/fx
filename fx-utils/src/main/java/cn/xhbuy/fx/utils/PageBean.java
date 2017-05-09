package cn.xhbuy.fx.utils;

import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

/**
 * @author zhenggg on 2017/5/8.
 */
public class PageBean {

    private int currentPage;//当前页数
    private int pageSize;//每页条数
    private DetachedCriteria detachedCriteria;//条件
    private int total;//总条数
    private List rows;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public DetachedCriteria getDetachedCriteria() {
        return detachedCriteria;
    }

    public void setDetachedCriteria(DetachedCriteria detachedCriteria) {
        this.detachedCriteria = detachedCriteria;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }

}
