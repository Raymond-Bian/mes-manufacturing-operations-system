<template>
  <CrudTable title="设备资产" api-path="/asset/equipment" :columns="columns" />
</template>

<script setup lang="ts">
import CrudTable from '@/components/CrudTable.vue'
const columns = [
  { prop: 'equipmentCode', label: '设备编码' },
  { prop: 'equipmentName', label: '设备名称' },
  { prop: 'equipmentType', label: '类型' },
  { prop: 'workCenter', label: '工作中心' },
  { prop: 'manufacturer', label: '制造商' },
  { prop: 'model', label: '型号' },
  { prop: 'purchaseDate', label: '购置日期' },
  { prop: 'status', label: '状态', tag: true }
]
</script>
