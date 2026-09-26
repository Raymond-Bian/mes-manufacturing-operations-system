<template>
  <div class="page-container">
    <div class="page-header"><div class="page-title">供应商分析</div></div>
    <el-row :gutter="16" style="margin-bottom: 16px">
      <el-col :span="10"><div class="chart-card"><div class="chart-title">供应商分类分布</div><div ref="catRef" style="height: 340px"></div></div></el-col>
      <el-col :span="14"><div class="chart-card"><div class="chart-title">供应商绩效评级</div><div ref="perfRef" style="height: 340px"></div></div></el-col>
    </el-row>
  </div>
</template>

<script setup lang="ts">
import { ref, onMounted } from 'vue'
import * as echarts from 'echarts'
import { AnalysisApi } from '@/api'

const catRef = ref<HTMLElement>()
const perfRef = ref<HTMLElement>()

onMounted(async () => {
  const res: any = await AnalysisApi.supplier()
  const d = res.data

  echarts.init(catRef.value!).setOption({
    tooltip: { trigger: 'item' },
    series: [{ type: 'pie', radius: ['40%', '70%'], data: d.categories.map((c: string, i: number) => ({ name: c, value: d.counts[i] })) }]
  })

  echarts.init(perfRef.value!).setOption({
    tooltip: { trigger: 'axis' },
    legend: { data: ['评级', '准时交付率'] },
    grid: { left: 40, right: 20, top: 40, bottom: 30 },
    xAxis: { type: 'category', data: d.performance.map((p: any) => p.name) },
    yAxis: { type: 'value', max: 100 },
    series: [
      { name: '评级', type: 'bar', data: d.performance.map((p: any) => p.rating), itemStyle: { color: '#409eff' } },
      { name: '准时交付率', type: 'bar', data: d.performance.map((p: any) => p.onTime), itemStyle: { color: '#67c23a' } }
    ]
  })
})
</script>
