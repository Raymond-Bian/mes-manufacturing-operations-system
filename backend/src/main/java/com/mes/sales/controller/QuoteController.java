package com.mes.sales.controller;

import com.mes.common.BaseController;
import com.mes.sales.entity.Quote;
import com.mes.sales.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sales/quote")
public class QuoteController extends BaseController<QuoteService, Quote> {
    @Autowired
    private QuoteService quoteService;
    @Override
    protected QuoteService getService() { return quoteService; }
}
