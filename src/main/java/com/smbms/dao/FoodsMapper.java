package com.smbms.dao;

import com.smbms.entity.FoodList;
import com.smbms.entity.Foods;
import com.smbms.entity.FoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FoodsMapper {
    int countByExample(FoodsExample example);

    int deleteByExample(FoodsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Foods record);

    int insertSelective(Foods record);

    List<Foods> selectByExample(FoodsExample example);

    Foods selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Foods record, @Param("example") FoodsExample example);

    int updateByExample(@Param("record") Foods record, @Param("example") FoodsExample example);

    int updateByPrimaryKeySelective(Foods record);

    int updateByPrimaryKey(Foods record);

    List<FoodList> getFoodList();
}