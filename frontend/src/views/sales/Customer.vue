<template>
  <CrudTable title="客户管理" api-path="/sales/customer" :columns="columns" />
</template>

<script setup lang="ts">
import CrudTable from '@/components/CrudTable.vue'
const columns = [
  { prop: 'customerCode', label: '客户编码' },
  { prop: 'customerName', label: '客户名称' },
  { prop: 'contact', label: '联系人' },
  { prop: 'phone', label: '电话' },
  { prop: 'creditLevel', label: '信用等级', tag: true },
  { prop: 'status', label: '状态', tag: true }
]
</script>
