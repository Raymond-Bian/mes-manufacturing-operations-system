package com.mes.inventory.controller;

import com.mes.common.BaseController;
import com.mes.inventory.entity.InventoryStock;
import com.mes.inventory.service.InventoryStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventory/stock")
public class InventoryStockController extends BaseController<InventoryStockService, InventoryStock> {
    @Autowired
    private InventoryStockService inventoryStockService;
    @Override
    protected InventoryStockService getService() { return inventoryStockService; }
}
