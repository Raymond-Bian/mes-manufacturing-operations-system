<template>
  <CrudTable title="采购订单" api-path="/purchase/order" :columns="columns" />
</template>

<script setup lang="ts">
import CrudTable from '@/components/CrudTable.vue'
const columns = [
  { prop: 'orderNo', label: '订单号' },
  { prop: 'supplierName', label: '供应商' },
  { prop: 'materialName', label: '物料' },
  { prop: 'quantity', label: '数量' },
  { prop: 'totalAmount', label: '金额' },
  { prop: 'deliveryDate', label: '交货期' },
  { prop: 'status', label: '状态', tag: true }
]
</script>
