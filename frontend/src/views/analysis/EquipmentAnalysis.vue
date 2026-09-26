<template>
  <div class="page-container">
    <div class="page-header"><div class="page-title">设备维护分析</div></div>
    <el-row :gutter="16" style="margin-bottom: 16px">
      <el-col :span="8"><div class="chart-card"><div class="chart-title">设备状态分布</div><div ref="statusRef" style="height: 280px"></div></div></el-col>
      <el-col :span="8"><div class="chart-card"><div class="chart-title">月度维护成本</div><div ref="costRef" style="height: 280px"></div></div></el-col>
      <el-col :span="8"><div class="chart-card"><div class="chart-title">MTBF趋势</div><div ref="mtbfRef" style="height: 280px"></div></div></el-col>
    </el-row>
  </div>
</template>

<script setup lang="ts">
import { ref, onMounted } from 'vue'
import * as echarts from 'echarts'
import { AnalysisApi } from '@/api'

const statusRef = ref<HTMLElement>()
const costRef = ref<HTMLElement>()
const mtbfRef = ref<HTMLElement>()

onMounted(async () => {
  const res: any = await AnalysisApi.equipment()
  const d = res.data

  echarts.init(statusRef.value!).setOption({
    tooltip: { trigger: 'item' },
    series: [{ type: 'pie', radius: '60%', data: d.status.map((s: any) => ({ name: s.name, value: s.value })) }]
  })

  echarts.init(costRef.value!).setOption({
    tooltip: { trigger: 'axis' },
    grid: { left: 40, right: 20, top: 20, bottom: 30 },
    xAxis: { type: 'category', data: d.months },
    yAxis: { type: 'value' },
    series: [{ type: 'bar', data: d.maintenanceCosts, itemStyle: { color: '#e6a23c' } }]
  })

  echarts.init(mtbfRef.value!).setOption({
    tooltip: { trigger: 'axis' },
    grid: { left: 40, right: 20, top: 20, bottom: 30 },
    xAxis: { type: 'category', data: d.months },
    yAxis: { type: 'value' },
    series: [{ type: 'line', data: d.mtbf, smooth: true, areaStyle: { opacity: 0.2 }, itemStyle: { color: '#409eff' } }]
  })
})
</script>
