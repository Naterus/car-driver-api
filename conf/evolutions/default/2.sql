# --- Sample dataset
# --- !Ups

insert into manufacturers (id,location) values ('Honda','Lagos');
insert into manufacturers (id,location) values ('Innoson','Lagos');
insert into manufacturers (id,location) values ('Toyota','Lagos');

insert into cars (id,licence_plate,convertible,rating,seat_count,engine_type,colour,model,manufacturer_id,speed_limit) values (1,'kda-bca',true,4,5,'Gas','Black','2020','Toyota','200km/h');
insert into cars (id,licence_plate,convertible,rating,seat_count,engine_type,colour,model,manufacturer_id,speed_limit) values (2,'qbj-b2a',false,1,6,'Gas','Red','2020','Honda','320km/h');
insert into cars (id,licence_plate,convertible,rating,seat_count,engine_type,colour,model,manufacturer_id,speed_limit) values (3,'jos-cca',true,2,10,'Electric','Black','2018','Innoson','260km/h');