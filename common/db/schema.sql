CREATE DATABASE IF NOT EXISTS keycloak;

CREATE DATABASE IF NOT EXISTS friend;
CREATE TABLE IF NOT EXISTS friend.friend(
    id varchar(36) not null,
    friend_id varchar(36) not null,
    created datetime not null,
    CONSTRAINT friend_pk PRIMARY KEY (id, friend_id)
);