CREATE TABLE User (
  userId integer PRIMARY KEY,
  nick VARCHAR(40) NOT NULL,
  password VARCHAR(40) NOT NULL
);

CREATE TABLE Point (
  pointId INTEGER PRIMARY KEY,
  x REAL NOT NULL,
  y REAL NOT NULL,
  r REAL NOT NULL,
  isInArea BOOLEAN NOT NULL
);

CREATE SEQUENCE lab4.point_pointid_seq NO MINVALUE NO MAXVALUE NO CYCLE;
ALTER TABLE lab4.point ALTER COLUMN pointid SET DEFAULT nextval('lab4.point_pointid_seq');
ALTER SEQUENCE lab4.point_pointid_seq OWNED BY lab4.point.pointid;

CREATE SEQUENCE lab4.users_userid_seq NO MINVALUE NO MAXVALUE NO CYCLE;
ALTER TABLE lab4."user" ALTER COLUMN userid SET DEFAULT nextval('lab4.users_userid_seq');
ALTER SEQUENCE lab4.users_userid_seq OWNED BY lab4."user".userid;