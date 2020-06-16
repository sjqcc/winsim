drop table if exists user_role;
create table user_role
(
    id               bigint primary key not null,
    user_id          bigint             null,
    role_id          bigint             null,
    create_data_time datetime           null,
    creator          bigint             null,
    modify_data_time datetime           null,
    modifier         bigint             null,
    deleted          bool               null
)
    comment '用户角色关联';

