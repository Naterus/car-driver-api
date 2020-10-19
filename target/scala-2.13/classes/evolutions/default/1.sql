# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table authorizations (
  authorization_key             varchar(255) not null,
  email                         varchar(255),
  name                          varchar(255),
  constraint uq_authorizations_email unique (email),
  constraint pk_authorizations primary key (authorization_key)
);

create table cars (
  id                            integer auto_increment not null,
  licence_plate                 varchar(255),
  convertible                   boolean default false not null,
  rating                        integer not null,
  engine_type                   varchar(255),
  colour                        varchar(255),
  model                         varchar(255),
  seat_count                    integer not null,
  speed_limit                   varchar(255),
  manufacturer_id               varchar(255),
  driver_id                     integer,
  constraint uq_cars_licence_plate unique (licence_plate),
  constraint uq_cars_manufacturer_id unique (manufacturer_id),
  constraint uq_cars_driver_id unique (driver_id),
  constraint pk_cars primary key (id)
);

create table drivers (
  id                            integer auto_increment not null,
  first_name                    varchar(255),
  last_name                     varchar(255),
  username                      varchar(255),
  password                      varchar(255),
  contact_number                varchar(255),
  gender                        varchar(255),
  age                           integer not null,
  online_status                 boolean default false not null,
  deleted                       boolean default false not null,
  date_created                  timestamp,
  date_modified                 timestamp,
  car_assigned_id               integer,
  constraint uq_drivers_username unique (username),
  constraint uq_drivers_car_assigned_id unique (car_assigned_id),
  constraint pk_drivers primary key (id)
);

create table manufacturers (
  id                            varchar(255) not null,
  location                      varchar(255),
  date_established              timestamp,
  constraint pk_manufacturers primary key (id)
);

alter table cars add constraint fk_cars_manufacturer_id foreign key (manufacturer_id) references manufacturers (id) on delete restrict on update restrict;

alter table cars add constraint fk_cars_driver_id foreign key (driver_id) references drivers (id) on delete restrict on update restrict;

alter table drivers add constraint fk_drivers_car_assigned_id foreign key (car_assigned_id) references cars (id) on delete restrict on update restrict;


# --- !Downs

alter table cars drop constraint if exists fk_cars_manufacturer_id;

alter table cars drop constraint if exists fk_cars_driver_id;

alter table drivers drop constraint if exists fk_drivers_car_assigned_id;

drop table if exists authorizations;

drop table if exists cars;

drop table if exists drivers;

drop table if exists manufacturers;

