package ordertest;

import mapper.OrderMapper;
import model.OrderDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-daotest.xml"})
public class Test1 {
    @Autowired
    private OrderMapper mapper;
    @Test
    public void countOrdet(){
        int i = mapper.countOrder("天");
        System.out.print(i);
    }
    @Test
    public void plist(){
        List<OrderDO> list = mapper.listLimit(0, 1, "天");
        System.out.print(list);
    }

}
