<template>
  <CrudTable title="工单管理" api-path="/planning/workorder" :columns="columns" />
</template>

<script setup lang="ts">
import CrudTable from '@/components/CrudTable.vue'
const columns = [
  { prop: 'orderNo', label: '工单号' },
  { prop: 'planNo', label: '计划号' },
  { prop: 'productName', label: '产品' },
  { prop: 'planQty', label: '计划数量' },
  { prop: 'completedQty', label: '已完成' },
  { prop: 'workCenter', label: '工作中心' },
  { prop: 'priority', label: '优先级', tag: true },
  { prop: 'status', label: '状态', tag: true }
]
</script>
