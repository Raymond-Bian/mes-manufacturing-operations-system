package com.mes.quality.service;

import com.mes.common.BaseService;
import com.mes.quality.entity.Inspection;
import com.mes.quality.mapper.InspectionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InspectionService extends BaseService<InspectionMapper, Inspection> {
    @Autowired
    private InspectionMapper inspectionMapper;
    @Override
    protected InspectionMapper getMapper() { return inspectionMapper; }
}
