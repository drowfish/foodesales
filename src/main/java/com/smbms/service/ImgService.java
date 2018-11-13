package com.smbms.service;

import com.smbms.dao.ImgMapper;
import com.smbms.entity.Img;
import com.smbms.entity.ImgExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ImgService {

    @Resource
    private ImgMapper imgMapper;

    public int addImg(Img img){
        return imgMapper.insert(img);
    }

    public List<Img> searchByMD5(String fileMD5){
        ImgExample imgExample = new ImgExample();
        ImgExample.Criteria criteria = imgExample.createCriteria();
        criteria.andMd5EqualTo(fileMD5);
        return imgMapper.selectByExample(imgExample);
    }

    public Img getImg(Integer id){
        return imgMapper.selectByPrimaryKey(id);
    }
}
