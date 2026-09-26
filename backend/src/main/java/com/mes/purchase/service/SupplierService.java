package com.mes.purchase.service;

import com.mes.common.BaseService;
import com.mes.purchase.entity.Supplier;
import com.mes.purchase.mapper.SupplierMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierService extends BaseService<SupplierMapper, Supplier> {
    @Autowired
    private SupplierMapper supplierMapper;
    @Override
    protected SupplierMapper getMapper() { return supplierMapper; }
}
