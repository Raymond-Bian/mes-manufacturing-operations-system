<template>
  <CrudTable title="维护记录" api-path="/asset/maintenance" :columns="columns" />
</template>

<script setup lang="ts">
import CrudTable from '@/components/CrudTable.vue'
const columns = [
  { prop: 'maintenanceNo', label: '维护单号' },
  { prop: 'equipmentName', label: '设备名称' },
  { prop: 'maintenanceType', label: '维护类型' },
  { prop: 'description', label: '描述' },
  { prop: 'maintenanceDate', label: '维护日期' },
  { prop: 'technician', label: '技术员' },
  { prop: 'cost', label: '费用' },
  { prop: 'status', label: '状态', tag: true }
]
</script>
