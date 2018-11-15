package com.csm.manager.cinema.pojo.dto;

public class PageInfo
{
    private Integer page;
    private Integer limit;
    private String search;

    public Integer getPage()
    {
        return this.page;
    }

    public void setPage(Integer page)
    {
        this.page = page;
    }

    public Integer getLimit()
    {
        return this.limit;
    }

    public void setLimit(Integer limit)
    {
        this.limit = limit;
    }

    public String getSearch()
    {
        return this.search;
    }

    public void setSearch(String search)
    {
        this.search = search;
    }

    public Integer getOffset()
    {
        return Integer.valueOf((this.page.intValue() - 1) * this.limit.intValue());
    }
}
