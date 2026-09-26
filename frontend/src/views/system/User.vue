<template>
  <CrudTable title="用户管理" api-path="/system/user" :columns="columns" />
</template>

<script setup lang="ts">
import CrudTable from '@/components/CrudTable.vue'
const columns = [
  { prop: 'username', label: '用户名' },
  { prop: 'realName', label: '真实姓名' },
  { prop: 'email', label: '邮箱' },
  { prop: 'phone', label: '手机号' },
  { prop: 'status', label: '状态', tag: true }
]
</script>
