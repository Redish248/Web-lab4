CREATE TABLE UserLab (
  user_Id serial PRIMARY KEY,
  username VARCHAR(40) NOT NULL,
  password VARCHAR(128) NOT NULL
);

CREATE TABLE PointLab (
  point_Id serial PRIMARY KEY,
  x REAL NOT NULL,
  y REAL NOT NULL,
  r REAL NOT NULL,
  is_In_Area varchar(16) NOT NULL,
  user_id integer references UserLab NOT NULL
);