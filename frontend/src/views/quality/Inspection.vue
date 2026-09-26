<template>
  <CrudTable title="检验管理" api-path="/quality/inspection" :columns="columns" />
</template>

<script setup lang="ts">
import CrudTable from '@/components/CrudTable.vue'
const columns = [
  { prop: 'inspectionNo', label: '检验单号' },
  { prop: 'sourceType', label: '来源类型' },
  { prop: 'materialName', label: '物料' },
  { prop: 'sampleQty', label: '抽样数' },
  { prop: 'inspectedQty', label: '检验数' },
  { prop: 'passedQty', label: '合格数' },
  { prop: 'failedQty', label: '不合格数' },
  { prop: 'result', label: '结果', tag: true }
]
</script>
