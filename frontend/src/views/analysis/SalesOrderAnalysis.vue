<template>
  <div class="page-container">
    <div class="page-header"><div class="page-title">销售订单分析</div></div>
    <el-row :gutter="16" style="margin-bottom: 16px">
      <el-col :span="12"><div class="chart-card"><div class="chart-title">月度销售趋势</div><div ref="trendRef" style="height: 340px"></div></div></el-col>
      <el-col :span="12"><div class="chart-card"><div class="chart-title">产品销售TOP5</div><div ref="topRef" style="height: 340px"></div></div></el-col>
    </el-row>
  </div>
</template>

<script setup lang="ts">
import { ref, onMounted } from 'vue'
import * as echarts from 'echarts'
import { AnalysisApi } from '@/api'

const trendRef = ref<HTMLElement>()
const topRef = ref<HTMLElement>()

onMounted(async () => {
  const res: any = await AnalysisApi.salesOrder()
  const d = res.data

  echarts.init(trendRef.value!).setOption({
    tooltip: { trigger: 'axis' },
    legend: { data: ['销售额', '订单数'] },
    grid: { left: 40, right: 20, top: 40, bottom: 30 },
    xAxis: { type: 'category', data: d.months },
    yAxis: [{ type: 'value', name: '万元' }, { type: 'value', name: '单' }],
    series: [
      { name: '销售额', type: 'bar', data: d.orderAmounts, itemStyle: { color: '#409eff' } },
      { name: '订单数', type: 'line', yAxisIndex: 1, data: d.orderCounts, smooth: true, itemStyle: { color: '#67c23a' } }
    ]
  })

  echarts.init(topRef.value!).setOption({
    tooltip: { trigger: 'item' },
    series: [{
      type: 'pie', radius: ['40%', '70%'],
      data: d.topProducts.map((p: any) => ({ name: p.name, value: p.value })),
      label: { formatter: '{b}: {d}%' }
    }]
  })
})
</script>
