package com.mes.warehouse.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mes.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("biz_warehouse_location")
public class WarehouseLocation extends BaseEntity {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String warehouseCode;
    private String locationCode;
    private String locationName;
    private String locationType;
    private String status;
    private String remark;
}
