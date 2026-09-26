package com.mes.manufacturing.service;

import com.mes.common.BaseService;
import com.mes.manufacturing.entity.OeeRecord;
import com.mes.manufacturing.mapper.OeeRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OeeRecordService extends BaseService<OeeRecordMapper, OeeRecord> {
    @Autowired
    private OeeRecordMapper oeeRecordMapper;
    @Override
    protected OeeRecordMapper getMapper() { return oeeRecordMapper; }
}
