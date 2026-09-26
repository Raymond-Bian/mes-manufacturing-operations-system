package com.mes.quality.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mes.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("biz_inspection")
public class Inspection extends BaseEntity {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String inspectionNo;
    private String sourceType;
    private String sourceNo;
    private String materialCode;
    private String materialName;
    private BigDecimal sampleQty;
    private BigDecimal inspectedQty;
    private BigDecimal passedQty;
    private BigDecimal failedQty;
    private String inspector;
    private String result;
    private String status;
    private String remark;
}
