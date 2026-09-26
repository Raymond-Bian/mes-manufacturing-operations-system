package com.mes.analysis.controller;

import com.mes.common.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;
import java.util.*;

@RestController
@RequestMapping("/analysis")
public class AnalysisController {

    @GetMapping("/overview")
    public Result<Map<String, Object>> overview() {
        Map<String, Object> data = new HashMap<>();
        data.put("salesAmount", new BigDecimal("1286500.00"));
        data.put("orderCount", 156);
        data.put("productionQty", new BigDecimal("8920"));
        data.put("qualifiedRate", new BigDecimal("98.5"));
        data.put("oee", new BigDecimal("85.3"));
        data.put("onTimeDelivery", new BigDecimal("96.2"));
        return Result.success(data);
    }

    @GetMapping("/sales-opportunity")
    public Result<Map<String, Object>> salesOpportunity() {
        Map<String, Object> data = new HashMap<>();
        data.put("stages", List.of("潜在客户", "需求确认", "方案报价", "商务谈判", "成交"));
        data.put("counts", List.of(45, 32, 28, 18, 12));
        data.put("amounts", List.of(280, 420, 560, 380, 620));
        data.put("winRate", new BigDecimal("38.5"));
        return Result.success(data);
    }

    @GetMapping("/sales-order")
    public Result<Map<String, Object>> salesOrder() {
        Map<String, Object> data = new HashMap<>();
        data.put("months", List.of("1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"));
        data.put("orderAmounts", List.of(820, 932, 901, 934, 1290, 1330, 1320, 1450, 1380, 1520, 1460, 1680));
        data.put("orderCounts", List.of(12, 15, 14, 16, 18, 20, 19, 22, 21, 24, 23, 26));
        data.put("topProducts", List.of(
                Map.of("name", "产品A", "value", 450),
                Map.of("name", "产品B", "value", 380),
                Map.of("name", "产品C", "value", 290),
                Map.of("name", "产品D", "value", 210),
                Map.of("name", "产品E", "value", 150)
        ));
        return Result.success(data);
    }

    @GetMapping("/production")
    public Result<Map<String, Object>> production() {
        Map<String, Object> data = new HashMap<>();
        data.put("months", List.of("1月", "2月", "3月", "4月", "5月", "6月"));
        data.put("planned", List.of(8000, 8500, 9000, 9200, 9500, 10000));
        data.put("actual", List.of(7800, 8600, 8800, 9400, 9300, 10200));
        data.put("workCenterEfficiency", List.of(
                Map.of("name", "加工中心A", "value", 92),
                Map.of("name", "加工中心B", "value", 88),
                Map.of("name", "装配线", "value", 95),
                Map.of("name", "包装线", "value", 90)
        ));
        return Result.success(data);
    }

    @GetMapping("/quality")
    public Result<Map<String, Object>> quality() {
        Map<String, Object> data = new HashMap<>();
        data.put("months", List.of("1月", "2月", "3月", "4月", "5月", "6月"));
        data.put("passRates", List.of(96.5, 97.2, 98.1, 97.8, 98.5, 98.9));
        data.put("defectTypes", List.of(
                Map.of("name", "尺寸偏差", "value", 32),
                Map.of("name", "外观缺陷", "value", 28),
                Map.of("name", "装配问题", "value", 18),
                Map.of("name", "材料问题", "value", 12),
                Map.of("name", "其他", "value", 10)
        ));
        return Result.success(data);
    }

    @GetMapping("/supplier")
    public Result<Map<String, Object>> supplier() {
        Map<String, Object> data = new HashMap<>();
        data.put("categories", List.of("原材料", "辅料", "设备", "包装材料", "服务"));
        data.put("counts", List.of(28, 15, 8, 12, 10));
        data.put("performance", List.of(
                Map.of("name", "供应商A", "rating", 95, "onTime", 98),
                Map.of("name", "供应商B", "rating", 88, "onTime", 92),
                Map.of("name", "供应商C", "rating", 92, "onTime", 95),
                Map.of("name", "供应商D", "rating", 85, "onTime", 88),
                Map.of("name", "供应商E", "rating", 90, "onTime", 93)
        ));
        return Result.success(data);
    }

    @GetMapping("/equipment")
    public Result<Map<String, Object>> equipment() {
        Map<String, Object> data = new HashMap<>();
        data.put("status", List.of(
                Map.of("name", "运行中", "value", 42),
                Map.of("name", "待机", "value", 8),
                Map.of("name", "维修中", "value", 5),
                Map.of("name", "故障", "value", 2)
        ));
        data.put("months", List.of("1月", "2月", "3月", "4月", "5月", "6月"));
        data.put("maintenanceCosts", List.of(15, 18, 12, 22, 16, 20));
        data.put("mtbf", List.of(180, 175, 190, 185, 200, 195));
        return Result.success(data);
    }

    @GetMapping("/inventory")
    public Result<Map<String, Object>> inventory() {
        Map<String, Object> data = new HashMap<>();
        data.put("categories", List.of("原材料", "在制品", "成品", "辅料", "包装材料"));
        data.put("quantities", List.of(5200, 3800, 4500, 1200, 800));
        data.put("turnoverRates", List.of(
                Map.of("name", "原材料", "value", 6.5),
                Map.of("name", "在制品", "value", 8.2),
                Map.of("name", "成品", "value", 7.8),
                Map.of("name", "辅料", "value", 12.3)
        ));
        data.put("warningItems", 15);
        return Result.success(data);
    }

    @GetMapping("/finance")
    public Result<Map<String, Object>> finance() {
        Map<String, Object> data = new HashMap<>();
        data.put("months", List.of("1月", "2月", "3月", "4月", "5月", "6月"));
        data.put("revenue", List.of(820, 932, 901, 934, 1290, 1330));
        data.put("cost", List.of(580, 650, 620, 660, 880, 910));
        data.put("profit", List.of(240, 282, 281, 274, 410, 420));
        data.put("costStructure", List.of(
                Map.of("name", "材料成本", "value", 45),
                Map.of("name", "人工成本", "value", 25),
                Map.of("name", "制造费用", "value", 18),
                Map.of("name", "管理费用", "value", 8),
                Map.of("name", "其他", "value", 4)
        ));
        return Result.success(data);
    }

    @GetMapping("/hr")
    public Result<Map<String, Object>> hr() {
        Map<String, Object> data = new HashMap<>();
        data.put("departments", List.of("生产部", "质量部", "工程部", "采购部", "销售部", "行政部"));
        data.put("headCounts", List.of(120, 35, 45, 18, 25, 15));
        data.put("attendanceRate", new BigDecimal("97.8"));
        data.put("overtimeHours", 850);
        data.put("trainingHours", 320);
        return Result.success(data);
    }
}
