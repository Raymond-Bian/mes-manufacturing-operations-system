package com.mes.shipping.controller;

import com.mes.common.BaseController;
import com.mes.shipping.entity.Shipment;
import com.mes.shipping.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shipping/order")
public class ShipmentController extends BaseController<ShipmentService, Shipment> {
    @Autowired
    private ShipmentService shipmentService;
    @Override
    protected ShipmentService getService() { return shipmentService; }
}
