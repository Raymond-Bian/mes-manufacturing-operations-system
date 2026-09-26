package com.mes.system.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.mes.system.entity.SysMenu;
import com.mes.system.mapper.SysMenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SysMenuService {

    @Autowired
    private SysMenuMapper menuMapper;

    public List<SysMenu> list() {
        return menuMapper.selectList(new LambdaQueryWrapper<SysMenu>().orderByAsc(SysMenu::getSort));
    }

    public void save(SysMenu menu) { menuMapper.insert(menu); }
    public void update(SysMenu menu) { menuMapper.updateById(menu); }
    public void delete(Long id) { menuMapper.deleteById(id); }
}
