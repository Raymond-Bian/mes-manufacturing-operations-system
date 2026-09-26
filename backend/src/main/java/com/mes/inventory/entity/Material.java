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
@TableName("biz_material")
public class Material extends BaseEntity {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String materialCode;
    private String materialName;
    private String specification;
    private String unit;
    private String category;
    private BigDecimal unitPrice;
    private BigDecimal safetyStock;
    private BigDecimal maxStock;
    private String shelfLife;
    private String status;
    private String remark;
}
