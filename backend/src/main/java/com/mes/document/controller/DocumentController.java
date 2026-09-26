package com.mes.document.controller;

import com.mes.common.BaseController;
import com.mes.document.entity.Document;
import com.mes.document.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/document/info")
public class DocumentController extends BaseController<DocumentService, Document> {
    @Autowired
    private DocumentService documentService;
    @Override
    protected DocumentService getService() { return documentService; }
}
