package com.mes.sales.controller;

import com.mes.common.BaseController;
import com.mes.sales.entity.SalesForecast;
import com.mes.sales.service.SalesForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sales/forecast")
public class SalesForecastController extends BaseController<SalesForecastService, SalesForecast> {
    @Autowired
    private SalesForecastService salesForecastService;
    @Override
    protected SalesForecastService getService() { return salesForecastService; }
}
