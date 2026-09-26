package com.mes.purchase.service;

import com.mes.common.BaseService;
import com.mes.purchase.entity.PurchaseOrder;
import com.mes.purchase.mapper.PurchaseOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseOrderService extends BaseService<PurchaseOrderMapper, PurchaseOrder> {
    @Autowired
    private PurchaseOrderMapper purchaseOrderMapper;
    @Override
    protected PurchaseOrderMapper getMapper() { return purchaseOrderMapper; }
}
