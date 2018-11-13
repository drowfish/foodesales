package com.smbms.controller;

import com.smbms.entity.OrderItem;
import com.smbms.service.OrderItemService;
import com.smbms.util.Result;
import com.smbms.util.StateAndMessage.StateAndMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@CrossOrigin(value = {"http://localhost:8002","http://localhost:8081"}, allowCredentials = "true")
@RequestMapping(value="/orderItem")
@ResponseBody
public class OrderItemController {

    @Resource
    private OrderItemService orderItemService;

    @RequestMapping("/getOrderItem")
    public Result getOrderItem(Integer orderId){
        List<OrderItem> list = orderItemService.getOrderItem(orderId);
        Integer sum = 0;
        if(list.isEmpty())
            return new Result(StateAndMessage.FAIL,StateAndMessage.GETORDERITEMFAIL,sum);
        for (OrderItem orderItem: list) {
            sum+=orderItem.getTotalFee();
        }
        return new Result(StateAndMessage.SUCCESS,StateAndMessage.GETORDERITEMSUCCESS,sum);
    }
}
