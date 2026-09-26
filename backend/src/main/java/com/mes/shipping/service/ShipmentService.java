package com.mes.shipping.service;

import com.mes.common.BaseService;
import com.mes.shipping.entity.Shipment;
import com.mes.shipping.mapper.ShipmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShipmentService extends BaseService<ShipmentMapper, Shipment> {
    @Autowired
    private ShipmentMapper shipmentMapper;
    @Override
    protected ShipmentMapper getMapper() { return shipmentMapper; }
}
