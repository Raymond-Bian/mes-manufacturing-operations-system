<template>
  <el-container style="height: 100vh">
    <el-aside :width="isCollapse ? '64px' : '220px'" style="background: #001529; transition: width 0.3s">
      <div style="height: 60px; display: flex; align-items: center; justify-content: center; color: #fff; font-size: 18px; font-weight: 600; border-bottom: 1px solid #1f2d3d">
        <el-icon size="24" color="#409eff"><Cpu /></el-icon>
        <span v-show="!isCollapse" style="margin-left: 8px">制造运营系统</span>
      </div>
      <el-menu
        :default-active="activeMenu"
        :collapse="isCollapse"
        background-color="#001529"
        text-color="#b7bdc6"
        active-text-color="#409eff"
        router
      >
        <el-menu-item index="/dashboard"><el-icon><DataBoard /></el-icon><span>运营总览</span></el-menu-item>

        <el-sub-menu index="analysis">
          <template #title><el-icon><TrendCharts /></el-icon><span>业务分析</span></template>
          <el-menu-item index="/analysis/sales-opportunity">销售机会分析</el-menu-item>
          <el-menu-item index="/analysis/sales-order">销售订单分析</el-menu-item>
          <el-menu-item index="/analysis/production">生产分析</el-menu-item>
          <el-menu-item index="/analysis/quality">质量分析</el-menu-item>
          <el-menu-item index="/analysis/supplier">供应商分析</el-menu-item>
          <el-menu-item index="/analysis/equipment">设备维护分析</el-menu-item>
          <el-menu-item index="/analysis/inventory">库存分析</el-menu-item>
          <el-menu-item index="/analysis/finance">财务分析</el-menu-item>
          <el-menu-item index="/analysis/hr">人力分析</el-menu-item>
        </el-sub-menu>

        <el-sub-menu index="sales">
          <template #title><el-icon><ShoppingCart /></el-icon><span>销售管理</span></template>
          <el-menu-item index="/sales/customer">客户管理</el-menu-item>
          <el-menu-item index="/sales/order">销售订单</el-menu-item>
          <el-menu-item index="/sales/quote">报价管理</el-menu-item>
          <el-menu-item index="/sales/forecast">销售预测</el-menu-item>
        </el-sub-menu>

        <el-sub-menu index="inventory">
          <template #title><el-icon><Box /></el-icon><span>库存管理</span></template>
          <el-menu-item index="/inventory/material">物料主数据</el-menu-item>
          <el-menu-item index="/inventory/stock">库存查询</el-menu-item>
        </el-sub-menu>

        <el-sub-menu index="warehouse">
          <template #title><el-icon><OfficeBuilding /></el-icon><span>仓库管理</span></template>
          <el-menu-item index="/warehouse/info">仓库管理</el-menu-item>
          <el-menu-item index="/warehouse/location">库位管理</el-menu-item>
        </el-sub-menu>

        <el-menu-item index="/shipping/order"><el-icon><Van /></el-icon><span>发运管理</span></el-menu-item>

        <el-sub-menu index="purchase">
          <template #title><el-icon><Shop /></el-icon><span>采购管理</span></template>
          <el-menu-item index="/purchase/supplier">供应商管理</el-menu-item>
          <el-menu-item index="/purchase/order">采购订单</el-menu-item>
        </el-sub-menu>

        <el-sub-menu index="planning">
          <template #title><el-icon><Calendar /></el-icon><span>计划排程</span></template>
          <el-menu-item index="/planning/plan">生产计划</el-menu-item>
          <el-menu-item index="/planning/workorder">工单管理</el-menu-item>
        </el-sub-menu>

        <el-sub-menu index="manufacturing">
          <template #title><el-icon><Cpu /></el-icon><span>制造执行</span></template>
          <el-menu-item index="/manufacturing/record">生产报工</el-menu-item>
          <el-menu-item index="/manufacturing/equipment">设备状态</el-menu-item>
          <el-menu-item index="/manufacturing/oee">OEE分析</el-menu-item>
        </el-sub-menu>

        <el-sub-menu index="quality">
          <template #title><el-icon><CircleCheck /></el-icon><span>质量管控</span></template>
          <el-menu-item index="/quality/inspection">检验管理</el-menu-item>
          <el-menu-item index="/quality/defect">缺陷管理</el-menu-item>
          <el-menu-item index="/quality/capa">CAPA管理</el-menu-item>
        </el-sub-menu>

        <el-sub-menu index="hr">
          <template #title><el-icon><User /></el-icon><span>人力分析</span></template>
          <el-menu-item index="/hr/employee">员工管理</el-menu-item>
          <el-menu-item index="/hr/attendance">考勤管理</el-menu-item>
        </el-sub-menu>

        <el-menu-item index="/document/info"><el-icon><Folder /></el-icon><span>文控体系</span></el-menu-item>

        <el-sub-menu index="asset">
          <template #title><el-icon><Tools /></el-icon><span>资产管理</span></template>
          <el-menu-item index="/asset/equipment">设备资产</el-menu-item>
          <el-menu-item index="/asset/maintenance">维护记录</el-menu-item>
        </el-sub-menu>

        <el-sub-menu index="system">
          <template #title><el-icon><Setting /></el-icon><span>系统管理</span></template>
          <el-menu-item index="/system/user">用户管理</el-menu-item>
          <el-menu-item index="/system/role">角色管理</el-menu-item>
          <el-menu-item index="/system/menu">菜单管理</el-menu-item>
        </el-sub-menu>
      </el-menu>
    </el-aside>

    <el-container>
      <el-header style="background: #fff; display: flex; align-items: center; justify-content: space-between; box-shadow: 0 1px 4px rgba(0,0,0,0.08)">
        <div style="display: flex; align-items: center; gap: 16px">
          <el-icon style="cursor: pointer; font-size: 20px" @click="isCollapse = !isCollapse"><Fold v-if="!isCollapse" /><Expand v-else /></el-icon>
          <el-breadcrumb separator="/">
            <el-breadcrumb-item :to="{ path: '/dashboard' }">首页</el-breadcrumb-item>
            <el-breadcrumb-item>{{ currentTitle }}</el-breadcrumb-item>
          </el-breadcrumb>
        </div>
        <el-dropdown @command="handleCommand">
          <span style="display: flex; align-items: center; gap: 8px; cursor: pointer">
            <el-avatar :size="32" style="background: #409eff">{{ userInfo?.realName?.charAt(0) || 'A' }}</el-avatar>
            <span>{{ userInfo?.realName || userInfo?.username || '管理员' }}</span>
            <el-icon><ArrowDown /></el-icon>
          </span>
          <template #dropdown>
            <el-dropdown-menu>
              <el-dropdown-item command="profile">个人中心</el-dropdown-item>
              <el-dropdown-item command="logout" divided>退出登录</el-dropdown-item>
            </el-dropdown-menu>
          </template>
        </el-dropdown>
      </el-header>
      <el-main style="background: #f0f2f5; overflow: auto">
        <router-view v-slot="{ Component }">
          <transition name="fade" mode="out-in">
            <component :is="Component" />
          </transition>
        </router-view>
      </el-main>
    </el-container>
  </el-container>
</template>

<script setup lang="ts">
import { ref, computed } from 'vue'
import { useRoute, useRouter } from 'vue-router'
import { useUserStore } from '@/store/user'
import { ElMessageBox } from 'element-plus'

const route = useRoute()
const router = useRouter()
const userStore = useUserStore()
const isCollapse = ref(false)

const activeMenu = computed(() => route.path)
const currentTitle = computed(() => (route.meta.title as string) || '')
const userInfo = computed(() => userStore.userInfo)

function handleCommand(cmd: string) {
  if (cmd === 'logout') {
    ElMessageBox.confirm('确定要退出登录吗？', '提示', { type: 'warning' }).then(() => {
      userStore.logout()
      router.push('/login')
    }).catch(() => {})
  }
}
</script>

<style scoped>
.fade-enter-active, .fade-leave-active {
  transition: opacity 0.2s;
}
.fade-enter-from, .fade-leave-to {
  opacity: 0;
}
</style>
