package org.holy.wcoa.service;

import org.holy.wcoa.dao.RemindMapper;
import org.holy.wcoa.entity.RemindEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RemindService {

    @Autowired
    private RemindMapper remindMapper;

    public Integer save(RemindEntity remindEntity){
        return remindMapper.save(remindEntity);
    }

}
