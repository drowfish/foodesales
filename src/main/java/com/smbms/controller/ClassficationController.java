package com.smbms.controller;


import com.smbms.entity.Classification;
import com.smbms.service.ClassficationService;
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
@RequestMapping(value="/classfication")
@ResponseBody
public class ClassficationController {
    @Resource
    private ClassficationService classficationService;

    @RequestMapping("classficationList")
    public Result classficationList(){
        List<Classification> list = classficationService.classficationList();
        if(list.isEmpty())
            return new Result(StateAndMessage.FAIL,StateAndMessage.NOMENU,null);
        return new Result(StateAndMessage.SUCCESS,"",list);
    }
}
