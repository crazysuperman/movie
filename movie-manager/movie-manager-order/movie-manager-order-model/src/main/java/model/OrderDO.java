package model;

public class OrderDO {
    //订单号
    private Integer oid;
    //用户id
    private Integer uid;
    //影院id
    private Integer cid;
    //图片
    private String picture;
    //电影名
    private String fileName;
    //影院名
    private String cinemaName;
    //订单时间
    private String orderDate;
    //观影时间
    private String fileDate;
    //订单价格
    private Double orderPrice;

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getFileDate() {
        return fileDate;
    }

    public void setFileDate(String fileDate) {
        this.fileDate = fileDate;
    }

    public Double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "OrderDO{" +
                "oid=" + oid +
                ", uid=" + uid +
                ", cid=" + cid +
                ", picture='" + picture + '\'' +
                ", fileName='" + fileName + '\'' +
                ", cinemaName='" + cinemaName + '\'' +
                ", orderDate='" + orderDate + '\'' +
                ", fileDate='" + fileDate + '\'' +
                ", orderPrice=" + orderPrice +
                '}';
    }
}
