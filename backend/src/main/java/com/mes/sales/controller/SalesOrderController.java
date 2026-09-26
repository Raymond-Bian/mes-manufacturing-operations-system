package com.mes.sales.controller;

import com.mes.common.BaseController;
import com.mes.sales.entity.SalesOrder;
import com.mes.sales.service.SalesOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sales/order")
public class SalesOrderController extends BaseController<SalesOrderService, SalesOrder> {
    @Autowired
    private SalesOrderService salesOrderService;
    @Override
    protected SalesOrderService getService() { return salesOrderService; }
}
