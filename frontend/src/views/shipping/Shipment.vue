<template>
  <CrudTable title="发运管理" api-path="/shipping/order" :columns="columns" />
</template>

<script setup lang="ts">
import CrudTable from '@/components/CrudTable.vue'
const columns = [
  { prop: 'shipmentNo', label: '发运单号' },
  { prop: 'salesOrderNo', label: '销售订单' },
  { prop: 'customerName', label: '客户' },
  { prop: 'productName', label: '产品' },
  { prop: 'quantity', label: '数量' },
  { prop: 'shipDate', label: '发运日期' },
  { prop: 'carrier', label: '承运商' },
  { prop: 'status', label: '状态', tag: true }
]
</script>
