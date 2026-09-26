package com.mes.inventory.controller;

import com.mes.common.BaseController;
import com.mes.inventory.entity.Material;
import com.mes.inventory.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventory/material")
public class MaterialController extends BaseController<MaterialService, Material> {
    @Autowired
    private MaterialService materialService;
    @Override
    protected MaterialService getService() { return materialService; }
}
