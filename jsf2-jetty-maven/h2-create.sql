create table tb_contact (
  id                        bigint not null,
  nome                      varchar(255),
  email                     varchar(255),
  constraint pk_tb_contact primary key (id))
;

create table tb_theme (
  id                        bigint not null,
  theme                     varchar(255),
  constraint pk_tb_theme primary key (id))
;

create sequence tb_contact_seq;

create sequence tb_theme_seq;



