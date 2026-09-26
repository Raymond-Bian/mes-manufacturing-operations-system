package com.mes.planning.controller;

import com.mes.common.BaseController;
import com.mes.planning.entity.WorkOrder;
import com.mes.planning.service.WorkOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/planning/workorder")
public class WorkOrderController extends BaseController<WorkOrderService, WorkOrder> {
    @Autowired
    private WorkOrderService workOrderService;
    @Override
    protected WorkOrderService getService() { return workOrderService; }
}
