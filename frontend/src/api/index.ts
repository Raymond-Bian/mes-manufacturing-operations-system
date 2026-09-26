import request from './request'

export function page(baseUrl: string, current = 1, size = 10, params?: any) {
  return request.get(`${baseUrl}/page`, { params: { current, size, ...params } })
}

export function list(baseUrl: string) {
  return request.get(`${baseUrl}/list`)
}

export function getById(baseUrl: string, id: number) {
  return request.get(`${baseUrl}/${id}`)
}

export function save(baseUrl: string, data: any) {
  return request.post(baseUrl, data)
}

export function update(baseUrl: string, data: any) {
  return request.put(baseUrl, data)
}

export function remove(baseUrl: string, id: number) {
  return request.delete(`${baseUrl}/${id}`)
}

// 各模块基础路径
export const API = {
  customer: '/sales/customer',
  salesOrder: '/sales/order',
  quote: '/sales/quote',
  forecast: '/sales/forecast',
  material: '/inventory/material',
  stock: '/inventory/stock',
  warehouse: '/warehouse/info',
  location: '/warehouse/location',
  shipment: '/shipping/order',
  supplier: '/purchase/supplier',
  purchaseOrder: '/purchase/order',
  plan: '/planning/plan',
  workOrder: '/planning/workorder',
  productionRecord: '/manufacturing/record',
  equipmentStatus: '/manufacturing/equipment',
  oee: '/manufacturing/oee',
  inspection: '/quality/inspection',
  defect: '/quality/defect',
  capa: '/quality/capa',
  employee: '/hr/employee',
  attendance: '/hr/attendance',
  document: '/document/info',
  equipment: '/asset/equipment',
  maintenance: '/asset/maintenance',
  user: '/system/user',
  role: '/system/role',
  menu: '/system/menu'
}

// 分析接口
export const AnalysisApi = {
  overview: () => request.get('/analysis/overview'),
  salesOpportunity: () => request.get('/analysis/sales-opportunity'),
  salesOrder: () => request.get('/analysis/sales-order'),
  production: () => request.get('/analysis/production'),
  quality: () => request.get('/analysis/quality'),
  supplier: () => request.get('/analysis/supplier'),
  equipment: () => request.get('/analysis/equipment'),
  inventory: () => request.get('/analysis/inventory'),
  finance: () => request.get('/analysis/finance'),
  hr: () => request.get('/analysis/hr')
}
