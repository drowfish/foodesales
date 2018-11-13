package com.smbms.service;

import com.smbms.dao.OrderItemMapper;
import com.smbms.entity.OrderItem;
import com.smbms.entity.OrderItemExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderItemService {

    @Resource
    private OrderItemMapper orderItemMapper;

    public List<OrderItem> getOrderItem(Integer orderId){
        OrderItemExample orderItemExample = new OrderItemExample();
        OrderItemExample.Criteria criteria = orderItemExample.createCriteria();
        criteria.andOrderIdEqualTo(orderId);
        List<OrderItem> list = orderItemMapper.selectByExample(orderItemExample);
        return list;
    }
}
