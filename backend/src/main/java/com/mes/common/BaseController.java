package com.mes.common;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.web.bind.annotation.*;
import java.util.List;

public abstract class BaseController<S extends BaseService<?, T>, T> {

    protected abstract S getService();

    @GetMapping("/page")
    public Result<PageResult<T>> page(@RequestParam(defaultValue = "1") Long current,
                                      @RequestParam(defaultValue = "10") Long size) {
        return Result.success(getService().page(current, size, null));
    }

    @GetMapping("/list")
    public Result<List<T>> list() {
        return Result.success(getService().list(null));
    }

    @GetMapping("/{id}")
    public Result<T> get(@PathVariable Long id) {
        return Result.success(getService().getById(id));
    }

    @PostMapping
    public Result<Void> save(@RequestBody T entity) {
        getService().save(entity);
        return Result.success();
    }

    @PutMapping
    public Result<Void> update(@RequestBody T entity) {
        getService().update(entity);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result<Void> delete(@PathVariable Long id) {
        getService().delete(id);
        return Result.success();
    }
}
