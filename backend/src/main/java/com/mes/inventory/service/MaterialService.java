package com.mes.inventory.service;

import com.mes.common.BaseService;
import com.mes.inventory.entity.Material;
import com.mes.inventory.mapper.MaterialMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaterialService extends BaseService<MaterialMapper, Material> {
    @Autowired
    private MaterialMapper materialMapper;
    @Override
    protected MaterialMapper getMapper() { return materialMapper; }
}
