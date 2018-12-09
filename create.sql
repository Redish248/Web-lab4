CREATE TABLE UserLab (
  user_Id serial PRIMARY KEY,
  nick VARCHAR(40) NOT NULL,
  password VARCHAR(128) NOT NULL
);

CREATE TABLE PointLab (
  point_Id serial PRIMARY KEY,
  x REAL NOT NULL,
  y REAL NOT NULL,
  r REAL NOT NULL,
  is_In_Area BOOLEAN NOT NULL,
  session_id varchar(40) NOT NULL
);