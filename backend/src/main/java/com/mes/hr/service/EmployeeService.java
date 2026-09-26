package com.mes.hr.service;

import com.mes.common.BaseService;
import com.mes.hr.entity.Employee;
import com.mes.hr.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService extends BaseService<EmployeeMapper, Employee> {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Override
    protected EmployeeMapper getMapper() { return employeeMapper; }
}
