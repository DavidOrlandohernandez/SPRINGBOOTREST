
INSERT INTO almacenes(id, name, address) VALUES(1, 'Centro 1','Calle 1');
--INSERT INTO almacenes(id, name, address) VALUES(2, 'Centro 2','Calle 2');
--INSERT INTO almacenes(id, name, address) VALUES(3, 'Centro 3','Calle 3');

INSERT INTO sucursales(id, name, colonia, estado, numero_domicilio) VALUES(1, 'Uno','uno',1, '1');
INSERT INTO sucursales(id, name, colonia, estado, numero_domicilio) VALUES(2, 'Dos','dos',2, '2');
INSERT INTO sucursales(id, name, colonia, estado, numero_domicilio) VALUES(3, 'Tres','tres',3, '3');

INSERT INTO sucursales_almacenes (sucursales_id,almacenes_id) VALUES(1,1);
--INSERT INTO sucursales_almacenes (sucursales_id,almacenes_id) VALUES(1,2);
--INSERT INTO sucursales_almacenes (sucursales_id,almacenes_id) VALUES(1,3);