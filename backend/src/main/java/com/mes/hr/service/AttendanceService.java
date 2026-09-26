package com.mes.hr.service;

import com.mes.common.BaseService;
import com.mes.hr.entity.Attendance;
import com.mes.hr.mapper.AttendanceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendanceService extends BaseService<AttendanceMapper, Attendance> {
    @Autowired
    private AttendanceMapper attendanceMapper;
    @Override
    protected AttendanceMapper getMapper() { return attendanceMapper; }
}
