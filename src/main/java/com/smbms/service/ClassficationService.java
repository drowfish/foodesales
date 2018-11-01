package com.smbms.service;

import com.smbms.dao.ClassificationMapper;
import com.smbms.entity.Classification;
import com.smbms.entity.ClassificationExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ClassficationService {
    @Resource
    private ClassificationMapper classificationMapper;

    public List<Classification> classficationList(){
        ClassificationExample classificationExample = new ClassificationExample();
        classificationExample.setOrderByClause("id ASC");
        List<Classification> list = classificationMapper.selectByExample(classificationExample);
        return list;
    }
}
