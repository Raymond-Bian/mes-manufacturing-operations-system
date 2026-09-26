package com.mes.quality.service;

import com.mes.common.BaseService;
import com.mes.quality.entity.Capa;
import com.mes.quality.mapper.CapaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CapaService extends BaseService<CapaMapper, Capa> {
    @Autowired
    private CapaMapper capaMapper;
    @Override
    protected CapaMapper getMapper() { return capaMapper; }
}
