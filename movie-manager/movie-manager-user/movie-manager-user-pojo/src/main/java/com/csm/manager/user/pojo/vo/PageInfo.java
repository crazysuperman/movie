package com.csm.manager.user.pojo.vo;

public class PageInfo {
    private Integer currentPage;
    private Integer pageSize;
    private Integer offset;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getOffset() {
        return (currentPage-1)*pageSize;
    }


}
