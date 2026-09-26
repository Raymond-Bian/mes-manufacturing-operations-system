package com.mes.sales.service;

import com.mes.common.BaseService;
import com.mes.sales.entity.SalesForecast;
import com.mes.sales.mapper.SalesForecastMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalesForecastService extends BaseService<SalesForecastMapper, SalesForecast> {
    @Autowired
    private SalesForecastMapper salesForecastMapper;
    @Override
    protected SalesForecastMapper getMapper() { return salesForecastMapper; }
}
