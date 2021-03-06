package com.smbms.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.smbms.entity.FoodList;
import com.smbms.entity.Foods;
import com.smbms.service.FoodService;
import com.smbms.util.Result;
import com.smbms.util.StateAndMessage.StateAndMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@CrossOrigin(value = {"http://localhost:8002","http://localhost:8081"}, allowCredentials = "true")
@RequestMapping(value="/foods")
@ResponseBody
public class FoodsController {
    @Resource
    private FoodService foodService;

    @RequestMapping("/foodsList")
    public Result foodsList(Integer limit, Integer currentPage){
        PageHelper.startPage(currentPage,limit);
        List<FoodList> list = foodService.getFoodList();
        PageInfo<FoodList> pageInfo = new PageInfo<FoodList>(list);
        if(list.isEmpty())
            return new Result(StateAndMessage.FAIL,StateAndMessage.NOUSER,null);
        return new Result(StateAndMessage.SUCCESS,"",pageInfo);
    }

    @RequestMapping("/deleteFood")
    public Result deleteFood(Integer id){
        System.out.println();
        if(foodService.deleteFood(id)>0)
            return new Result(StateAndMessage.SUCCESS,StateAndMessage.REMOVESUCCESS,null);
        return new Result(StateAndMessage.FAIL,StateAndMessage.REMOVEFAIL,null);
    }

    @RequestMapping(value = "/updateFood")
    public Result updateFood(@RequestBody Foods foods){
        if(foodService.updatFood(foods)>0)
            return new Result(StateAndMessage.SUCCESS,StateAndMessage.UPDATEFOODSUCCESS,null);
        return new Result(StateAndMessage.FAIL,StateAndMessage.UPDATEFOODFAIL,null);
    }

    @RequestMapping("/addFood")
    public Result addFood(@RequestBody Foods foods){
        if(foodService.addFood(foods)>0)
            return new Result(StateAndMessage.SUCCESS,StateAndMessage.ADDFOODSUCCESS,null);
        return new Result(StateAndMessage.FAIL,StateAndMessage.ADDFOODFAIL,null);
    }
}
