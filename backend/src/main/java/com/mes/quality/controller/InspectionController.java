package com.mes.quality.controller;

import com.mes.common.BaseController;
import com.mes.quality.entity.Inspection;
import com.mes.quality.service.InspectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quality/inspection")
public class InspectionController extends BaseController<InspectionService, Inspection> {
    @Autowired
    private InspectionService inspectionService;
    @Override
    protected InspectionService getService() { return inspectionService; }
}
