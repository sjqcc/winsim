drop table if exists role;
create table role
(
    id               bigint primary key not null,
    name             varchar(255)       null,
    create_data_time datetime           null,
    creator          bigint             null,
    modify_data_time datetime           null,
    modifier         bigint             null,
    deleted          bool               null
)