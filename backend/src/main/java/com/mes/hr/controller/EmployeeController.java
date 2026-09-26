package com.mes.hr.controller;

import com.mes.common.BaseController;
import com.mes.hr.entity.Employee;
import com.mes.hr.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hr/employee")
public class EmployeeController extends BaseController<EmployeeService, Employee> {
    @Autowired
    private EmployeeService employeeService;
    @Override
    protected EmployeeService getService() { return employeeService; }
}
