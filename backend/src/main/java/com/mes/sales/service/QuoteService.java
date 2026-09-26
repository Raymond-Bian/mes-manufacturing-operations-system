package com.mes.sales.service;

import com.mes.common.BaseService;
import com.mes.sales.entity.Quote;
import com.mes.sales.mapper.QuoteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuoteService extends BaseService<QuoteMapper, Quote> {
    @Autowired
    private QuoteMapper quoteMapper;
    @Override
    protected QuoteMapper getMapper() { return quoteMapper; }
}
