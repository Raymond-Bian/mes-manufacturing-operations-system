<template>
  <CrudTable title="库存查询" api-path="/inventory/stock" :columns="columns" />
</template>

<script setup lang="ts">
import CrudTable from '@/components/CrudTable.vue'
const columns = [
  { prop: 'materialCode', label: '物料编码' },
  { prop: 'materialName', label: '物料名称' },
  { prop: 'warehouseCode', label: '仓库' },
  { prop: 'locationCode', label: '库位' },
  { prop: 'batchNo', label: '批次号' },
  { prop: 'quantity', label: '数量' },
  { prop: 'unit', label: '单位' },
  { prop: 'status', label: '状态', tag: true }
]
</script>
