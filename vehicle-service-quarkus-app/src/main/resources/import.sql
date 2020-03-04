INSERT INTO vehicle(id, manufacturer, model, vin) values (1, 'Skoda', 'Fabia', 's8438957328923879238');
INSERT INTO vehicle(id, manufacturer, model, vin) values (2, 'Toyota', 'Rav4', 'fhwiyocyt8ty9348yx98');
INSERT INTO vehicle(id, manufacturer, model, vin) values (3, 'Dacia', 'Dokker', 'dskjfhty3498ctyh9w8y');
INSERT INTO vehicle(id, manufacturer, model, vin) values (4, 'Opel', 'Corsa', 'sdjfh4nty4398ry98y4x');
INSERT INTO vehicle(id, manufacturer, model, vin) values (5, 'Volkswagen', 'Golf', 'i4ty34x8xtyiwujytiwe');

INSERT INTO ecu(id, manufacturer, model, vehicle_id) values (1, 'Bosch', 'rx-88A', 2);
INSERT INTO ecu(id, manufacturer, model, vehicle_id) values (2, 'Bosch', 'rx-88A', 3);
INSERT INTO ecu(id, manufacturer, model, vehicle_id) values (3, 'Bosch', 'MD-001', 5);
INSERT INTO ecu(id, manufacturer, model, vehicle_id) values (4, 'Autel', 'CC100', 1);
INSERT INTO ecu(id, manufacturer, model, vehicle_id) values (5, 'Autel', 'CC100', 4);
INSERT INTO ecu(id, manufacturer, model, vehicle_id) values (6, 'Autel', 'GG-200', 5);
INSERT INTO ecu(id, manufacturer, model, vehicle_id) values (7, 'Sony', 'SN4WRX', 1);
INSERT INTO ecu(id, manufacturer, model, vehicle_id) values (8, 'Sony', 'SN4WRX', 3);
INSERT INTO ecu(id, manufacturer, model, vehicle_id) values (9, 'Kess', 'HH-400', 4);
INSERT INTO ecu(id, manufacturer, model, vehicle_id) values (10, 'Kess', 'HH-400', 5);

INSERT INTO software(id, name, version, ecu_id) values (1, 'powertrain', 1, 1);
INSERT INTO software(id, name, version, ecu_id) values (2, 'powertrain', 1, 6);
INSERT INTO software(id, name, version, ecu_id) values (3, 'powertrain', 2, 2);
INSERT INTO software(id, name, version, ecu_id) values (4, 'powertrain', 2, 3);
INSERT INTO software(id, name, version, ecu_id) values (5, 'powertrain', 2, 5);
INSERT INTO software(id, name, version, ecu_id) values (6, 'powertrain', 3, 1);
INSERT INTO software(id, name, version, ecu_id) values (7, 'ecu_controller', 1, 5);
INSERT INTO software(id, name, version, ecu_id) values (8, 'ecu_controller', 2, 4);
INSERT INTO software(id, name, version, ecu_id) values (9, 'ecu_controller', 2, 5);
INSERT INTO software(id, name, version, ecu_id) values (10, 'radio_controller', 1, 1);
INSERT INTO software(id, name, version, ecu_id) values (11, 'radio_controller', 1, 4);
INSERT INTO software(id, name, version, ecu_id) values (12, 'seatpack', 1, 6);
INSERT INTO software(id, name, version, ecu_id) values (13, 'seatpack', 2, 3);
INSERT INTO software(id, name, version, ecu_id) values (14, 'seatpack', 3, 4);
INSERT INTO software(id, name, version, ecu_id) values (15, 'hud', 2, 6);
INSERT INTO software(id, name, version, ecu_id) values (16, 'hud', 3, 3);
INSERT INTO software(id, name, version, ecu_id) values (17, 'hud', 4, 2);
INSERT INTO software(id, name, version, ecu_id) values (18, 'hud', 2, 10);
INSERT INTO software(id, name, version, ecu_id) values (19, 'hud', 1, 9);

