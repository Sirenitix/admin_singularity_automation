CREATE TABLE student
(
    id                     SERIAL NOT NULL,
    full_name                 VARCHAR(255) NULL,
    email                     VARCHAR(255) NULL,
    phone_number              VARCHAR(255) NULL,
    city                      VARCHAR(255) NULL,
    diploma                   BOOLEAN      NULL,
    com_exp                   BOOLEAN      NULL,

    stack                     INT          NULL,
    programming_participation BOOLEAN      NULL,
    majorit                   BOOLEAN      NULL,
    english_level             INT          NULL,
    PRIMARY KEY(id)
);