package com.mes.asset.controller;

import com.mes.common.BaseController;
import com.mes.asset.entity.MaintenanceRecord;
import com.mes.asset.service.MaintenanceRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/asset/maintenance")
public class MaintenanceRecordController extends BaseController<MaintenanceRecordService, MaintenanceRecord> {
    @Autowired
    private MaintenanceRecordService maintenanceRecordService;
    @Override
    protected MaintenanceRecordService getService() { return maintenanceRecordService; }
}
