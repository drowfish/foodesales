package com.smbms.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.smbms.entity.Order;
import com.smbms.service.OrderService;
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
@RequestMapping(value="/order")
@ResponseBody
public class OrderController {

    @Resource
    private OrderService orderService;

    @RequestMapping("/getOrderList")
    public Result getOrderList(Integer currentPage, Integer limit){
        PageHelper.startPage(currentPage,limit);
        List<Order> list = orderService.getOrderList();
        PageInfo<Order> pageInfo = new PageInfo<Order>(list);
        if(list.isEmpty())
            return new Result(StateAndMessage.FAIL,StateAndMessage.GETORDERFAIL,null);
        return new Result(StateAndMessage.SUCCESS,StateAndMessage.GETORDERSUCCESS,pageInfo);
    }
}
