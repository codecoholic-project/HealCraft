CREATE TABLE users (
    id 				BIGINT 		AUTO_INCREMENT PRIMARY KEY,
    user_type 		VARCHAR(50)	NOT NULL,
    first_name 		VARCHAR(100)	NOT NULL,
    last_name 		VARCHAR(100),
    address 		TEXT,
    email 			VARCHAR(150) 	NOT NULL UNIQUE,
    phone 			VARCHAR(20),
    country 		VARCHAR(100),
    city 			VARCHAR(100),
    date_of_birth 	DATE,
    marital_status 	VARCHAR(50),
    gender 			VARCHAR(20),
    enabled 		BOOLEAN 	DEFAULT TRUE,
    password 		VARCHAR(255) NOT NULL,
    created_on 		DATETIME 	DEFAULT CURRENT_TIMESTAMP,
    updated_on 		DATETIME 	DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);