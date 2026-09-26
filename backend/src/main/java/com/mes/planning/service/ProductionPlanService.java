package com.mes.planning.service;

import com.mes.common.BaseService;
import com.mes.planning.entity.ProductionPlan;
import com.mes.planning.mapper.ProductionPlanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductionPlanService extends BaseService<ProductionPlanMapper, ProductionPlan> {
    @Autowired
    private ProductionPlanMapper productionPlanMapper;
    @Override
    protected ProductionPlanMapper getMapper() { return productionPlanMapper; }
}
