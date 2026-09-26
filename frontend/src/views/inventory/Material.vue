<template>
  <CrudTable title="物料主数据" api-path="/inventory/material" :columns="columns" />
</template>

<script setup lang="ts">
import CrudTable from '@/components/CrudTable.vue'
const columns = [
  { prop: 'materialCode', label: '物料编码' },
  { prop: 'materialName', label: '物料名称' },
  { prop: 'specification', label: '规格' },
  { prop: 'unit', label: '单位' },
  { prop: 'category', label: '分类' },
  { prop: 'unitPrice', label: '单价' },
  { prop: 'safetyStock', label: '安全库存' },
  { prop: 'status', label: '状态', tag: true }
]
</script>
