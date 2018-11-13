package com.smbms.controller;

import com.smbms.entity.OrderShipping;
import com.smbms.service.OrderShippingService;
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
@RequestMapping(value="/orderShipping")
@ResponseBody
public class OrderShippingController {

    @Resource
    private OrderShippingService orderShippingService;

    @RequestMapping("/getOrderShipping")
    public Result getOrderShipping(Integer orderId){
        List<OrderShipping> list = orderShippingService.getOrderShipping(orderId);
        if(list.isEmpty())
            return new Result(StateAndMessage.FAIL,StateAndMessage.GETORDERSHIPPINGFAIL,null);
        OrderShipping orderShipping = list.get(0);
        return  new Result(StateAndMessage.SUCCESS,StateAndMessage.GETORDERSHIPPINGSUCCESS,orderShipping);
    }
}
