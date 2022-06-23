

CREATE TABLE table_entity
(
    email         VARCHAR(255) NOT NULL,
    stepikid      VARCHAR(255),
    progress      VARCHAR(255),
    progress_full VARCHAR(255),
    plagiarism    VARCHAR(255),
    flaud         VARCHAR(255),
    CONSTRAINT pk_tableentity PRIMARY KEY (email)
);
