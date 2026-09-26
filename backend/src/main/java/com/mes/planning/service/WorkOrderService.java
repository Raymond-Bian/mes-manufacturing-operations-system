package com.mes.planning.service;

import com.mes.common.BaseService;
import com.mes.planning.entity.WorkOrder;
import com.mes.planning.mapper.WorkOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkOrderService extends BaseService<WorkOrderMapper, WorkOrder> {
    @Autowired
    private WorkOrderMapper workOrderMapper;
    @Override
    protected WorkOrderMapper getMapper() { return workOrderMapper; }
}
