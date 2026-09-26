package com.mes.planning.entity;

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
@TableName("biz_work_order")
public class WorkOrder extends BaseEntity {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String orderNo;
    private String planNo;
    private String productCode;
    private String productName;
    private BigDecimal planQty;
    private BigDecimal completedQty;
    private String workCenter;
    private LocalDate planStart;
    private LocalDate planEnd;
    private String priority;
    private String status;
    private String remark;
}
