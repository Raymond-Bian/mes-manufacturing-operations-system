package com.mes.inventory.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mes.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("biz_inventory_stock")
public class InventoryStock extends BaseEntity {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String materialCode;
    private String materialName;
    private String warehouseCode;
    private String locationCode;
    private String batchNo;
    private BigDecimal quantity;
    private String unit;
    private String status;
    private String remark;
}
