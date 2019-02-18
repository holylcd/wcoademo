package org.holy.wcoa.dao;

import org.apache.ibatis.annotations.Mapper;
import org.holy.wcoa.entity.RemindEntity;
import org.springframework.stereotype.Component;

@Mapper
public interface RemindMapper extends BaseDao<RemindEntity> {
}
