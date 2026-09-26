-- 制造运营系统数据库初始化脚本
CREATE DATABASE IF NOT EXISTS mes_db DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE mes_db;

-- 系统用户表
CREATE TABLE IF NOT EXISTS sys_user (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE COMMENT '用户名',
    password VARCHAR(100) NOT NULL COMMENT '密码',
    real_name VARCHAR(50) COMMENT '真实姓名',
    email VARCHAR(100) COMMENT '邮箱',
    phone VARCHAR(20) COMMENT '手机号',
    status INT DEFAULT 1 COMMENT '状态 1启用 0禁用',
    dept_id BIGINT COMMENT '部门ID',
    create_time DATETIME,
    update_time DATETIME,
    create_by VARCHAR(50),
    update_by VARCHAR(50),
    deleted INT DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 角色表
CREATE TABLE IF NOT EXISTS sys_role (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    role_name VARCHAR(50) NOT NULL COMMENT '角色名称',
    role_code VARCHAR(50) NOT NULL COMMENT '角色编码',
    description VARCHAR(200) COMMENT '描述',
    status INT DEFAULT 1,
    create_time DATETIME,
    update_time DATETIME,
    create_by VARCHAR(50),
    update_by VARCHAR(50),
    deleted INT DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 菜单表
CREATE TABLE IF NOT EXISTS sys_menu (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    parent_id BIGINT DEFAULT 0,
    name VARCHAR(50) NOT NULL,
    path VARCHAR(200),
    component VARCHAR(200),
    icon VARCHAR(50),
    type INT COMMENT '1目录 2菜单 3按钮',
    perm VARCHAR(100),
    sort INT DEFAULT 0,
    visible INT DEFAULT 1,
    create_time DATETIME,
    update_time DATETIME,
    create_by VARCHAR(50),
    update_by VARCHAR(50),
    deleted INT DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 用户角色关联表
CREATE TABLE IF NOT EXISTS sys_user_role (
    user_id BIGINT,
    role_id BIGINT,
    PRIMARY KEY (user_id, role_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 角色菜单关联表
CREATE TABLE IF NOT EXISTS sys_role_menu (
    role_id BIGINT,
    menu_id BIGINT,
    PRIMARY KEY (role_id, menu_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 初始化数据：默认管理员用户 (密码: admin123)
INSERT INTO sys_user (username, password, real_name, status, create_time, update_time) VALUES
('admin', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', '系统管理员', 1, NOW(), NOW())
ON DUPLICATE KEY UPDATE username = username;

INSERT INTO sys_role (role_name, role_code, description, status, create_time) VALUES
('超级管理员', 'ROLE_ADMIN', '系统超级管理员', 1, NOW())
ON DUPLICATE KEY UPDATE role_code = role_code;

INSERT INTO sys_user_role (user_id, role_id) VALUES (1, 1) ON DUPLICATE KEY UPDATE user_id = user_id;

-- 各业务模块表
CREATE TABLE IF NOT EXISTS biz_customer (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    customer_code VARCHAR(50), customer_name VARCHAR(100), contact VARCHAR(50),
    phone VARCHAR(20), email VARCHAR(100), address VARCHAR(300),
    credit_level VARCHAR(20), credit_limit DECIMAL(15,2), status INT DEFAULT 1, remark VARCHAR(500),
    create_time DATETIME, update_time DATETIME, create_by VARCHAR(50), update_by VARCHAR(50), deleted INT DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS biz_sales_order (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    order_no VARCHAR(50), customer_id BIGINT, customer_name VARCHAR(100),
    product_code VARCHAR(50), product_name VARCHAR(100), quantity DECIMAL(15,2),
    unit_price DECIMAL(15,2), total_amount DECIMAL(15,2),
    order_date DATE, delivery_date DATE, status VARCHAR(20), remark VARCHAR(500),
    create_time DATETIME, update_time DATETIME, create_by VARCHAR(50), update_by VARCHAR(50), deleted INT DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS biz_quote (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    quote_no VARCHAR(50), customer_id BIGINT, customer_name VARCHAR(100),
    product_code VARCHAR(50), product_name VARCHAR(100), quantity DECIMAL(15,2),
    unit_price DECIMAL(15,2), material_cost DECIMAL(15,2), labor_cost DECIMAL(15,2),
    expense_cost DECIMAL(15,2), total_price DECIMAL(15,2), status VARCHAR(20), remark VARCHAR(500),
    create_time DATETIME, update_time DATETIME, create_by VARCHAR(50), update_by VARCHAR(50), deleted INT DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS biz_sales_forecast (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    forecast_no VARCHAR(50), product_code VARCHAR(50), product_name VARCHAR(100),
    period VARCHAR(20), forecast_qty DECIMAL(15,2), actual_qty DECIMAL(15,2),
    status VARCHAR(20), remark VARCHAR(500),
    create_time DATETIME, update_time DATETIME, create_by VARCHAR(50), update_by VARCHAR(50), deleted INT DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS biz_material (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    material_code VARCHAR(50), material_name VARCHAR(100), specification VARCHAR(200),
    unit VARCHAR(20), category VARCHAR(50), unit_price DECIMAL(15,2),
    safety_stock DECIMAL(15,2), max_stock DECIMAL(15,2), shelf_life VARCHAR(50),
    status VARCHAR(20), remark VARCHAR(500),
    create_time DATETIME, update_time DATETIME, create_by VARCHAR(50), update_by VARCHAR(50), deleted INT DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS biz_inventory_stock (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    material_code VARCHAR(50), material_name VARCHAR(100), warehouse_code VARCHAR(50),
    location_code VARCHAR(50), batch_no VARCHAR(50), quantity DECIMAL(15,2),
    unit VARCHAR(20), status VARCHAR(20), remark VARCHAR(500),
    create_time DATETIME, update_time DATETIME, create_by VARCHAR(50), update_by VARCHAR(50), deleted INT DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS biz_warehouse (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    warehouse_code VARCHAR(50), warehouse_name VARCHAR(100), warehouse_type VARCHAR(50),
    address VARCHAR(300), manager VARCHAR(50), status VARCHAR(20), remark VARCHAR(500),
    create_time DATETIME, update_time DATETIME, create_by VARCHAR(50), update_by VARCHAR(50), deleted INT DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS biz_warehouse_location (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    warehouse_code VARCHAR(50), location_code VARCHAR(50), location_name VARCHAR(100),
    location_type VARCHAR(50), status VARCHAR(20), remark VARCHAR(500),
    create_time DATETIME, update_time DATETIME, create_by VARCHAR(50), update_by VARCHAR(50), deleted INT DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS biz_shipment (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    shipment_no VARCHAR(50), sales_order_no VARCHAR(50), customer_id BIGINT,
    customer_name VARCHAR(100), product_code VARCHAR(50), product_name VARCHAR(100),
    quantity DECIMAL(15,2), ship_date DATE, carrier VARCHAR(100), tracking_no VARCHAR(100),
    status VARCHAR(20), remark VARCHAR(500),
    create_time DATETIME, update_time DATETIME, create_by VARCHAR(50), update_by VARCHAR(50), deleted INT DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS biz_supplier (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    supplier_code VARCHAR(50), supplier_name VARCHAR(100), contact VARCHAR(50),
    phone VARCHAR(20), email VARCHAR(100), address VARCHAR(300),
    category VARCHAR(50), rating INT, status VARCHAR(20), remark VARCHAR(500),
    create_time DATETIME, update_time DATETIME, create_by VARCHAR(50), update_by VARCHAR(50), deleted INT DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS biz_purchase_order (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    order_no VARCHAR(50), supplier_id BIGINT, supplier_name VARCHAR(100),
    material_code VARCHAR(50), material_name VARCHAR(100), quantity DECIMAL(15,2),
    unit_price DECIMAL(15,2), total_amount DECIMAL(15,2),
    order_date DATE, delivery_date DATE, status VARCHAR(20), remark VARCHAR(500),
    create_time DATETIME, update_time DATETIME, create_by VARCHAR(50), update_by VARCHAR(50), deleted INT DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS biz_production_plan (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    plan_no VARCHAR(50), product_code VARCHAR(50), product_name VARCHAR(100),
    plan_qty DECIMAL(15,2), work_center VARCHAR(50), start_date DATE, end_date DATE,
    schedule_type VARCHAR(20), status VARCHAR(20), remark VARCHAR(500),
    create_time DATETIME, update_time DATETIME, create_by VARCHAR(50), update_by VARCHAR(50), deleted INT DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS biz_work_order (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    order_no VARCHAR(50), plan_no VARCHAR(50), product_code VARCHAR(50),
    product_name VARCHAR(100), plan_qty DECIMAL(15,2), completed_qty DECIMAL(15,2),
    work_center VARCHAR(50), plan_start DATE, plan_end DATE,
    priority VARCHAR(20), status VARCHAR(20), remark VARCHAR(500),
    create_time DATETIME, update_time DATETIME, create_by VARCHAR(50), update_by VARCHAR(50), deleted INT DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS biz_production_record (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    work_order_no VARCHAR(50), product_code VARCHAR(50), product_name VARCHAR(100),
    work_center VARCHAR(50), produced_qty DECIMAL(15,2), rejected_qty DECIMAL(15,2),
    start_time DATETIME, end_time DATETIME, operator VARCHAR(50),
    status VARCHAR(20), remark VARCHAR(500),
    create_time DATETIME, update_time DATETIME, create_by VARCHAR(50), update_by VARCHAR(50), deleted INT DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS biz_equipment_status (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    equipment_code VARCHAR(50), equipment_name VARCHAR(100), work_center VARCHAR(50),
    status VARCHAR(20), running_state VARCHAR(20), alarm_info VARCHAR(500), remark VARCHAR(500),
    create_time DATETIME, update_time DATETIME, create_by VARCHAR(50), update_by VARCHAR(50), deleted INT DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS biz_oee_record (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    equipment_code VARCHAR(50), equipment_name VARCHAR(100), record_date DATE,
    availability DECIMAL(5,2), performance DECIMAL(5,2), quality DECIMAL(5,2),
    oee DECIMAL(5,2), remark VARCHAR(500),
    create_time DATETIME, update_time DATETIME, create_by VARCHAR(50), update_by VARCHAR(50), deleted INT DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS biz_inspection (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    inspection_no VARCHAR(50), source_type VARCHAR(20), source_no VARCHAR(50),
    material_code VARCHAR(50), material_name VARCHAR(100), sample_qty DECIMAL(15,2),
    inspected_qty DECIMAL(15,2), passed_qty DECIMAL(15,2), failed_qty DECIMAL(15,2),
    inspector VARCHAR(50), result VARCHAR(20), status VARCHAR(20), remark VARCHAR(500),
    create_time DATETIME, update_time DATETIME, create_by VARCHAR(50), update_by VARCHAR(50), deleted INT DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS biz_defect (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    defect_no VARCHAR(50), inspection_no VARCHAR(50), material_code VARCHAR(50),
    defect_type VARCHAR(50), defect_desc VARCHAR(500), qty DECIMAL(15,2),
    severity VARCHAR(20), status VARCHAR(20), remark VARCHAR(500),
    create_time DATETIME, update_time DATETIME, create_by VARCHAR(50), update_by VARCHAR(50), deleted INT DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS biz_capa (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    capa_no VARCHAR(50), source_type VARCHAR(20), source_no VARCHAR(50),
    title VARCHAR(200), description VARCHAR(1000), root_cause VARCHAR(1000),
    corrective_action VARCHAR(1000), preventive_action VARCHAR(1000),
    responsible VARCHAR(50), due_date DATE, status VARCHAR(20), remark VARCHAR(500),
    create_time DATETIME, update_time DATETIME, create_by VARCHAR(50), update_by VARCHAR(50), deleted INT DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS biz_employee (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    emp_no VARCHAR(50), emp_name VARCHAR(50), gender VARCHAR(10),
    phone VARCHAR(20), email VARCHAR(100), department VARCHAR(50),
    position VARCHAR(50), shift VARCHAR(20), hire_date DATE, skills VARCHAR(500),
    status VARCHAR(20), remark VARCHAR(500),
    create_time DATETIME, update_time DATETIME, create_by VARCHAR(50), update_by VARCHAR(50), deleted INT DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS biz_attendance (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    emp_no VARCHAR(50), emp_name VARCHAR(50), attendance_date DATE,
    check_in TIME, check_out TIME, work_hours DECIMAL(5,2),
    overtime_hours DECIMAL(5,2), status VARCHAR(20), remark VARCHAR(500),
    create_time DATETIME, update_time DATETIME, create_by VARCHAR(50), update_by VARCHAR(50), deleted INT DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS biz_document (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    doc_no VARCHAR(50), doc_name VARCHAR(200), doc_type VARCHAR(50),
    category VARCHAR(50), version VARCHAR(20), status VARCHAR(20),
    file_url VARCHAR(500), owner VARCHAR(50), approver VARCHAR(50), remark VARCHAR(500),
    create_time DATETIME, update_time DATETIME, create_by VARCHAR(50), update_by VARCHAR(50), deleted INT DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS biz_equipment (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    equipment_code VARCHAR(50), equipment_name VARCHAR(100), equipment_type VARCHAR(50),
    work_center VARCHAR(50), manufacturer VARCHAR(100), model VARCHAR(100),
    purchase_date DATE, original_value DECIMAL(15,2), status VARCHAR(20), remark VARCHAR(500),
    create_time DATETIME, update_time DATETIME, create_by VARCHAR(50), update_by VARCHAR(50), deleted INT DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS biz_maintenance_record (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    maintenance_no VARCHAR(50), equipment_code VARCHAR(50), equipment_name VARCHAR(100),
    maintenance_type VARCHAR(50), description VARCHAR(1000), maintenance_date DATE,
    technician VARCHAR(50), cost DECIMAL(15,2), status VARCHAR(20), remark VARCHAR(500),
    create_time DATETIME, update_time DATETIME, create_by VARCHAR(50), update_by VARCHAR(50), deleted INT DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
