<template>
  <CrudTable title="仓库管理" api-path="/warehouse/info" :columns="columns" />
</template>

<script setup lang="ts">
import CrudTable from '@/components/CrudTable.vue'
const columns = [
  { prop: 'warehouseCode', label: '仓库编码' },
  { prop: 'warehouseName', label: '仓库名称' },
  { prop: 'warehouseType', label: '类型' },
  { prop: 'address', label: '地址' },
  { prop: 'manager', label: '负责人' },
  { prop: 'status', label: '状态', tag: true }
]
</script>
