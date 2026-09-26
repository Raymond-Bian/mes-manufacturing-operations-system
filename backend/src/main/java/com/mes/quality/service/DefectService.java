package com.mes.quality.service;

import com.mes.common.BaseService;
import com.mes.quality.entity.Defect;
import com.mes.quality.mapper.DefectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefectService extends BaseService<DefectMapper, Defect> {
    @Autowired
    private DefectMapper defectMapper;
    @Override
    protected DefectMapper getMapper() { return defectMapper; }
}
