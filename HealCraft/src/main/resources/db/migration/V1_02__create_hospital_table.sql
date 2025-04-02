CREATE TABLE hospital(
	id              int(11)             AUTO_INCREMENT PRIMARY KEY, 
	name            varchar(50)         NOT NULL, 
	description     varchar(512), 
	address         varchar(500), 
	contact         varchar(10), 
	email           varchar(20), 
	url             varchar(200)
	
	)