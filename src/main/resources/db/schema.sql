CREATE TABLE Doctors
(
    doctor_id INT UNSIGNED           NOT NULL AUTO_INCREMENT,
    doctor_name VARCHAR(50)          NOT NULL,
    doctor_surname VARCHAR(255)      NOT NULL,
    doctor_spec VARCHAR(255)         NOT NULL,
    doctor_region VARCHAR(255)       NOT NULL,

    PRIMARY KEY (doctor_id)
);