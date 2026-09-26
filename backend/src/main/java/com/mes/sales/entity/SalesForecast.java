package com.mes.sales.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mes.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("biz_sales_forecast")
public class SalesForecast extends BaseEntity {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String forecastNo;
    private String productCode;
    private String productName;
    private String period;
    private BigDecimal forecastQty;
    private BigDecimal actualQty;
    private String status;
    private String remark;
}
