package com.mes.inventory.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mes.inventory.entity.InventoryStock;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InventoryStockMapper extends BaseMapper<InventoryStock> {
}
