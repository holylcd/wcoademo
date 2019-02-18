package org.holy.wcoa.dao;

import org.holy.wcoa.entity.RemindEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan(basePackages = {"org.holy.wcoa"})
public class RemindMapperTest {

//    @Autowired
    @Resource
    private RemindMapper remindMapper;

    @Test
    public void saveTest(){
        RemindEntity remindEntity = new RemindEntity();
        remindEntity.setName("测试");
        remindEntity.setRemark("备注");
        remindEntity.setRemindDate(new Date());
        remindMapper.save(remindEntity);
    }
}
