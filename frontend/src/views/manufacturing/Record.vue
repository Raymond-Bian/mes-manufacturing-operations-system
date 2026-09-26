<template>
  <CrudTable title="生产报工" api-path="/manufacturing/record" :columns="columns" />
</template>

<script setup lang="ts">
import CrudTable from '@/components/CrudTable.vue'
const columns = [
  { prop: 'workOrderNo', label: '工单号' },
  { prop: 'productName', label: '产品' },
  { prop: 'workCenter', label: '工作中心' },
  { prop: 'producedQty', label: '产出数量' },
  { prop: 'rejectedQty', label: '不良数量' },
  { prop: 'operator', label: '操作员' },
  { prop: 'startTime', label: '开始时间' },
  { prop: 'status', label: '状态', tag: true }
]
</script>
