<template>
  <CrudTable title="报价管理" api-path="/sales/quote" :columns="columns" />
</template>

<script setup lang="ts">
import CrudTable from '@/components/CrudTable.vue'
const columns = [
  { prop: 'quoteNo', label: '报价单号' },
  { prop: 'customerName', label: '客户名称' },
  { prop: 'productName', label: '产品名称' },
  { prop: 'quantity', label: '数量' },
  { prop: 'materialCost', label: '材料成本' },
  { prop: 'laborCost', label: '人工成本' },
  { prop: 'totalPrice', label: '总报价' },
  { prop: 'status', label: '状态', tag: true }
]
</script>
