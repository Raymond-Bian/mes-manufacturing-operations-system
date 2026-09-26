package com.mes.system.controller;

import com.mes.common.Result;
import com.mes.system.entity.SysMenu;
import com.mes.system.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/system/menu")
public class SysMenuController {

    @Autowired
    private SysMenuService menuService;

    @GetMapping("/list")
    public Result<List<SysMenu>> list() {
        return Result.success(menuService.list());
    }

    @PostMapping
    public Result<Void> save(@RequestBody SysMenu menu) {
        menuService.save(menu);
        return Result.success();
    }

    @PutMapping
    public Result<Void> update(@RequestBody SysMenu menu) {
        menuService.update(menu);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result<Void> delete(@PathVariable Long id) {
        menuService.delete(id);
        return Result.success();
    }
}
