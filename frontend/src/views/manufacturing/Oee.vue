<template>
  <CrudTable title="OEE记录" api-path="/manufacturing/oee" :columns="columns" />
</template>

<script setup lang="ts">
import CrudTable from '@/components/CrudTable.vue'
const columns = [
  { prop: 'equipmentCode', label: '设备编码' },
  { prop: 'equipmentName', label: '设备名称' },
  { prop: 'recordDate', label: '日期' },
  { prop: 'availability', label: '可用率(%)' },
  { prop: 'performance', label: '性能率(%)' },
  { prop: 'quality', label: '质量率(%)' },
  { prop: 'oee', label: 'OEE(%)' }
]
</script>
