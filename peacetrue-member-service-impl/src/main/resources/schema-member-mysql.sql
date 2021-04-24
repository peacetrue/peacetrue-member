drop table if exists member;
create table member
(
    id            bigint unsigned primary key auto_increment comment '主键',
    username      varchar(32) unique not null comment '会员名',
    password      varchar(255)       not null comment '密码',
    creator_id    bigint unsigned    not null comment '创建者主键',
    created_time  datetime           not null comment '创建时间',
    modifier_id   bigint unsigned    not null comment '修改者主键',
    modified_time timestamp          not null comment '最近修改时间'
) comment '会员';

insert into member (id, username, password, creator_id, created_time, modifier_id, modified_time)
values (0, 'system', '{noop}system', 0, current_timestamp, 0, current_timestamp);
update member
set id=0
where username = 'system';
insert into member (id, username, password, creator_id, created_time, modifier_id, modified_time)
values (1, 'admin', '{noop}admin', 0, current_timestamp, 0, current_timestamp);
