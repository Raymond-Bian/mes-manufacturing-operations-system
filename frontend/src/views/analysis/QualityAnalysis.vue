<template>
  <div class="page-container">
    <div class="page-header"><div class="page-title">质量分析</div></div>
    <el-row :gutter="16" style="margin-bottom: 16px">
      <el-col :span="14"><div class="chart-card"><div class="chart-title">月度合格率趋势</div><div ref="rateRef" style="height: 340px"></div></div></el-col>
      <el-col :span="10"><div class="chart-card"><div class="chart-title">缺陷类型分布</div><div ref="defectRef" style="height: 340px"></div></div></el-col>
    </el-row>
  </div>
</template>

<script setup lang="ts">
import { ref, onMounted } from 'vue'
import * as echarts from 'echarts'
import { AnalysisApi } from '@/api'

const rateRef = ref<HTMLElement>()
const defectRef = ref<HTMLElement>()

onMounted(async () => {
  const res: any = await AnalysisApi.quality()
  const d = res.data

  echarts.init(rateRef.value!).setOption({
    tooltip: { trigger: 'axis' },
    grid: { left: 40, right: 20, top: 20, bottom: 30 },
    xAxis: { type: 'category', data: d.months },
    yAxis: { type: 'value', min: 95, max: 100 },
    series: [{ type: 'line', data: d.passRates, smooth: true, areaStyle: { opacity: 0.3 }, itemStyle: { color: '#67c23a' }, lineStyle: { width: 3 } }]
  })

  echarts.init(defectRef.value!).setOption({
    tooltip: { trigger: 'item' },
    series: [{
      type: 'pie', radius: '60%', roseType: 'radius',
      data: d.defectTypes.map((t: any) => ({ name: t.name, value: t.value })),
      label: { formatter: '{b}: {c}' }
    }]
  })
})
</script>
