package com.mes.manufacturing.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mes.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("biz_equipment_status")
public class EquipmentStatus extends BaseEntity {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String equipmentCode;
    private String equipmentName;
    private String workCenter;
    private String status;
    private String runningState;
    private String alarmInfo;
    private String remark;
}
