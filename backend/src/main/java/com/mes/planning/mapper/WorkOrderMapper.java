package com.mes.planning.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mes.planning.entity.WorkOrder;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WorkOrderMapper extends BaseMapper<WorkOrder> {
}
