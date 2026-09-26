package com.mes.manufacturing.controller;

import com.mes.common.BaseController;
import com.mes.manufacturing.entity.EquipmentStatus;
import com.mes.manufacturing.service.EquipmentStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manufacturing/equipment")
public class EquipmentStatusController extends BaseController<EquipmentStatusService, EquipmentStatus> {
    @Autowired
    private EquipmentStatusService equipmentStatusService;
    @Override
    protected EquipmentStatusService getService() { return equipmentStatusService; }
}
