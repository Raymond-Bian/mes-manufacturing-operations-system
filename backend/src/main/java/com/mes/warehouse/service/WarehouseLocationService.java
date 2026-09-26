package com.mes.warehouse.service;

import com.mes.common.BaseService;
import com.mes.warehouse.entity.WarehouseLocation;
import com.mes.warehouse.mapper.WarehouseLocationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WarehouseLocationService extends BaseService<WarehouseLocationMapper, WarehouseLocation> {
    @Autowired
    private WarehouseLocationMapper warehouseLocationMapper;
    @Override
    protected WarehouseLocationMapper getMapper() { return warehouseLocationMapper; }
}
