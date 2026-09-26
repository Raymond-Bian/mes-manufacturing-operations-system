package com.mes.quality.controller;

import com.mes.common.BaseController;
import com.mes.quality.entity.Capa;
import com.mes.quality.service.CapaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quality/capa")
public class CapaController extends BaseController<CapaService, Capa> {
    @Autowired
    private CapaService capaService;
    @Override
    protected CapaService getService() { return capaService; }
}
