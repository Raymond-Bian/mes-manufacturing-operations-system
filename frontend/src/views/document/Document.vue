<template>
  <CrudTable title="文档管理" api-path="/document/info" :columns="columns" />
</template>

<script setup lang="ts">
import CrudTable from '@/components/CrudTable.vue'
const columns = [
  { prop: 'docNo', label: '文档编号' },
  { prop: 'docName', label: '文档名称' },
  { prop: 'docType', label: '类型' },
  { prop: 'category', label: '分类' },
  { prop: 'version', label: '版本' },
  { prop: 'owner', label: '负责人' },
  { prop: 'status', label: '状态', tag: true }
]
</script>
