package com.mes.manufacturing.service;

import com.mes.common.BaseService;
import com.mes.manufacturing.entity.EquipmentStatus;
import com.mes.manufacturing.mapper.EquipmentStatusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipmentStatusService extends BaseService<EquipmentStatusMapper, EquipmentStatus> {
    @Autowired
    private EquipmentStatusMapper equipmentStatusMapper;
    @Override
    protected EquipmentStatusMapper getMapper() { return equipmentStatusMapper; }
}
