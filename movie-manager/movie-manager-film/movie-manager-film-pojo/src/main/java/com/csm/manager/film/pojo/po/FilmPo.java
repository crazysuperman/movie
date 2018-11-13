package com.csm.manager.film.pojo.po;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class FilmPo {

   // fname,fbeginDate,fendDate,fstatus,fmessage,fposter,mlid,mtid)
    private int fid;
    private String fname;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fbeginDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fendDate;
    private int fstatus;
    private String fmessage;
    private String fposter;
    private int mlid;
    private int mtid;
    private double fprice;

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public Date getFbeginDate() {
        return fbeginDate;
    }

    public void setFbeginDate(Date fbeginDate) {
        this.fbeginDate = fbeginDate;
    }

    public Date getFendDate() {
        return fendDate;
    }

    public void setFendDate(Date fendDate) {
        this.fendDate = fendDate;
    }

    public int getFstatus() {
        return fstatus;
    }

    public void setFstatus(int fstatus) {
        this.fstatus = fstatus;
    }

    public String getFmessage() {
        return fmessage;
    }

    public void setFmessage(String fmessage) {
        this.fmessage = fmessage;
    }

    public String getFposter() {
        return fposter;
    }

    public void setFposter(String fposter) {
        this.fposter = fposter;
    }

    public int getMlid() {
        return mlid;
    }

    public void setMlid(int mlid) {
        this.mlid = mlid;
    }

    public int getMtid() {
        return mtid;
    }

    public void setMtid(int mtid) {
        this.mtid = mtid;
    }

    public double getFprice() {
        return fprice;
    }

    public void setFprice(double fprice) {
        this.fprice = fprice;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("FilmPo{");
        sb.append("fid=").append(fid);
        sb.append(", fname='").append(fname).append('\'');
        sb.append(", fbeginDate=").append(fbeginDate);
        sb.append(", fendDate=").append(fendDate);
        sb.append(", fstatus=").append(fstatus);
        sb.append(", fmessage='").append(fmessage).append('\'');
        sb.append(", fposter='").append(fposter).append('\'');
        sb.append(", mlid=").append(mlid);
        sb.append(", mtid=").append(mtid);
        sb.append(", fprice=").append(fprice);
        sb.append('}');
        return sb.toString();
    }
}
