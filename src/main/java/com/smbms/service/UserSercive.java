package com.smbms.service;

import com.smbms.dao.UserMapper;
import com.smbms.entity.User;
import com.smbms.entity.UserExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserSercive {
    @Resource
    private UserMapper userMapper;

    public List<User> login(User user){
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(user.getUsername());
        return userMapper.selectByExample(userExample);
    }

    public List<User> userList(Integer currentPage, Integer limit){
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andLevelNotEqualTo(1);
        List<User> list = userMapper.selectByExample(userExample);
        return list;
    }

    public int removeUser(Integer id){
        return userMapper.deleteByPrimaryKey(id);
    }
}
