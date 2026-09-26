<template>
  <div class="page-container">
    <div class="page-header">
      <div class="page-title">库存分析</div>
      <el-tag type="danger" v-if="warningItems > 0">预警物料: {{ warningItems }} 项</el-tag>
    </div>
    <el-row :gutter="16" style="margin-bottom: 16px">
      <el-col :span="12"><div class="chart-card"><div class="chart-title">库存分类分布</div><div ref="catRef" style="height: 340px"></div></div></el-col>
      <el-col :span="12"><div class="chart-card"><div class="chart-title">库存周转率</div><div ref="turnRef" style="height: 340px"></div></div></el-col>
    </el-row>
  </div>
</template>

<script setup lang="ts">
import { ref, onMounted } from 'vue'
import * as echarts from 'echarts'
import { AnalysisApi } from '@/api'

const warningItems = ref(0)
const catRef = ref<HTMLElement>()
const turnRef = ref<HTMLElement>()

onMounted(async () => {
  const res: any = await AnalysisApi.inventory()
  const d = res.data
  warningItems.value = d.warningItems

  echarts.init(catRef.value!).setOption({
    tooltip: { trigger: 'item' },
    series: [{ type: 'pie', radius: ['35%', '65%'], data: d.categories.map((c: string, i: number) => ({ name: c, value: d.quantities[i] })) }]
  })

  echarts.init(turnRef.value!).setOption({
    tooltip: { trigger: 'axis' },
    grid: { left: 60, right: 20, top: 20, bottom: 30 },
    xAxis: { type: 'category', data: d.turnoverRates.map((t: any) => t.name) },
    yAxis: { type: 'value' },
    series: [{ type: 'bar', data: d.turnoverRates.map((t: any) => t.value), itemStyle: { color: '#409eff' }, label: { show: true, position: 'top' } }]
  })
})
</script>
