package com.mes.document.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mes.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("biz_document")
public class Document extends BaseEntity {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String docNo;
    private String docName;
    private String docType;
    private String category;
    private String version;
    private String status;
    private String fileUrl;
    private String owner;
    private String approver;
    private String remark;
}
