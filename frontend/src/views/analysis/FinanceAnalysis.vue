<template>
  <div class="page-container">
    <div class="page-header"><div class="page-title">财务分析</div></div>
    <el-row :gutter="16" style="margin-bottom: 16px">
      <el-col :span="14"><div class="chart-card"><div class="chart-title">收入成本利润趋势</div><div ref="trendRef" style="height: 340px"></div></div></el-col>
      <el-col :span="10"><div class="chart-card"><div class="chart-title">成本结构</div><div ref="costRef" style="height: 340px"></div></div></el-col>
    </el-row>
  </div>
</template>

<script setup lang="ts">
import { ref, onMounted } from 'vue'
import * as echarts from 'echarts'
import { AnalysisApi } from '@/api'

const trendRef = ref<HTMLElement>()
const costRef = ref<HTMLElement>()

onMounted(async () => {
  const res: any = await AnalysisApi.finance()
  const d = res.data

  echarts.init(trendRef.value!).setOption({
    tooltip: { trigger: 'axis' },
    legend: { data: ['收入', '成本', '利润'] },
    grid: { left: 50, right: 20, top: 40, bottom: 30 },
    xAxis: { type: 'category', data: d.months },
    yAxis: { type: 'value' },
    series: [
      { name: '收入', type: 'line', data: d.revenue, smooth: true, itemStyle: { color: '#409eff' } },
      { name: '成本', type: 'line', data: d.cost, smooth: true, itemStyle: { color: '#e6a23c' } },
      { name: '利润', type: 'line', data: d.profit, smooth: true, areaStyle: { opacity: 0.2 }, itemStyle: { color: '#67c23a' } }
    ]
  })

  echarts.init(costRef.value!).setOption({
    tooltip: { trigger: 'item' },
    series: [{ type: 'pie', radius: ['40%', '70%'], data: d.costStructure.map((c: any) => ({ name: c.name, value: c.value })), label: { formatter: '{b}: {d}%' } }]
  })
})
</script>
