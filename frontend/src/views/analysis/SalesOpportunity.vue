<template>
  <div class="page-container">
    <div class="page-header"><div class="page-title">销售机会分析</div></div>
    <el-row :gutter="16" style="margin-bottom: 16px">
      <el-col :span="8"><div class="stat-card"><div class="stat-value">{{ winRate }}%</div><div class="stat-label">整体赢单率</div></div></el-col>
      <el-col :span="8"><div class="stat-card"><div class="stat-value">{{ totalOpportunity }}</div><div class="stat-label">机会总数</div></div></el-col>
      <el-col :span="8"><div class="stat-card"><div class="stat-value">{{ totalAmount }}万</div><div class="stat-label">机会总金额</div></div></el-col>
    </el-row>
    <el-row :gutter="16">
      <el-col :span="14"><div class="chart-card"><div class="chart-title">销售漏斗</div><div ref="funnelRef" style="height: 380px"></div></div></el-col>
      <el-col :span="10"><div class="chart-card"><div class="chart-title">各阶段金额分布</div><div ref="amountRef" style="height: 380px"></div></div></el-col>
    </el-row>
  </div>
</template>

<script setup lang="ts">
import { ref, onMounted } from 'vue'
import * as echarts from 'echarts'
import { AnalysisApi } from '@/api'

const winRate = ref(0)
const totalOpportunity = ref(0)
const totalAmount = ref(0)
const funnelRef = ref<HTMLElement>()
const amountRef = ref<HTMLElement>()

onMounted(async () => {
  const res: any = await AnalysisApi.salesOpportunity()
  const d = res.data
  winRate.value = d.winRate
  totalOpportunity.value = d.counts.reduce((a: number, b: number) => a + b, 0)
  totalAmount.value = d.amounts.reduce((a: number, b: number) => a + b, 0)

  echarts.init(funnelRef.value!).setOption({
    tooltip: { trigger: 'item' },
    series: [{
      type: 'funnel', left: '10%', width: '80%',
      data: d.stages.map((s: string, i: number) => ({ name: s, value: d.counts[i] }))
    }]
  })

  echarts.init(amountRef.value!).setOption({
    tooltip: { trigger: 'axis' },
    grid: { left: 40, right: 20, top: 20, bottom: 30 },
    xAxis: { type: 'value' },
    yAxis: { type: 'category', data: d.stages },
    series: [{ type: 'bar', data: d.amounts, itemStyle: { color: '#409eff' }, label: { show: true, position: 'right' } }]
  })
})
</script>
