package com.mes.purchase.controller;

import com.mes.common.BaseController;
import com.mes.purchase.entity.PurchaseOrder;
import com.mes.purchase.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/purchase/order")
public class PurchaseOrderController extends BaseController<PurchaseOrderService, PurchaseOrder> {
    @Autowired
    private PurchaseOrderService purchaseOrderService;
    @Override
    protected PurchaseOrderService getService() { return purchaseOrderService; }
}
