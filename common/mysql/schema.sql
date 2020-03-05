CREATE DATABASE IF NOT EXISTS keycloak;

CREATE DATABASE IF NOT EXISTS relation;
CREATE TABLE IF NOT EXISTS relation.relation
(
    requester_id char(36) not null,
    target_id    char(36) not null,
    created      datetime not null,
    CONSTRAINT relation_pk PRIMARY KEY (requester_id, target_id)
);

CREATE DATABASE IF NOT EXISTS user;
CREATE TABLE IF NOT EXISTS user.user
(
    auto_id       bigint primary key auto_increment,
    id            char(36) not null unique,
    created       datetime not null,
    last_sign_in  datetime not null,
    sign_in_count bigint   not null
);