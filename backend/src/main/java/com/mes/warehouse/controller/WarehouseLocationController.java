package com.mes.warehouse.controller;

import com.mes.common.BaseController;
import com.mes.warehouse.entity.WarehouseLocation;
import com.mes.warehouse.service.WarehouseLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/warehouse/location")
public class WarehouseLocationController extends BaseController<WarehouseLocationService, WarehouseLocation> {
    @Autowired
    private WarehouseLocationService warehouseLocationService;
    @Override
    protected WarehouseLocationService getService() { return warehouseLocationService; }
}
