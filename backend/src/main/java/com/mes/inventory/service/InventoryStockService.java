package com.mes.inventory.service;

import com.mes.common.BaseService;
import com.mes.inventory.entity.InventoryStock;
import com.mes.inventory.mapper.InventoryStockMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryStockService extends BaseService<InventoryStockMapper, InventoryStock> {
    @Autowired
    private InventoryStockMapper inventoryStockMapper;
    @Override
    protected InventoryStockMapper getMapper() { return inventoryStockMapper; }
}
