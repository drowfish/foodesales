package com.smbms.controller;

import com.smbms.entity.Img;
import com.smbms.service.ImgService;
import com.smbms.util.Result;
import com.smbms.util.StateAndMessage.StateAndMessage;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@CrossOrigin(value = {"http://localhost:8002","http://localhost:8081"}, allowCredentials = "true")
@RequestMapping(value="/img")
@ResponseBody
public class ImgController {

    @Resource
    private ImgService imgService;

    @RequestMapping("/addImg")
    public Result addImg(@RequestParam("file")MultipartFile file)throws IOException{
//        String fileName = UUID.randomUUID().toString();
        String fileMD5 = DigestUtils.md5DigestAsHex(file.getBytes());
        Img img = null;
        List<Img> list = imgService.searchByMD5(fileMD5);
        if(!list.isEmpty())
            img = list.get(0);
        else{
            String fileName = UUID.randomUUID().toString();
            String path = "/home/qsb/Downloads/foodsales/"+fileName;
            System.out.println(path);
            File file1 = new File(path);
            file.transferTo(file1);
            img = new Img();
            img.setUrl(fileName);
            img.setMd5(fileMD5);
            imgService.addImg(img);
        }
        return new Result(StateAndMessage.SUCCESS,StateAndMessage.UPLOADSUCCESS,img);
    }
}
