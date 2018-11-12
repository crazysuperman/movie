package mapper;

import model.OrderDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
    //总数
    public int countOrder(@Param("serach") String search);
    //分页查询
    public List<OrderDO> listLimit(@Param("offset") int offset, @Param("pageSize") int pageSize, @Param("serach") String search);
    //删除
    public int deleteOrder(OrderDO orderDO);
    //批量删除
    public int deleteListOrder(Integer[] arr);
    //修改
    public int updateOrder(OrderDO orderDO);
    //新增
    public int saveOrder(OrderDO orderDO);
    //删除2
    //public int deleteOrder2(OrderDO orderDO);
}
