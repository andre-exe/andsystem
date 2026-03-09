---------------------------------
-- ROLES
---------------------------------
INSERT INTO roles (nombre) VALUES ('ROLE_ADMIN') ON CONFLICT (nombre) DO NOTHING;
INSERT INTO roles (nombre) VALUES ('ROLE_VENDEDOR') ON CONFLICT (nombre) DO NOTHING;
INSERT INTO roles (nombre) VALUES ('ROLE_BODEGA') ON CONFLICT (nombre) DO NOTHING;
INSERT INTO roles (nombre) VALUES ('ROLE_CONTABILIDAD') ON CONFLICT (nombre) DO NOTHING;

---------------------------------
-- USUARIOS
---------------------------------
INSERT INTO usuarios (username, password, email, estado) VALUES

('vendedor','$2a$10$7QJY0X7LJk9l3PqE0lXbN.xdZ2Z0lC2W1u0Jf8yQk3X1o1Kp3R5zK','ventas@inventario.com',true),
('bodega','$2a$10$7QJY0X7LJk9l3PqE0lXbN.xdZ2Z0lC2W1u0Jf8yQk3X1o1Kp3R5zK','bodega@inventario.com',true),
('conta','$2a$10$7QJY0X7LJk9l3PqE0lXbN.xdZ2Z0lC2W1u0Jf8yQk3X1o1Kp3R5zK','conta@inventario.com',true)
ON CONFLICT (username) DO NOTHING;

---------------------------------
-- CATEGORIAS
---------------------------------
INSERT INTO categorias (nombre, descripcion) VALUES
('Laptops','Computadoras portatiles'),
('Monitores','Pantallas para computadora'),
('Teclados','Teclados mecanicos y estandar'),
('Mouse','Dispositivos apuntadores'),
('Accesorios','Accesorios de computacion')
ON CONFLICT (nombre) DO NOTHING;

---------------------------------
-- PROVEEDORES
---------------------------------
INSERT INTO proveedores (nombre,telefono,email,direccion,estado) VALUES
('TechSupplier','2222-1111','ventas@techsupplier.com','San Salvador',true),
('CompuGlobal','2222-2222','contacto@compuglobal.com','Santa Tecla',true),
('DigitalWorld','2222-3333','info@digitalworld.com','San Miguel',true)
ON CONFLICT (nombre) DO NOTHING;