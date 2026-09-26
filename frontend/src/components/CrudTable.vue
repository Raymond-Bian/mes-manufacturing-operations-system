<template>
  <div class="page-container">
    <div class="page-header">
      <div class="page-title">{{ title }}</div>
      <el-button type="primary" :icon="Plus" @click="handleAdd">新增</el-button>
    </div>

    <div class="search-bar">
      <el-input v-model="keyword" placeholder="搜索关键词" clearable style="width: 240px" @keyup.enter="loadData" />
      <el-button type="primary" :icon="Search" @click="loadData">查询</el-button>
    </div>

    <el-table :data="tableData" border stripe v-loading="loading" style="width: 100%">
      <el-table-column type="index" label="序号" width="60" align="center" />
      <el-table-column v-for="col in columns" :key="col.prop" :prop="col.prop" :label="col.label" :width="col.width" min-width="120">
        <template #default="{ row }">
          <el-tag v-if="col.tag" :type="getTagType(row[col.prop])" size="small">{{ row[col.prop] }}</el-tag>
          <span v-else>{{ row[col.prop] }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" width="180" fixed="right" align="center">
        <template #default="{ row }">
          <el-button size="small" type="primary" link @click="handleEdit(row)">编辑</el-button>
          <el-button size="small" type="danger" link @click="handleDelete(row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <el-pagination
      style="margin-top: 16px; justify-content: flex-end"
      v-model:current-page="current"
      v-model:page-size="size"
      :page-sizes="[10, 20, 50]"
      :total="total"
      layout="total, sizes, prev, pager, next, jumper"
      @size-change="loadData"
      @current-change="loadData"
    />

    <el-dialog v-model="dialogVisible" :title="isEdit ? '编辑' : '新增'" width="600px" destroy-on-close>
      <el-form :model="form" label-width="100px">
        <el-form-item v-for="col in columns" :key="col.prop" :label="col.label">
          <el-input v-model="form[col.prop]" :placeholder="col.label" />
        </el-form-item>
      </el-form>
      <template #footer>
        <el-button @click="dialogVisible = false">取消</el-button>
        <el-button type="primary" @click="handleSave">确定</el-button>
      </template>
    </el-dialog>
  </div>
</template>

<script setup lang="ts">
import { ref, onMounted } from 'vue'
import { Plus, Search } from '@element-plus/icons-vue'
import { page, save, update, remove } from '@/api'
import { ElMessage, ElMessageBox } from 'element-plus'

const props = defineProps<{
  title: string
  apiPath: string
  columns: { prop: string; label: string; width?: number; tag?: boolean }[]
}>()

const tableData = ref<any[]>([])
const total = ref(0)
const current = ref(1)
const size = ref(10)
const keyword = ref('')
const loading = ref(false)
const dialogVisible = ref(false)
const isEdit = ref(false)
const form = ref<any>({})

async function loadData() {
  loading.value = true
  try {
    const res: any = await page(props.apiPath, current.value, size.value, keyword.value ? { keyword: keyword.value } : {})
    tableData.value = res.data.records
    total.value = res.data.total
  } finally {
    loading.value = false
  }
}

function handleAdd() {
  isEdit.value = false
  form.value = {}
  dialogVisible.value = true
}

function handleEdit(row: any) {
  isEdit.value = true
  form.value = { ...row }
  dialogVisible.value = true
}

async function handleSave() {
  try {
    if (isEdit.value) {
      await update(props.apiPath, form.value)
      ElMessage.success('更新成功')
    } else {
      await save(props.apiPath, form.value)
      ElMessage.success('新增成功')
    }
    dialogVisible.value = false
    loadData()
  } catch (e) {
    // handled by interceptor
  }
}

function handleDelete(row: any) {
  ElMessageBox.confirm('确定要删除这条记录吗？', '提示', { type: 'warning' }).then(async () => {
    await remove(props.apiPath, row.id)
    ElMessage.success('删除成功')
    loadData()
  }).catch(() => {})
}

function getTagType(val: string) {
  const map: Record<string, string> = {
    '启用': 'success', '禁用': 'danger', '正常': 'success', '异常': 'danger',
    '已完成': 'success', '进行中': 'primary', '待处理': 'warning', '已取消': 'danger',
    '运行中': 'success', '停机': 'danger', '待机': 'warning'
  }
  return map[val] || 'info'
}

onMounted(loadData)
</script>