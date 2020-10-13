
CREATE TABLE muscles(
    muscle_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(250) NOT NULL,
    description VARCHAR(500) NOT NULL,
    is_injured boolean DEFAULT false
);

CREATE TABLE images(
   image_id BIGINT AUTO_INCREMENT PRIMARY KEY,
   file_path VARCHAR(250) NOTNULL,
   file_url VARCHAR(250) NOTNULL,
   muscle_id BIGINT REFERENCES muscles(muscle_id)
);