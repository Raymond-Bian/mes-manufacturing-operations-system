<template>
  <CrudTable title="考勤管理" api-path="/hr/attendance" :columns="columns" />
</template>

<script setup lang="ts">
import CrudTable from '@/components/CrudTable.vue'
const columns = [
  { prop: 'empNo', label: '工号' },
  { prop: 'empName', label: '姓名' },
  { prop: 'attendanceDate', label: '日期' },
  { prop: 'checkIn', label: '签到' },
  { prop: 'checkOut', label: '签退' },
  { prop: 'workHours', label: '工时' },
  { prop: 'overtimeHours', label: '加班' },
  { prop: 'status', label: '状态', tag: true }
]
</script>
