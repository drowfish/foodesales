package com.smbms.service;

import com.smbms.dao.OrderShippingMapper;
import com.smbms.entity.OrderShipping;
import com.smbms.entity.OrderShippingExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderShippingService {

    @Resource
    private OrderShippingMapper orderShippingMapper;

    public List<OrderShipping> getOrderShipping(Integer orderId){
        OrderShippingExample orderShippingExample = new OrderShippingExample();
        OrderShippingExample.Criteria criteria = orderShippingExample.createCriteria();
        criteria.andOrderIdEqualTo(orderId);
        List<OrderShipping> list = orderShippingMapper.selectByExample(orderShippingExample);
        return list;
    }
}
