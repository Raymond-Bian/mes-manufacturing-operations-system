package com.mes.sales.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mes.sales.entity.Quote;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QuoteMapper extends BaseMapper<Quote> {
}
