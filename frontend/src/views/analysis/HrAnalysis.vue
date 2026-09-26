<template>
  <div class="page-container">
    <div class="page-header"><div class="page-title">人力分析</div></div>
    <el-row :gutter="16" style="margin-bottom: 16px">
      <el-col :span="6" v-for="item in statCards" :key="item.label">
        <div class="stat-card"><div class="stat-value">{{ item.value }}</div><div class="stat-label">{{ item.label }}</div></div>
      </el-col>
    </el-row>
    <div class="chart-card"><div class="chart-title">各部门人数分布</div><div ref="deptRef" style="height: 340px"></div></div>
  </div>
</template>

<script setup lang="ts">
import { ref, onMounted } from 'vue'
import * as echarts from 'echarts'
import { AnalysisApi } from '@/api'

const statCards = ref([
  { label: '出勤率(%)', value: '0' },
  { label: '总人数', value: '0' },
  { label: '加班工时', value: '0' },
  { label: '培训工时', value: '0' }
])
const deptRef = ref<HTMLElement>()

onMounted(async () => {
  const res: any = await AnalysisApi.hr()
  const d = res.data
  statCards.value[0].value = d.attendanceRate
  statCards.value[1].value = d.headCounts.reduce((a: number, b: number) => a + b, 0)
  statCards.value[2].value = d.overtimeHours
  statCards.value[3].value = d.trainingHours

  echarts.init(deptRef.value!).setOption({
    tooltip: { trigger: 'axis' },
    grid: { left: 50, right: 20, top: 20, bottom: 30 },
    xAxis: { type: 'category', data: d.departments },
    yAxis: { type: 'value' },
    series: [{ type: 'bar', data: d.headCounts, itemStyle: { color: '#409eff' }, label: { show: true, position: 'top' } }]
  })
})
</script>
