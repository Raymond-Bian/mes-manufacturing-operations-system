<template>
  <CrudTable title="供应商管理" api-path="/purchase/supplier" :columns="columns" />
</template>

<script setup lang="ts">
import CrudTable from '@/components/CrudTable.vue'
const columns = [
  { prop: 'supplierCode', label: '供应商编码' },
  { prop: 'supplierName', label: '供应商名称' },
  { prop: 'contact', label: '联系人' },
  { prop: 'phone', label: '电话' },
  { prop: 'category', label: '分类' },
  { prop: 'rating', label: '评级' },
  { prop: 'status', label: '状态', tag: true }
]
</script>
