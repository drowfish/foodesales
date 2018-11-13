package com.smbms.service;

import com.smbms.dao.OrderMapper;
import com.smbms.entity.Order;
import com.smbms.entity.OrderExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderService {

    @Resource
    private OrderMapper orderMapper;

    public List<Order> getOrderList(){
        OrderExample orderExample = new OrderExample();
        orderExample.setOrderByClause("id ASC");
        List<Order> list = orderMapper.selectByExample(orderExample);
        return list;
    }
}
