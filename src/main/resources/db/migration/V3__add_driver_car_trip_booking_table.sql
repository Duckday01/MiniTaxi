
-- Insert Sample Permissions
INSERT INTO permissions(name) VALUES 
('user:read'), ('user:update'), ('user:create'), ('user:delete');

-- Assign permissions to ADMIN role (Assuming ADMIN has id 1)
-- ADMIN has all permissions
INSERT INTO role_permissions(role_id, permission_id)
SELECT (SELECT id FROM roles WHERE name = 'ADMIN'), id FROM permissions;

-- CUSTOMER might only have read permission (Example)
INSERT INTO role_permissions(role_id, permission_id)
VALUES ((SELECT id FROM roles WHERE name = 'CUSTOMER'), (SELECT id FROM permissions WHERE name = 'user:read'));

-- Create Cars table
CREATE TABLE cars (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  created_on DATETIME,
  modified_on DATETIME,
  bks VARCHAR(50),
  color VARCHAR(50),
  type VARCHAR(50),
  type_of_car VARCHAR(50),
  registration_certificate_front VARCHAR(255),
  registration_certificate_behind VARCHAR(255),
  album_registration_certificate VARCHAR(255),
  album_insurance VARCHAR(255),
  note TEXT,
  car_year INT,
  car_type VARCHAR(50),
  license_type VARCHAR(50)
);

-- Create Drivers table
CREATE TABLE drivers (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  created_on DATETIME,
  modified_on DATETIME,
  display_name VARCHAR(100),
  password VARCHAR(255),
  username VARCHAR(50),
  car_id BIGINT,
  money DECIMAL(19, 2),
  driver_ban BOOLEAN,
  bks VARCHAR(50),
  enabled BOOLEAN,
  driver_rank VARCHAR(50),
  role VARCHAR(50),
  certificate_type VARCHAR(50),
  activity_area VARCHAR(100),
  referral_code VARCHAR(50),
  point DOUBLE,
  reason TEXT,
  english VARCHAR(50),
  avatar VARCHAR(255),
  status VARCHAR(50),
  parent_id BIGINT,
  is_sub_driver BOOLEAN,
  driver_license_front VARCHAR(255),
  driver_license_behind VARCHAR(255),
  allow_notification BOOLEAN,
  FOREIGN KEY (car_id) REFERENCES cars(id),
  FOREIGN KEY (parent_id) REFERENCES drivers(id)
);

-- Create Bookings table
CREATE TABLE bookings (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  agency_id BIGINT,
  pickup_address VARCHAR(255),
  destination_address VARCHAR(255),
  round_trip BOOLEAN,
  is_have_bill BOOLEAN,
  customer_name VARCHAR(100),
  customer_phone VARCHAR(50),
  pickup_time DATETIME,
  type_of_car VARCHAR(50),
  note TEXT,
  status VARCHAR(50),
  created_on DATETIME,
  modified_on DATETIME,
  type_reject VARCHAR(50),
  type VARCHAR(50),
  price_customer DECIMAL(19, 2),
  price_bid DECIMAL(19, 2),
  is_collect_money BOOLEAN,
  area VARCHAR(100),
  customer_property VARCHAR(100),
  service VARCHAR(100),
  is_toll_fee BOOLEAN,
  bonus DECIMAL(19, 2)
);

-- Create Trips table
-- (Note: Structure is very similar to bookings, ensure this is intended)
CREATE TABLE trips (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  created_on DATETIME,
  modified_on DATETIME,
  customer_name VARCHAR(100),
  customer_phone VARCHAR(50),
  description TEXT,
  pickup_time DATETIME,
  price_bid DECIMAL(19, 2),
  money_customer_deposit DECIMAL(19, 2),
  money_debt_agency DECIMAL(19, 2),
  price_customer DECIMAL(19, 2),
  status VARCHAR(50),
  pickup_address VARCHAR(255),
  destination_address VARCHAR(255),
  round_trip BOOLEAN,
  area VARCHAR(100),
  display BOOLEAN,
  type_of_car VARCHAR(50),
  is_have_bill BOOLEAN,
  is_collect_money BOOLEAN,
  is_auto_price BOOLEAN,
  no_auto_price BOOLEAN,
  flag_driver BOOLEAN,
  collected_money DECIMAL(19, 2),
  sell_start_time DATETIME,
  source_trip VARCHAR(50),
  agency_id BIGINT,
  customer_property VARCHAR(100),
  price_vat DECIMAL(19, 2),
  service VARCHAR(100),
  is_toll_fee BOOLEAN,
  bonus DECIMAL(19, 2),
  note TEXT
);
