<template>
  <CrudTable title="生产计划" api-path="/planning/plan" :columns="columns" />
</template>

<script setup lang="ts">
import CrudTable from '@/components/CrudTable.vue'
const columns = [
  { prop: 'planNo', label: '计划编号' },
  { prop: 'productName', label: '产品' },
  { prop: 'planQty', label: '计划数量' },
  { prop: 'workCenter', label: '工作中心' },
  { prop: 'startDate', label: '开始日期' },
  { prop: 'endDate', label: '结束日期' },
  { prop: 'scheduleType', label: '排程类型' },
  { prop: 'status', label: '状态', tag: true }
]
</script>
