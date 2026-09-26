<template>
  <CrudTable title="销售预测" api-path="/sales/forecast" :columns="columns" />
</template>

<script setup lang="ts">
import CrudTable from '@/components/CrudTable.vue'
const columns = [
  { prop: 'forecastNo', label: '预测编号' },
  { prop: 'productName', label: '产品名称' },
  { prop: 'period', label: '周期' },
  { prop: 'forecastQty', label: '预测数量' },
  { prop: 'actualQty', label: '实际数量' },
  { prop: 'status', label: '状态', tag: true }
]
</script>
