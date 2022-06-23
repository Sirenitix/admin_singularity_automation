CREATE TABLE fraud_entity
(
    user_id              VARCHAR(255) NOT NULL,
    last_name            VARCHAR(255),
    first_name           VARCHAR(255),
    lesson_id            VARCHAR(255),
    step_id              VARCHAR(255),
    step_position        VARCHAR(255),
    stepurl              VARCHAR(255),
    cheating_probability VARCHAR(255),
    CONSTRAINT pk_fraudentity PRIMARY KEY (user_id)
);