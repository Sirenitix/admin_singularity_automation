package com.example.firstcase.filereader.models;

import lombok.Data;

@Data
public class FraudReq {

    String user_id;
    String last_name;
    String first_name;
    String lesson_id;
    String step_id;
    String step_position;
    String step_url;
    String cheating_probability;
}
