<template>
  <CrudTable title="缺陷管理" api-path="/quality/defect" :columns="columns" />
</template>

<script setup lang="ts">
import CrudTable from '@/components/CrudTable.vue'
const columns = [
  { prop: 'defectNo', label: '缺陷编号' },
  { prop: 'inspectionNo', label: '检验单号' },
  { prop: 'materialCode', label: '物料编码' },
  { prop: 'defectType', label: '缺陷类型' },
  { prop: 'defectDesc', label: '缺陷描述' },
  { prop: 'qty', label: '数量' },
  { prop: 'severity', label: '严重程度', tag: true },
  { prop: 'status', label: '状态', tag: true }
]
</script>
