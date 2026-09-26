package com.mes.asset.controller;

import com.mes.common.BaseController;
import com.mes.asset.entity.Equipment;
import com.mes.asset.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/asset/equipment")
public class EquipmentController extends BaseController<EquipmentService, Equipment> {
    @Autowired
    private EquipmentService equipmentService;
    @Override
    protected EquipmentService getService() { return equipmentService; }
}
