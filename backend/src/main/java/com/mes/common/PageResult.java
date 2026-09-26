package com.mes.common;

import lombok.Data;
import java.util.List;

@Data
public class PageResult<T> {
    private Long total;
    private List<T> records;
    private Long current;
    private Long size;

    public static <T> PageResult<T> of(Long total, List<T> records, Long current, Long size) {
        PageResult<T> r = new PageResult<>();
        r.setTotal(total);
        r.setRecords(records);
        r.setCurrent(current);
        r.setSize(size);
        return r;
    }
}
