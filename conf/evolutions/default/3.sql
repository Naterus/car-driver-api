# --- Sample dataset
# --- !Ups
insert into drivers (id,first_name,last_name,username,password,contact_number,gender,age,online_status,deleted,car_assigned_id) values (1,'Jane','Doe','Jane123','$2a$10$CPgGwHmS2EpzeGZv9dGmSOUsfn6xnXgIfRY2Ra5QrUBN1kbD8Mr9C','Female','0813903338',29,false,false,1);
insert into drivers (id,first_name,last_name,username,password,contact_number,gender,age,online_status,deleted,car_assigned_id) values (2,'John','Doe','John123','$2a$10$12iI6sZslBM8LFsRiS2r.uBSkqXg3hWF7FccyParme0b79MU0UVGa','Male','0813903338',25,true,false,3);
insert into drivers (id,first_name,last_name,username,password,contact_number,gender,age,online_status,deleted,car_assigned_id) values (3,'Peter','Philip','Philip112','$2a$10$dSXsuHb7.VauWkycQc4mQ.GLABXHkuxGcWI7FSQW5dsPep7Wi0rem','Male','0813903338',21,true,false,2);

update cars set driver_id = 1  where id = 1;
update cars set driver_id = 2  where id = 3;