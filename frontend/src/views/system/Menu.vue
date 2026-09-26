<template>
  <CrudTable title="菜单管理" api-path="/system/menu" :columns="columns" />
</template>

<script setup lang="ts">
import CrudTable from '@/components/CrudTable.vue'
const columns = [
  { prop: 'name', label: '菜单名称' },
  { prop: 'path', label: '路径' },
  { prop: 'component', label: '组件' },
  { prop: 'icon', label: '图标' },
  { prop: 'perm', label: '权限标识' },
  { prop: 'sort', label: '排序' },
  { prop: 'visible', label: '可见', tag: true }
]
</script>
