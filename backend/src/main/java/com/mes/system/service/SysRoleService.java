package com.mes.system.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mes.common.PageResult;
import com.mes.system.entity.SysRole;
import com.mes.system.mapper.SysRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class SysRoleService {

    @Autowired
    private SysRoleMapper roleMapper;

    public PageResult<SysRole> page(Long current, Long size, String keyword) {
        Page<SysRole> page = new Page<>(current, size);
        LambdaQueryWrapper<SysRole> wrapper = new LambdaQueryWrapper<>();
        if (StringUtils.hasText(keyword)) {
            wrapper.like(SysRole::getRoleName, keyword);
        }
        wrapper.orderByDesc(SysRole::getId);
        Page<SysRole> result = roleMapper.selectPage(page, wrapper);
        return PageResult.of(result.getTotal(), result.getRecords(), current, size);
    }

    public void save(SysRole role) { roleMapper.insert(role); }
    public void update(SysRole role) { roleMapper.updateById(role); }
    public void delete(Long id) { roleMapper.deleteById(id); }
}
