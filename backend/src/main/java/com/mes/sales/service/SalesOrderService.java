package com.mes.sales.service;

import com.mes.common.BaseService;
import com.mes.sales.entity.SalesOrder;
import com.mes.sales.mapper.SalesOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalesOrderService extends BaseService<SalesOrderMapper, SalesOrder> {
    @Autowired
    private SalesOrderMapper salesOrderMapper;
    @Override
    protected SalesOrderMapper getMapper() { return salesOrderMapper; }
}
