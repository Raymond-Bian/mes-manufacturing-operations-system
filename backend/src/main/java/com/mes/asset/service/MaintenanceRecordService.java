package com.mes.asset.service;

import com.mes.common.BaseService;
import com.mes.asset.entity.MaintenanceRecord;
import com.mes.asset.mapper.MaintenanceRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaintenanceRecordService extends BaseService<MaintenanceRecordMapper, MaintenanceRecord> {
    @Autowired
    private MaintenanceRecordMapper maintenanceRecordMapper;
    @Override
    protected MaintenanceRecordMapper getMapper() { return maintenanceRecordMapper; }
}
