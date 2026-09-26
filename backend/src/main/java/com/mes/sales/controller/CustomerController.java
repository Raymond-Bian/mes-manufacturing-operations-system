package com.mes.sales.controller;

import com.mes.common.BaseController;
import com.mes.sales.entity.Customer;
import com.mes.sales.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sales/customer")
public class CustomerController extends BaseController<CustomerService, Customer> {
    @Autowired
    private CustomerService customerService;

    @Override
    protected CustomerService getService() {
        return customerService;
    }
}
