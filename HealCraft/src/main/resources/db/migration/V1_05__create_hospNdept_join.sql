CREATE TABLE hospital_department (
    hospital_id 	int(11) NOT NULL,
    department_id 	int(11) NOT NULL,
    PRIMARY KEY (hospital_id, department_id),
    FOREIGN KEY (hospital_id) 	REFERENCES hospital(id) 	ON DELETE CASCADE,
    FOREIGN KEY (department_id) REFERENCES department(id) 	ON DELETE CASCADE
);