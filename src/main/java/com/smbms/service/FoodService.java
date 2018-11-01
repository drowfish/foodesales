package com.smbms.service;

import com.smbms.dao.FoodsMapper;
import com.smbms.entity.Foods;
import com.smbms.entity.FoodsExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FoodService {
    @Resource
    private FoodsMapper foodsMapper;

    public List<Foods> foodsList(){
        FoodsExample foodsExample = new FoodsExample();
        foodsExample.setOrderByClause("id ASC");
        List<Foods> list = foodsMapper.selectByExample(foodsExample);
        return list;
    }
}
