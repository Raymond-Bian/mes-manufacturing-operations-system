-- 初始数据
-- 默认管理员: admin / admin123 (bcrypt 加密)
INSERT INTO sys_user (username, password, real_name, status, create_time, update_time)
VALUES ('admin', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', '系统管理员', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO sys_role (role_name, role_code, description, status, create_time)
VALUES ('超级管理员', 'ROLE_ADMIN', '系统超级管理员', 1, CURRENT_TIMESTAMP);

INSERT INTO sys_user_role (user_id, role_id) VALUES (1, 1);

-- 示例客户
INSERT INTO biz_customer (customer_code, customer_name, contact, phone, email, address, credit_level, credit_limit, status, create_time)
VALUES ('C001', '上海精密机械有限公司', '张经理', '13800138001', 'zhang@shjm.com', '上海市浦东新区', 'A', 500000, 1, CURRENT_TIMESTAMP),
       ('C002', '深圳电子科技股份公司', '李总', '13900139002', 'li@szelect.com', '深圳市南山区', 'B', 300000, 1, CURRENT_TIMESTAMP),
       ('C003', '北京智能制造有限公司', '王主管', '13700137003', 'wang@bzim.com', '北京市海淀区', 'A', 800000, 1, CURRENT_TIMESTAMP);

-- 示例物料
INSERT INTO biz_material (material_code, material_name, specification, unit, category, unit_price, safety_stock, max_stock, status, create_time)
VALUES ('M001', '铝合金型材', '6063-T5', 'kg', '原材料', 25.50, 1000, 5000, '正常', CURRENT_TIMESTAMP),
       ('M002', '不锈钢板', '304 2mm', '张', '原材料', 180.00, 200, 1000, '正常', CURRENT_TIMESTAMP),
       ('M003', '电机', '220V 1.5KW', '台', '外购件', 350.00, 50, 200, '正常', CURRENT_TIMESTAMP),
       ('M004', '轴承', '6204-ZZ', '个', '外购件', 15.00, 500, 2000, '正常', CURRENT_TIMESTAMP);

-- 示例库存
INSERT INTO biz_inventory_stock (material_code, material_name, warehouse_code, location_code, batch_no, quantity, unit, status, create_time)
VALUES ('M001', '铝合金型材', 'WH01', 'A-01-01', 'B20240101', 2500, 'kg', '正常', CURRENT_TIMESTAMP),
       ('M002', '不锈钢板', 'WH01', 'A-02-01', 'B20240102', 350, '张', '正常', CURRENT_TIMESTAMP),
       ('M003', '电机', 'WH02', 'B-01-01', 'B20240103', 120, '台', '正常', CURRENT_TIMESTAMP),
       ('M004', '轴承', 'WH02', 'B-02-01', 'B20240104', 1800, '个', '正常', CURRENT_TIMESTAMP);

-- 示例仓库
INSERT INTO biz_warehouse (warehouse_code, warehouse_name, warehouse_type, address, manager, status, create_time)
VALUES ('WH01', '原材料仓', '原材料', '厂区A栋', '陈仓管', '正常', CURRENT_TIMESTAMP),
       ('WH02', '外购件仓', '外购件', '厂区B栋', '刘仓管', '正常', CURRENT_TIMESTAMP),
       ('WH03', '成品仓', '成品', '厂区C栋', '赵仓管', '正常', CURRENT_TIMESTAMP);

-- 示例供应商
INSERT INTO biz_supplier (supplier_code, supplier_name, contact, phone, email, category, rating, status, create_time)
VALUES ('S001', '宝钢集团', '赵经理', '13600136001', 'zhao@baosteel.com', '原材料', 95, '正常', CURRENT_TIMESTAMP),
       ('S002', '西门子中国', '钱经理', '13500135002', 'qian@siemens.com', '外购件', 92, '正常', CURRENT_TIMESTAMP),
       ('S003', 'SKF轴承', '孙经理', '13400134003', 'sun@skf.com', '外购件', 90, '正常', CURRENT_TIMESTAMP);

-- 示例员工
INSERT INTO biz_employee (emp_no, emp_name, gender, phone, department, position, shift, hire_date, status, create_time)
VALUES ('E001', '张三', '男', '13800138001', '生产部', '操作工', '白班', '2022-03-15', '在职', CURRENT_TIMESTAMP),
       ('E002', '李四', '女', '13800138002', '质量部', '质检员', '白班', '2021-08-20', '在职', CURRENT_TIMESTAMP),
       ('E003', '王五', '男', '13800138003', '工程部', '工程师', '白班', '2020-05-10', '在职', CURRENT_TIMESTAMP);

-- 示例设备
INSERT INTO biz_equipment (equipment_code, equipment_name, equipment_type, work_center, manufacturer, model, purchase_date, original_value, status, create_time)
VALUES ('EQ001', 'CNC加工中心', '加工设备', 'WC-A1', 'DMG MORI', 'NLX 2500', '2022-06-01', 850000, '运行中', CURRENT_TIMESTAMP),
       ('EQ002', '激光切割机', '加工设备', 'WC-A2', 'Trumpf', 'TruLaser 3030', '2021-09-15', 680000, '运行中', CURRENT_TIMESTAMP),
       ('EQ003', '装配流水线', '装配线', 'WC-B1', '定制', 'APL-01', '2020-04-20', 320000, '运行中', CURRENT_TIMESTAMP);

-- 示例OEE记录
INSERT INTO biz_oee_record (equipment_code, equipment_name, record_date, availability, performance, quality, oee, create_time)
VALUES ('EQ001', 'CNC加工中心', '2024-09-25', 92.5, 88.3, 98.5, 80.2, CURRENT_TIMESTAMP),
       ('EQ002', '激光切割机', '2024-09-25', 90.0, 85.5, 99.0, 76.1, CURRENT_TIMESTAMP),
       ('EQ003', '装配流水线', '2024-09-25', 95.0, 92.0, 98.8, 86.3, CURRENT_TIMESTAMP);
