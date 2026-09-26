package com.mes.asset.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mes.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("biz_maintenance_record")
public class MaintenanceRecord extends BaseEntity {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String maintenanceNo;
    private String equipmentCode;
    private String equipmentName;
    private String maintenanceType;
    private String description;
    private LocalDate maintenanceDate;
    private String technician;
    private BigDecimal cost;
    private String status;
    private String remark;
}
