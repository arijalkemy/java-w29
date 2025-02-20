-- src/main/resources/inserts.sql

INSERT INTO Vehicle (license_plate, model, brand, year_of_manufacture, number_of_wheels, vehicle_type) VALUES ('ABC123', 'Model S', 'Tesla', 2020, 4, 'PASSENGER');
INSERT INTO Vehicle (license_plate, model, brand, year_of_manufacture, number_of_wheels, vehicle_type) VALUES ('XYZ789', 'Mustang', 'Ford', 2019, 4, 'PASSENGER');
INSERT INTO Vehicle (license_plate, model, brand, year_of_manufacture, number_of_wheels, vehicle_type) VALUES ('DEF456', 'Civic', 'Honda', 2018, 4, 'UTILITY');
INSERT INTO Vehicle (license_plate, model, brand, year_of_manufacture, number_of_wheels, vehicle_type) VALUES ('GHI012', 'Corolla', 'Toyota', 2017, 4, 'UTILITY');
INSERT INTO Vehicle (license_plate, model, brand, year_of_manufacture, number_of_wheels, vehicle_type) VALUES ('JKL345', 'F-150', 'Ford', 2021, 4, 'TRUCK');
INSERT INTO Vehicle (license_plate, model, brand, year_of_manufacture, number_of_wheels, vehicle_type) VALUES ('MNO678', 'Ram 1500', 'Dodge', 2022, 4, 'TRUCK');

INSERT INTO Accident (accident_date, economic_loss, vehicle_id) VALUES ('2023-01-01', 5000.00, 1);
INSERT INTO Accident (accident_date, economic_loss, vehicle_id) VALUES ('2023-02-01', 3000.00, 2);
INSERT INTO Accident (accident_date, economic_loss, vehicle_id) VALUES ('2023-03-01', 4000.00, 3);
INSERT INTO Accident (accident_date, economic_loss, vehicle_id) VALUES ('2023-04-01', 2000.00, 4);
INSERT INTO Accident (accident_date, economic_loss, vehicle_id) VALUES ('2023-05-01', 6000.00, 5);
INSERT INTO Accident (accident_date, economic_loss, vehicle_id) VALUES ('2023-06-01', 7000.00, 6);