package service.impl;

import mapper.OrderMapper;
import model.OrderDO;
import model.Plist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import service.OrderService;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper mapper;
    @Override
    public Plist listPageOrder(int page, int pageSize,String search) {
        Plist p = new Plist();
        int offset = (page-1)*pageSize;
        List<OrderDO> list = mapper.listLimit(offset, pageSize,search);
        int i = mapper.countOrder(search);
        p.setTotal(i);
        p.setList(list);
        return p;
    }

    @Override
    @Transactional(isolation= Isolation.READ_COMMITTED,propagation= Propagation.REQUIRED)
    public int deleteOrder(OrderDO orderDO) {
        return  mapper.deleteOrder(orderDO);
    }

    @Override
    public int deleteListOrder(Integer[] arr) {

        return mapper.deleteListOrder(arr);
    }

    @Override
    public int updateOrder(OrderDO orderDO) {

        return mapper.updateOrder(orderDO);
    }

    @Override
    public int saveOrder(OrderDO orderDO) {

        return mapper.saveOrder(orderDO);
    }
}
