package com.hermes.recruitment.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class SalaDTO {
    private long id;
    private String numar;
    private List<LocalDateTime> data;
}
