package com.smbms.service;

import com.smbms.dao.FoodsMapper;
import com.smbms.entity.FoodList;
import org.junit.Test;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

public class FoodServiceTest {
    @Resource
    FoodsMapper foodsMapper;
    @Test
    public void getFoodList(){
        List<FoodList> list = foodsMapper.getFoodList();
        System.out.println(list);
    }

}