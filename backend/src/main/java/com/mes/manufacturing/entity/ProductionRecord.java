package com.mes.manufacturing.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mes.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("biz_production_record")
public class ProductionRecord extends BaseEntity {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String workOrderNo;
    private String productCode;
    private String productName;
    private String workCenter;
    private BigDecimal producedQty;
    private BigDecimal rejectedQty;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String operator;
    private String status;
    private String remark;
}
