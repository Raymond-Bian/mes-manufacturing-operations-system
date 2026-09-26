package com.mes.manufacturing.service;

import com.mes.common.BaseService;
import com.mes.manufacturing.entity.ProductionRecord;
import com.mes.manufacturing.mapper.ProductionRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductionRecordService extends BaseService<ProductionRecordMapper, ProductionRecord> {
    @Autowired
    private ProductionRecordMapper productionRecordMapper;
    @Override
    protected ProductionRecordMapper getMapper() { return productionRecordMapper; }
}
