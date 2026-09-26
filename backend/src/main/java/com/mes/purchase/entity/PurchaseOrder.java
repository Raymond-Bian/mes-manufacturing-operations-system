package com.mes.purchase.entity;

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
@TableName("biz_purchase_order")
public class PurchaseOrder extends BaseEntity {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String orderNo;
    private Long supplierId;
    private String supplierName;
    private String materialCode;
    private String materialName;
    private BigDecimal quantity;
    private BigDecimal unitPrice;
    private BigDecimal totalAmount;
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private String status;
    private String remark;
}
