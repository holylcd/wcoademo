package org.holy.wcoa.api;

import io.swagger.annotations.Api;
import org.holy.wcoa.entity.RemindEntity;
import org.holy.wcoa.service.RemindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Api(tags = "提醒")
@RestController
@RequestMapping("/api/remind")
public class RemindController {

    @Autowired
    RemindService ReminderService;

    @PostMapping("/")
    // @ApiOperation(value ="添加提醒",response = Map.class)
    public Map<String, Object> save(@RequestParam(value = "name")String name
            , @RequestParam(value = "remind_date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date remindDate
            , @RequestParam(value = "remark") String remark) {
        RemindEntity remindEntity = new RemindEntity();
        remindEntity.setRemindDate(remindDate);
        remindEntity.setRemark(remark);
        remindEntity.setName(name);
        Integer id =  ReminderService.save(remindEntity);

        Map<String, Object> map = new HashMap<>(4);
        map.put("code",0);
        map.put("msg","success");
        map.put("id",remindEntity.getId());

        return map;

    }


}
