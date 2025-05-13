CREATE TABLE ot_package(
	id              int(11)           AUTO_INCREMENT   PRIMARY KEY,
	name            varchar(50)       NOT NULL,
	price           decimal(9,2)	  NOT NULL,
	room_type       varchar(100)	  NULL,
	food_type       varchar(100)	  NULL,
	nurse_facility  boolean           default false,
	pick_drop       boolean           default false,
	post_care       boolean           default false,
	physiotherapy   boolean           default false,
	hospital_id 	int(11)           NOT NULL,
    department_id 	int(11)           NOT NULL,
	FOREIGN KEY (hospital_id) 	      REFERENCES hospital(id) 	    ON DELETE CASCADE,
    FOREIGN KEY (department_id)       REFERENCES department(id) 	ON DELETE CASCADE
)