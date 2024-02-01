CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE account (
	id UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
	login_id VARCHAR(20) UNIQUE NOT NULL,
	password VARCHAR(255) NOT NULL,
	name VARCHAR(20) NOT NULL,
	nick_name VARCHAR(10) UNIQUE NOT NULL,
	vehicle_number VARCHAR(10),
	region VARCHAR(10),
	profile VARCHAR(255),
	role VARCHAR(100) NOT NULL,
	email VARCHAR(255) UNIQUE NOT NULL,
	phone VARCHAR(11) UNIQUE NOT NULL,
	created_date TIMESTAMP NOT NULL,
    updated_date TIMESTAMP
);

CREATE TABLE site (
	id UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
	account_id UUID NOT NULL,
	name VARCHAR(20) NOT NULL,
	address VARCHAR(50) NOT NULL,
	phone VARCHAR(11) NOT NULL,
	type VARCHAR(10) NOT NULL,
	environment VARCHAR(128) NOT NULL,
	introduce VARCHAR(100) NOT NULL,
	manner_time VARCHAR(100) NOT NULL,
	profile VARCHAR(255) NOT NULL,
	layout VARCHAR(255) NOT NULL,
	created_date TIMESTAMP NOT NULL,
    updated_date TIMESTAMP
);

CREATE TABLE zone (
	id UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
	site_id UUID NOT NULL,
	name VARCHAR(20) UNIQUE NOT NULL,
	profile VARCHAR(255) NOT NULL,
	introduce VARCHAR(100) NOT NULL,
	price VARCHAR(10) NOT NULL,
	check_in TIMESTAMP NOT NULL,
	check_out TIMESTAMP NOT NULL,
	type VARCHAR(100) NOT NULL,
	floor_material VARCHAR(255) NOT NULL,
	recommend_people VARCHAR(255) NOT NULL,
	is_parking BOOLEAN NOT NULL,
	min_reservation_day SMALLINT NOT NULL,
	width NUMERIC NOT NULL,
	height NUMERIC NOT NULL,
	created_date TIMESTAMP NOT NULL,
    updated_date TIMESTAMP
);