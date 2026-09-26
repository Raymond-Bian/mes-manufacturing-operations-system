<template>
  <CrudTable title="CAPA管理" api-path="/quality/capa" :columns="columns" />
</template>

<script setup lang="ts">
import CrudTable from '@/components/CrudTable.vue'
const columns = [
  { prop: 'capaNo', label: 'CAPA编号' },
  { prop: 'sourceType', label: '来源类型' },
  { prop: 'title', label: '标题' },
  { prop: 'rootCause', label: '根因分析' },
  { prop: 'responsible', label: '责任人' },
  { prop: 'dueDate', label: '截止日期' },
  { prop: 'status', label: '状态', tag: true }
]
</script>
