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
@TableName("biz_production_plan")
public class ProductionPlan extends BaseEntity {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String planNo;
    private String productCode;
    private String productName;
    private BigDecimal planQty;
    private String workCenter;
    private LocalDate startDate;
    private LocalDate endDate;
    private String scheduleType;
    private String status;
    private String remark;
}
