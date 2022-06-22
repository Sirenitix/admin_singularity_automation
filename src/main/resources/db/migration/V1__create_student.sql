CREATE TABLE rate
(
    id                        BIGINT   NOT NULL,
    student_id                BIGINT   NULL,
    diploma                   SMALLINT NULL,
    programming_experience    SMALLINT NULL,
    stack                     SMALLINT NULL,
    programming_participation SMALLINT NULL,
    majorit                   SMALLINT NULL,
    english_level             SMALLINT NULL,
    CONSTRAINT pk_rate PRIMARY KEY (id)
);

CREATE TABLE student
(
    id                     SERIAL NOT NULL,
    full_name                 VARCHAR(255) NULL,
    email                     VARCHAR(255) NULL,
    phone_number              VARCHAR(255) NULL,
    city                      VARCHAR(255) NULL,
    diploma                   BOOLEAN      NULL,
    programming_exp           INT          NULL,
    stack                     INT          NULL,
    programming_participation BOOLEAN       NULL,
    majorit                   BOOLEAN       NULL,
    english_level             INT          NULL,
    PRIMARY KEY(id)
    CONSTRAINT pk_student PRIMARY KEY (id)
);

ALTER TABLE rate
    ADD CONSTRAINT FK_RATE_ON_STUDENT FOREIGN KEY (student_id) REFERENCES student (id);