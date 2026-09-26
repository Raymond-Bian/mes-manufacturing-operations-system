package com.mes.warehouse.service;

import com.mes.common.BaseService;
import com.mes.warehouse.entity.Warehouse;
import com.mes.warehouse.mapper.WarehouseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WarehouseService extends BaseService<WarehouseMapper, Warehouse> {
    @Autowired
    private WarehouseMapper warehouseMapper;
    @Override
    protected WarehouseMapper getMapper() { return warehouseMapper; }
}
