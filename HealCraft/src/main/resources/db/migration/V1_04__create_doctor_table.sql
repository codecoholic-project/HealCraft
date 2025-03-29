CREATE TABLE doctor(
	id 			int(11) 		AUTO_INCREMENT PRIMARY KEY, 
	name 		varchar(50) 	NOT NULL, 
	degree 		varchar(100), 
	experience 	varchar(200), 
	about 		varchar(500), 
	consultant 	boolean 		default false,
	dept_id		int				NOT NULL,
	
	Foreign key(dept_id) references Department(id)
	
	)