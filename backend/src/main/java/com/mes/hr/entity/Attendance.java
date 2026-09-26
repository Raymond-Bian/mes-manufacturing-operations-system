package com.mes.hr.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mes.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("biz_attendance")
public class Attendance extends BaseEntity {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String empNo;
    private String empName;
    private LocalDate attendanceDate;
    private LocalTime checkIn;
    private LocalTime checkOut;
    private BigDecimal workHours;
    private BigDecimal overtimeHours;
    private String status;
    private String remark;
}
