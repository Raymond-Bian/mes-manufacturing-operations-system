package com.mes.common;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;

public abstract class BaseService<M extends BaseMapper<T>, T> {

    protected abstract M getMapper();

    public PageResult<T> page(Long current, Long size, LambdaQueryWrapper<T> wrapper) {
        Page<T> page = new Page<>(current, size);
        if (wrapper == null) wrapper = new LambdaQueryWrapper<>();
        Page<T> result = getMapper().selectPage(page, wrapper);
        return PageResult.of(result.getTotal(), result.getRecords(), current, size);
    }

    public List<T> list(LambdaQueryWrapper<T> wrapper) {
        return getMapper().selectList(wrapper != null ? wrapper : new LambdaQueryWrapper<>());
    }

    public T getById(Long id) {
        return getMapper().selectById(id);
    }

    public void save(T entity) {
        getMapper().insert(entity);
    }

    public void update(T entity) {
        getMapper().updateById(entity);
    }

    public void delete(Long id) {
        getMapper().deleteById(id);
    }
}
