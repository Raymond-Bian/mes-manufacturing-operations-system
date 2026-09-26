<template>
  <CrudTable title="销售订单" api-path="/sales/order" :columns="columns" />
</template>

<script setup lang="ts">
import CrudTable from '@/components/CrudTable.vue'
const columns = [
  { prop: 'orderNo', label: '订单号' },
  { prop: 'customerName', label: '客户名称' },
  { prop: 'productName', label: '产品名称' },
  { prop: 'quantity', label: '数量' },
  { prop: 'totalAmount', label: '金额' },
  { prop: 'deliveryDate', label: '交期' },
  { prop: 'status', label: '状态', tag: true }
]
</script>
