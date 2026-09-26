package com.mes.planning.controller;

import com.mes.common.BaseController;
import com.mes.planning.entity.ProductionPlan;
import com.mes.planning.service.ProductionPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/planning/plan")
public class ProductionPlanController extends BaseController<ProductionPlanService, ProductionPlan> {
    @Autowired
    private ProductionPlanService productionPlanService;
    @Override
    protected ProductionPlanService getService() { return productionPlanService; }
}
