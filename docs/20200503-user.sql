drop table if exists user;
create table user
(
    id               bigint primary key not null,
    username         varchar(255)       null comment '用户名',
    password         varchar(32)        null comment '密码',
    create_data_time datetime           null,
    creator          bigint             null,
    modify_data_time datetime           null,
    modifier         bigint             null,
    deleted          bool               null
)
    comment '用户';

