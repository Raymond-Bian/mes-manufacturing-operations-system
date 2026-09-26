package com.mes.shipping.entity;

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
@TableName("biz_shipment")
public class Shipment extends BaseEntity {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String shipmentNo;
    private String salesOrderNo;
    private Long customerId;
    private String customerName;
    private String productCode;
    private String productName;
    private BigDecimal quantity;
    private LocalDate shipDate;
    private String carrier;
    private String trackingNo;
    private String status;
    private String remark;
}
