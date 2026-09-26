package com.mes.manufacturing.controller;

import com.mes.common.BaseController;
import com.mes.manufacturing.entity.ProductionRecord;
import com.mes.manufacturing.service.ProductionRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manufacturing/record")
public class ProductionRecordController extends BaseController<ProductionRecordService, ProductionRecord> {
    @Autowired
    private ProductionRecordService productionRecordService;
    @Override
    protected ProductionRecordService getService() { return productionRecordService; }
}
