package com.mes.hr.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mes.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("biz_employee")
public class Employee extends BaseEntity {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String empNo;
    private String empName;
    private String gender;
    private String phone;
    private String email;
    private String department;
    private String position;
    private String shift;
    private LocalDate hireDate;
    private String skills;
    private String status;
    private String remark;
}
