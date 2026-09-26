<template>
  <CrudTable title="角色管理" api-path="/system/role" :columns="columns" />
</template>

<script setup lang="ts">
import CrudTable from '@/components/CrudTable.vue'
const columns = [
  { prop: 'roleName', label: '角色名称' },
  { prop: 'roleCode', label: '角色编码' },
  { prop: 'description', label: '描述' },
  { prop: 'status', label: '状态', tag: true }
]
</script>
