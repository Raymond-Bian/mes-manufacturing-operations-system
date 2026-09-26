<template>
  <CrudTable title="库位管理" api-path="/warehouse/location" :columns="columns" />
</template>

<script setup lang="ts">
import CrudTable from '@/components/CrudTable.vue'
const columns = [
  { prop: 'warehouseCode', label: '仓库编码' },
  { prop: 'locationCode', label: '库位编码' },
  { prop: 'locationName', label: '库位名称' },
  { prop: 'locationType', label: '类型' },
  { prop: 'status', label: '状态', tag: true }
]
</script>
