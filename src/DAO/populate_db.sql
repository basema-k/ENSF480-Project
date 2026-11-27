DROP TABLE IF EXISTS "Bookings";
DROP TABLE IF EXISTS "Customers";
DROP TABLE IF EXISTS "FlightAgents";
DROP TABLE IF EXISTS "Flights";
DROP TABLE IF EXISTS "PaymentMethods";
DROP TABLE IF EXISTS "SysAdmins";

CREATE TABLE Flights (
    id INTEGER PRIMARY KEY,
    source TEXT,
    destination TEXT,
    airline TEXT,
    flight_date DATE
);

INSERT INTO Flights (id, source, destination, airline, flight_date)
VALUES (0, "YYC", "YYZ", "Air Canada", '2026-01-01');


CREATE TABLE Customers (
    first_name TEXT,
    last_name TEXT,
    email TEXT PRIMARY KEY,
    password TEXT
);
INSERT INTO Customers (first_name, last_name, email, password)
VALUES("John", "Smith", "john@smith.com", "1234" );
INSERT INTO Customers (first_name, last_name, email, password)
VALUES("Fei-Fei", "Li", "feifeili@cs.stanford.edu", "5678" );

CREATE TABLE SysAdmins (
    email TEXT PRIMARY KEY,
    password TEXT
);
INSERT INTO SysAdmins ( email, password)
VALUES ("janesmith@gmail.com", "1234");

CREATE TABLE FlightAgents (
    email TEXT PRIMARY KEY,
    password TEXT
);
INSERT INTO FlightAgents ( email, password)
VALUES ("condortravel@gmail.com", "1234");

CREATE TABLE Bookings (
    id INTEGER PRIMARY KEY,
    seat_number INTEGER,
    seat_letter CHAR,
    customer_id INTEGER,
    flight_id INTEGER
);
INSERT INTO Bookings (id, seat_number, seat_letter, customer_id, flight_id )
VALUES (0, 3, 'A', "john@smith.com", 0 );
INSERT INTO Bookings (id, seat_number, seat_letter, customer_id, flight_id )
VALUES (1, 3, 'B', "feifeili@cs.stanford.edu", 0 );

CREATE TABLE PaymentMethods(
    card_number INTEGER
);
INSERT INTO PaymentMethods ( card_number)
VALUES (12);
INSERT INTO PaymentMethods ( card_number)
VALUES (67);
INSERT INTO PaymentMethods ( card_number)
VALUES (1234);
SELECT * FROM Flights;