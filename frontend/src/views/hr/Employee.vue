<template>
  <CrudTable title="员工管理" api-path="/hr/employee" :columns="columns" />
</template>

<script setup lang="ts">
import CrudTable from '@/components/CrudTable.vue'
const columns = [
  { prop: 'empNo', label: '工号' },
  { prop: 'empName', label: '姓名' },
  { prop: 'gender', label: '性别' },
  { prop: 'phone', label: '电话' },
  { prop: 'department', label: '部门' },
  { prop: 'position', label: '职位' },
  { prop: 'shift', label: '班次' },
  { prop: 'status', label: '状态', tag: true }
]
</script>
