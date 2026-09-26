package com.mes.manufacturing.entity;

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
@TableName("biz_oee_record")
public class OeeRecord extends BaseEntity {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String equipmentCode;
    private String equipmentName;
    private LocalDate recordDate;
    private BigDecimal availability;
    private BigDecimal performance;
    private BigDecimal quality;
    private BigDecimal oee;
    private String remark;
}
