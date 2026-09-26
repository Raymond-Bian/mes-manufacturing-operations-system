package com.mes.document.service;

import com.mes.common.BaseService;
import com.mes.document.entity.Document;
import com.mes.document.mapper.DocumentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentService extends BaseService<DocumentMapper, Document> {
    @Autowired
    private DocumentMapper documentMapper;
    @Override
    protected DocumentMapper getMapper() { return documentMapper; }
}
