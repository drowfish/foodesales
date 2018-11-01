package com.smbms.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.smbms.entity.User;
import com.smbms.service.UserSercive;
import com.smbms.util.Result;
import com.smbms.util.StateAndMessage.StateAndMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@CrossOrigin(value = {"http://localhost:8002","http://localhost:8081"}, allowCredentials = "true")
@RequestMapping(value="/user")
@ResponseBody
public class UserController {
    @Resource
    private UserSercive userSercive;

    @RequestMapping("/login")
    public Result login(@RequestBody User user, HttpSession session){
        List<User> list = userSercive.login(user);
        Result result = new Result();
        if (!list.isEmpty()){
            User user1 = list.get(0);
            if(user.getPassword().equals(user1.getPassword())){
                if(user.getLevel()==1){
                    if(user1.getLevel() == 1){
                        result.setState(StateAndMessage.SUCCESS);
                        result.setMessage(StateAndMessage.LOGINSMESSAGE);
                        result.setData(user1);
                        session.setAttribute("user",user1);
                        System.out.println("session:"+session);
                    }else{
                        result.setState(StateAndMessage.FAIL);
                        result.setMessage(StateAndMessage.LOGINFMESSAGE);
                    }
                }else{
                    result.setState(StateAndMessage.SUCCESS);
                    result.setMessage(StateAndMessage.LOGINSMESSAGE);
                    result.setData(user1);
                    session.setAttribute("user",user1);
                    System.out.println("session:"+session);
                }
            }else{
                result.setMessage(StateAndMessage.LOGINFPASSWORD);
                result.setState(StateAndMessage.FAIL);
            }
        }else{
            result.setState(StateAndMessage.FAIL);
            result.setMessage(StateAndMessage.LOGINFUSERNAME);
        }
        return result;
    }

    @RequestMapping("/signout")
    public Result signout(HttpSession session){
        session.invalidate();
        return new Result(StateAndMessage.SUCCESS,"",null);
    }

    @RequestMapping("/userList")
    public Result userList( Integer currentPage, Integer limit){
        PageHelper.startPage(currentPage,limit);
        List<User> list = userSercive.userList(currentPage,limit);
        PageInfo<User> pageInfo = new PageInfo<User>(list);
        if(list.isEmpty())
            return new Result(StateAndMessage.FAIL,StateAndMessage.NOUSER,null);
        return new Result(StateAndMessage.SUCCESS,"",pageInfo);
    }

    @RequestMapping("/removeUser")
    public Result removeUser(Integer id){
        if(userSercive.removeUser(id)>0)
            return new Result(StateAndMessage.SUCCESS,StateAndMessage.REMOVESUCCESS,null);
        return new Result(StateAndMessage.FAIL,StateAndMessage.REMOVEFAIL,null);
    }
}
