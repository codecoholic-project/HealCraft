CREATE TABLE service(
 id            int(11)           AUTO_INCREMENT PRIMARY KEY, 
 name          varchar(50)       NOT NULL, 
description    varchar(512), 
active         boolean           default true, 
prime          boolean           default false

)