package service;

import model.OrderDO;
import model.Plist;

public interface OrderService {
    public Plist listPageOrder(int page, int pageSize, String search);
    //删除
    public int deleteOrder(OrderDO orderDO);
    //批量删除
    public int deleteListOrder(Integer[] arr);
    //修改
    public int updateOrder(OrderDO orderDO);
    //新增
    public int saveOrder(OrderDO orderDO);
}
