package com.csm.manager.cinema.pojo.po;

public class CinemaPO
{
    private Integer cid;
    private String cname;
    private String address;
    private Integer uid;
    private String phone;
    private String photo;
    private Integer state;

    public Integer getState()
    {
        return this.state;
    }

    public void setState(Integer state)
    {
        this.state = state;
    }

    public Integer getCid()
    {
        return this.cid;
    }

    public void setCid(Integer cid)
    {
        this.cid = cid;
    }

    public String getCname()
    {
        return this.cname;
    }

    public void setCname(String cname)
    {
        this.cname = cname;
    }

    public String getAddress()
    {
        return this.address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public Integer getUid()
    {
        return this.uid;
    }

    public void setUid(Integer uid)
    {
        this.uid = uid;
    }

    public String getPhone()
    {
        return this.phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getPhoto()
    {
        return this.photo;
    }

    public void setPhoto(String photo)
    {
        this.photo = photo;
    }
}
