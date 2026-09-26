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
@TableName("biz_quote")
public class Quote extends BaseEntity {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String quoteNo;
    private Long customerId;
    private String customerName;
    private String productCode;
    private String productName;
    private BigDecimal quantity;
    private BigDecimal unitPrice;
    private BigDecimal materialCost;
    private BigDecimal laborCost;
    private BigDecimal expenseCost;
    private BigDecimal totalPrice;
    private String status;
    private String remark;
}
