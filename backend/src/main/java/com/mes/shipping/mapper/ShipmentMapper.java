package com.mes.shipping.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mes.shipping.entity.Shipment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ShipmentMapper extends BaseMapper<Shipment> {
}
