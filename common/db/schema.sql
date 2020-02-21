CREATE DATABASE IF NOT EXISTS keycloak;

CREATE DATABASE IF NOT EXISTS relation;
CREATE TABLE IF NOT EXISTS relation.relation(
    requester_id varchar(36) not null,
    target_id varchar(36) not null,
    created datetime not null,
    CONSTRAINT relation_pk PRIMARY KEY (requester_id, target_id)
);