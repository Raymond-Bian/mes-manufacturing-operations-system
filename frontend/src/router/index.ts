import { createRouter, createWebHistory } from 'vue-router'
import { useUserStore } from '@/store/user'

const routes = [
  { path: '/login', name: 'Login', component: () => import('@/views/Login.vue'), meta: { public: true } },
  {
    path: '/',
    component: () => import('@/layout/Layout.vue'),
    redirect: '/dashboard',
    children: [
      { path: 'dashboard', name: 'Dashboard', component: () => import('@/views/Dashboard.vue'), meta: { title: '运营总览', icon: 'DataBoard' } },
      { path: 'analysis/sales-opportunity', name: 'SalesOpportunity', component: () => import('@/views/analysis/SalesOpportunity.vue'), meta: { title: '销售机会分析', icon: 'TrendCharts' } },
      { path: 'analysis/sales-order', name: 'SalesOrderAnalysis', component: () => import('@/views/analysis/SalesOrderAnalysis.vue'), meta: { title: '销售订单分析', icon: 'Document' } },
      { path: 'analysis/production', name: 'ProductionAnalysis', component: () => import('@/views/analysis/ProductionAnalysis.vue'), meta: { title: '生产分析', icon: 'Cpu' } },
      { path: 'analysis/quality', name: 'QualityAnalysis', component: () => import('@/views/analysis/QualityAnalysis.vue'), meta: { title: '质量分析', icon: 'CircleCheck' } },
      { path: 'analysis/supplier', name: 'SupplierAnalysis', component: () => import('@/views/analysis/SupplierAnalysis.vue'), meta: { title: '供应商分析', icon: 'Van' } },
      { path: 'analysis/equipment', name: 'EquipmentAnalysis', component: () => import('@/views/analysis/EquipmentAnalysis.vue'), meta: { title: '设备维护分析', icon: 'Tools' } },
      { path: 'analysis/inventory', name: 'InventoryAnalysis', component: () => import('@/views/analysis/InventoryAnalysis.vue'), meta: { title: '库存分析', icon: 'Box' } },
      { path: 'analysis/finance', name: 'FinanceAnalysis', component: () => import('@/views/analysis/FinanceAnalysis.vue'), meta: { title: '财务分析', icon: 'Money' } },
      { path: 'analysis/hr', name: 'HrAnalysis', component: () => import('@/views/analysis/HrAnalysis.vue'), meta: { title: '人力分析', icon: 'User' } },
      // 销售管理
      { path: 'sales/customer', name: 'Customer', component: () => import('@/views/sales/Customer.vue'), meta: { title: '客户管理', icon: 'UserFilled' } },
      { path: 'sales/order', name: 'SalesOrder', component: () => import('@/views/sales/SalesOrder.vue'), meta: { title: '销售订单', icon: 'List' } },
      { path: 'sales/quote', name: 'Quote', component: () => import('@/views/sales/Quote.vue'), meta: { title: '报价管理', icon: 'Money' } },
      { path: 'sales/forecast', name: 'Forecast', component: () => import('@/views/sales/Forecast.vue'), meta: { title: '销售预测', icon: 'TrendCharts' } },
      // 库存管理
      { path: 'inventory/material', name: 'Material', component: () => import('@/views/inventory/Material.vue'), meta: { title: '物料主数据', icon: 'Goods' } },
      { path: 'inventory/stock', name: 'Stock', component: () => import('@/views/inventory/Stock.vue'), meta: { title: '库存查询', icon: 'Box' } },
      // 仓库管理
      { path: 'warehouse/info', name: 'Warehouse', component: () => import('@/views/warehouse/Warehouse.vue'), meta: { title: '仓库管理', icon: 'OfficeBuilding' } },
      { path: 'warehouse/location', name: 'Location', component: () => import('@/views/warehouse/Location.vue'), meta: { title: '库位管理', icon: 'Grid' } },
      // 发运管理
      { path: 'shipping/order', name: 'Shipment', component: () => import('@/views/shipping/Shipment.vue'), meta: { title: '发运管理', icon: 'Van' } },
      // 采购管理
      { path: 'purchase/supplier', name: 'Supplier', component: () => import('@/views/purchase/Supplier.vue'), meta: { title: '供应商管理', icon: 'Shop' } },
      { path: 'purchase/order', name: 'PurchaseOrder', component: () => import('@/views/purchase/PurchaseOrder.vue'), meta: { title: '采购订单', icon: 'ShoppingCart' } },
      // 计划排程
      { path: 'planning/plan', name: 'Plan', component: () => import('@/views/planning/Plan.vue'), meta: { title: '生产计划', icon: 'Calendar' } },
      { path: 'planning/workorder', name: 'WorkOrder', component: () => import('@/views/planning/WorkOrder.vue'), meta: { title: '工单管理', icon: 'Tickets' } },
      // 制造执行
      { path: 'manufacturing/record', name: 'ProductionRecord', component: () => import('@/views/manufacturing/Record.vue'), meta: { title: '生产报工', icon: 'EditPen' } },
      { path: 'manufacturing/equipment', name: 'EquipmentStatus', component: () => import('@/views/manufacturing/EquipmentStatus.vue'), meta: { title: '设备状态', icon: 'Monitor' } },
      { path: 'manufacturing/oee', name: 'Oee', component: () => import('@/views/manufacturing/Oee.vue'), meta: { title: 'OEE分析', icon: 'DataLine' } },
      // 质量管控
      { path: 'quality/inspection', name: 'Inspection', component: () => import('@/views/quality/Inspection.vue'), meta: { title: '检验管理', icon: 'CircleCheck' } },
      { path: 'quality/defect', name: 'Defect', component: () => import('@/views/quality/Defect.vue'), meta: { title: '缺陷管理', icon: 'Warning' } },
      { path: 'quality/capa', name: 'Capa', component: () => import('@/views/quality/Capa.vue'), meta: { title: 'CAPA管理', icon: 'RefreshRight' } },
      // 人力分析
      { path: 'hr/employee', name: 'Employee', component: () => import('@/views/hr/Employee.vue'), meta: { title: '员工管理', icon: 'User' } },
      { path: 'hr/attendance', name: 'Attendance', component: () => import('@/views/hr/Attendance.vue'), meta: { title: '考勤管理', icon: 'Clock' } },
      // 文控体系
      { path: 'document/info', name: 'Document', component: () => import('@/views/document/Document.vue'), meta: { title: '文档管理', icon: 'Folder' } },
      // 资产管理
      { path: 'asset/equipment', name: 'AssetEquipment', component: () => import('@/views/asset/Equipment.vue'), meta: { title: '设备资产', icon: 'Cpu' } },
      { path: 'asset/maintenance', name: 'Maintenance', component: () => import('@/views/asset/Maintenance.vue'), meta: { title: '维护记录', icon: 'Tools' } },
      // 系统管理
      { path: 'system/user', name: 'SysUser', component: () => import('@/views/system/User.vue'), meta: { title: '用户管理', icon: 'User' } },
      { path: 'system/role', name: 'SysRole', component: () => import('@/views/system/Role.vue'), meta: { title: '角色管理', icon: 'Avatar' } },
      { path: 'system/menu', name: 'SysMenu', component: () => import('@/views/system/Menu.vue'), meta: { title: '菜单管理', icon: 'Menu' } }
    ]
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

router.beforeEach((to, from, next) => {
  const userStore = useUserStore()
  if (to.meta.public) {
    next()
  } else if (!userStore.token) {
    next('/login')
  } else {
    next()
  }
})

export default router
