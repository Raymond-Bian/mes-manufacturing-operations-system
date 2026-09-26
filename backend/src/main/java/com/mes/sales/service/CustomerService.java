package com.mes.sales.service;

import com.mes.common.BaseService;
import com.mes.sales.entity.Customer;
import com.mes.sales.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService extends BaseService<CustomerMapper, Customer> {
    @Autowired
    private CustomerMapper customerMapper;

    @Override
    protected CustomerMapper getMapper() {
        return customerMapper;
    }
}
