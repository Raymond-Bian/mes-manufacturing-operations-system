package com.mes.manufacturing.controller;

import com.mes.common.BaseController;
import com.mes.manufacturing.entity.OeeRecord;
import com.mes.manufacturing.service.OeeRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manufacturing/oee")
public class OeeRecordController extends BaseController<OeeRecordService, OeeRecord> {
    @Autowired
    private OeeRecordService oeeRecordService;
    @Override
    protected OeeRecordService getService() { return oeeRecordService; }
}
