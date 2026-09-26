package com.mes.hr.controller;

import com.mes.common.BaseController;
import com.mes.hr.entity.Attendance;
import com.mes.hr.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hr/attendance")
public class AttendanceController extends BaseController<AttendanceService, Attendance> {
    @Autowired
    private AttendanceService attendanceService;
    @Override
    protected AttendanceService getService() { return attendanceService; }
}
