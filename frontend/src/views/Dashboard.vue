<template>
  <div class="page-container">
    <div class="page-header">
      <div class="page-title">运营总览</div>
      <el-button type="primary" :icon="Refresh" @click="loadData">刷新</el-button>
    </div>

    <el-row :gutter="16" style="margin-bottom: 16px">
      <el-col :span="4" v-for="item in statCards" :key="item.label">
        <div class="stat-card">
          <div class="stat-value">{{ item.value }}</div>
          <div class="stat-label">{{ item.label }}</div>
        </div>
      </el-col>
    </el-row>

    <el-row :gutter="16" style="margin-bottom: 16px">
      <el-col :span="12">
        <div class="chart-card">
          <div class="chart-title">销售趋势</div>
          <div ref="salesChartRef" style="height: 320px"></div>
        </div>
      </el-col>
      <el-col :span="12">
        <div class="chart-card">
          <div class="chart-title">生产计划达成</div>
          <div ref="productionChartRef" style="height: 320px"></div>
        </div>
      </el-col>
    </el-row>

    <el-row :gutter="16">
      <el-col :span="8">
        <div class="chart-card">
          <div class="chart-title">质量合格率</div>
          <div ref="qualityChartRef" style="height: 280px"></div>
        </div>
      </el-col>
      <el-col :span="8">
        <div class="chart-card">
          <div class="chart-title">OEE设备综合效率</div>
          <div ref="oeeChartRef" style="height: 280px"></div>
        </div>
      </el-col>
      <el-col :span="8">
        <div class="chart-card">
          <div class="chart-title">订单状态分布</div>
          <div ref="orderChartRef" style="height: 280px"></div>
        </div>
      </el-col>
    </el-row>
  </div>
</template>

<script setup lang="ts">
import { ref, onMounted } from 'vue'
import * as echarts from 'echarts'
import { AnalysisApi } from '@/api'
import { Refresh } from '@element-plus/icons-vue'

const statCards = ref([
  { label: '销售金额(万元)', value: '0' },
  { label: '订单数量', value: '0' },
  { label: '生产数量', value: '0' },
  { label: '合格率(%)', value: '0' },
  { label: 'OEE(%)', value: '0' },
  { label: '准时交付率(%)', value: '0' }
])

const salesChartRef = ref<HTMLElement>()
const productionChartRef = ref<HTMLElement>()
const qualityChartRef = ref<HTMLElement>()
const oeeChartRef = ref<HTMLElement>()
const orderChartRef = ref<HTMLElement>()

async function loadData() {
  const res: any = await AnalysisApi.overview()
  const d = res.data
  statCards.value[0].value = (d.salesAmount / 10000).toFixed(1)
  statCards.value[1].value = d.orderCount
  statCards.value[2].value = d.productionQty
  statCards.value[3].value = d.qualifiedRate
  statCards.value[4].value = d.oee
  statCards.value[5].value = d.onTimeDelivery
}

function initCharts() {
  // 销售趋势
  const salesChart = echarts.init(salesChartRef.value!)
  salesChart.setOption({
    tooltip: { trigger: 'axis' },
    legend: { data: ['销售额', '订单数'] },
    grid: { left: 40, right: 20, top: 40, bottom: 30 },
    xAxis: { type: 'category', data: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月'] },
    yAxis: [{ type: 'value', name: '万元' }, { type: 'value', name: '单' }],
    series: [
      { name: '销售额', type: 'bar', data: [820, 932, 901, 934, 1290, 1330, 1320, 1450, 1380, 1520, 1460, 1680], itemStyle: { color: '#409eff' } },
      { name: '订单数', type: 'line', yAxisIndex: 1, data: [12, 15, 14, 16, 18, 20, 19, 22, 21, 24, 23, 26], smooth: true, itemStyle: { color: '#67c23a' } }
    ]
  })

  // 生产计划达成
  const prodChart = echarts.init(productionChartRef.value!)
  prodChart.setOption({
    tooltip: { trigger: 'axis' },
    legend: { data: ['计划产量', '实际产量'] },
    grid: { left: 40, right: 20, top: 40, bottom: 30 },
    xAxis: { type: 'category', data: ['1月', '2月', '3月', '4月', '5月', '6月'] },
    yAxis: { type: 'value' },
    series: [
      { name: '计划产量', type: 'bar', data: [8000, 8500, 9000, 9200, 9500, 10000], itemStyle: { color: '#e6a23c' } },
      { name: '实际产量', type: 'bar', data: [7800, 8600, 8800, 9400, 9300, 10200], itemStyle: { color: '#67c23a' } }
    ]
  })

  // 质量合格率
  const qualityChart = echarts.init(qualityChartRef.value!)
  qualityChart.setOption({
    tooltip: { trigger: 'axis' },
    grid: { left: 40, right: 20, top: 20, bottom: 30 },
    xAxis: { type: 'category', data: ['1月', '2月', '3月', '4月', '5月', '6月'] },
    yAxis: { type: 'value', min: 95, max: 100 },
    series: [{ name: '合格率', type: 'line', data: [96.5, 97.2, 98.1, 97.8, 98.5, 98.9], smooth: true, areaStyle: { opacity: 0.3 }, itemStyle: { color: '#67c23a' } }]
  })

  // OEE
  const oeeChart = echarts.init(oeeChartRef.value!)
  oeeChart.setOption({
    tooltip: { trigger: 'axis' },
    legend: { data: ['可用率', '性能率', '质量率', 'OEE'] },
    grid: { left: 40, right: 20, top: 40, bottom: 30 },
    xAxis: { type: 'category', data: ['周一', '周二', '周三', '周四', '周五', '周六'] },
    yAxis: { type: 'value', max: 100 },
    series: [
      { name: '可用率', type: 'line', data: [92, 90, 93, 91, 94, 88], smooth: true },
      { name: '性能率', type: 'line', data: [88, 85, 90, 87, 91, 82], smooth: true },
      { name: '质量率', type: 'line', data: [98, 99, 97, 98, 99, 98], smooth: true },
      { name: 'OEE', type: 'line', data: [79, 76, 81, 78, 84, 71], smooth: true, lineStyle: { width: 3 } }
    ]
  })

  // 订单状态分布
  const orderChart = echarts.init(orderChartRef.value!)
  orderChart.setOption({
    tooltip: { trigger: 'item' },
    series: [{
      type: 'pie',
      radius: ['40%', '70%'],
      data: [
        { value: 45, name: '已完成', itemStyle: { color: '#67c23a' } },
        { value: 32, name: '生产中', itemStyle: { color: '#409eff' } },
        { value: 18, name: '待排产', itemStyle: { color: '#e6a23c' } },
        { value: 8, name: '已取消', itemStyle: { color: '#f56c6c' } }
      ],
      label: { formatter: '{b}: {c} ({d}%)' }
    }]
  })
}

onMounted(() => {
  loadData()
  initCharts()
})
</script>
