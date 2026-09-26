package com.mes.inventory.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mes.inventory.entity.Material;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MaterialMapper extends BaseMapper<Material> {
}
