package com.mes.purchase.controller;

import com.mes.common.BaseController;
import com.mes.purchase.entity.Supplier;
import com.mes.purchase.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/purchase/supplier")
public class SupplierController extends BaseController<SupplierService, Supplier> {
    @Autowired
    private SupplierService supplierService;
    @Override
    protected SupplierService getService() { return supplierService; }
}
