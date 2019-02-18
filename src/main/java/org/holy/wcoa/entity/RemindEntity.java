package org.holy.wcoa.entity;

import lombok.Data;

import java.util.Date;

@Data
public class RemindEntity {

    private Integer id;

    private String name;

    private Date remindDate;

    private String remark;

    private String status;
}
