<template>
  <CrudTable title="设备状态" api-path="/manufacturing/equipment" :columns="columns" />
</template>

<script setup lang="ts">
import CrudTable from '@/components/CrudTable.vue'
const columns = [
  { prop: 'equipmentCode', label: '设备编码' },
  { prop: 'equipmentName', label: '设备名称' },
  { prop: 'workCenter', label: '工作中心' },
  { prop: 'status', label: '状态', tag: true },
  { prop: 'runningState', label: '运行状态', tag: true },
  { prop: 'alarmInfo', label: '报警信息' }
]
</script>
