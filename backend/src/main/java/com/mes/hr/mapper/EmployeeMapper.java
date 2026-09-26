package com.mes.hr.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mes.hr.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
}
