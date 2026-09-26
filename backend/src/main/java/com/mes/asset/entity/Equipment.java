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
@TableName("biz_equipment")
public class Equipment extends BaseEntity {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String equipmentCode;
    private String equipmentName;
    private String equipmentType;
    private String workCenter;
    private String manufacturer;
    private String model;
    private LocalDate purchaseDate;
    private BigDecimal originalValue;
    private String status;
    private String remark;
}
