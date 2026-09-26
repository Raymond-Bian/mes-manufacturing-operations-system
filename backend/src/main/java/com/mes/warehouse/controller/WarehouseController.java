package com.mes.warehouse.controller;

import com.mes.common.BaseController;
import com.mes.warehouse.entity.Warehouse;
import com.mes.warehouse.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/warehouse/info")
public class WarehouseController extends BaseController<WarehouseService, Warehouse> {
    @Autowired
    private WarehouseService warehouseService;
    @Override
    protected WarehouseService getService() { return warehouseService; }
}
