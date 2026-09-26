<template>
  <div class="page-container">
    <div class="page-header"><div class="page-title">生产分析</div></div>
    <el-row :gutter="16" style="margin-bottom: 16px">
      <el-col :span="14"><div class="chart-card"><div class="chart-title">计划 vs 实际产量</div><div ref="planRef" style="height: 340px"></div></div></el-col>
      <el-col :span="10"><div class="chart-card"><div class="chart-title">工作中心效率</div><div ref="effRef" style="height: 340px"></div></div></el-col>
    </el-row>
  </div>
</template>

<script setup lang="ts">
import { ref, onMounted } from 'vue'
import * as echarts from 'echarts'
import { AnalysisApi } from '@/api'

const planRef = ref<HTMLElement>()
const effRef = ref<HTMLElement>()

onMounted(async () => {
  const res: any = await AnalysisApi.production()
  const d = res.data

  echarts.init(planRef.value!).setOption({
    tooltip: { trigger: 'axis' },
    legend: { data: ['计划产量', '实际产量'] },
    grid: { left: 50, right: 20, top: 40, bottom: 30 },
    xAxis: { type: 'category', data: d.months },
    yAxis: { type: 'value' },
    series: [
      { name: '计划产量', type: 'bar', data: d.planned, itemStyle: { color: '#e6a23c' } },
      { name: '实际产量', type: 'bar', data: d.actual, itemStyle: { color: '#67c23a' } }
    ]
  })

  echarts.init(effRef.value!).setOption({
    tooltip: { trigger: 'axis' },
    grid: { left: 90, right: 20, top: 20, bottom: 30 },
    xAxis: { type: 'value', max: 100 },
    yAxis: { type: 'category', data: d.workCenterEfficiency.map((e: any) => e.name) },
    series: [{ type: 'bar', data: d.workCenterEfficiency.map((e: any) => e.value), itemStyle: { color: '#409eff' }, label: { show: true, position: 'right', formatter: '{c}%' } }]
  })
})
</script>
