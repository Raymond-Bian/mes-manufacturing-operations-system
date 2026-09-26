package com.mes.asset.service;

import com.mes.common.BaseService;
import com.mes.asset.entity.Equipment;
import com.mes.asset.mapper.EquipmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipmentService extends BaseService<EquipmentMapper, Equipment> {
    @Autowired
    private EquipmentMapper equipmentMapper;
    @Override
    protected EquipmentMapper getMapper() { return equipmentMapper; }
}
