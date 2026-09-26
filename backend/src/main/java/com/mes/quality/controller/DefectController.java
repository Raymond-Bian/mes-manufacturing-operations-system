package com.mes.quality.controller;

import com.mes.common.BaseController;
import com.mes.quality.entity.Defect;
import com.mes.quality.service.DefectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quality/defect")
public class DefectController extends BaseController<DefectService, Defect> {
    @Autowired
    private DefectService defectService;
    @Override
    protected DefectService getService() { return defectService; }
}
