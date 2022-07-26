package com.hermes.recruitment.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class CandidatDTO implements Serializable {
    private Long id;
    private String surname;
    private String firstname;
    private String mail;
    private String phone;
    private String department;
    private String motivation;
}
