package com.mes.quality.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mes.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("biz_capa")
public class Capa extends BaseEntity {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String capaNo;
    private String sourceType;
    private String sourceNo;
    private String title;
    private String description;
    private String rootCause;
    private String correctiveAction;
    private String preventiveAction;
    private String responsible;
    private LocalDate dueDate;
    private String status;
    private String remark;
}
