package com.hermes.recruitment.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "sali")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sala {
    @Id
    @GeneratedValue
    @Column(name = "Id")
    private long id;

    @Column(name = "Numar", nullable = false, length = 20)
    private String numar;

    @Column(name = "Data_Ora")
    @ElementCollection
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = JsonFormat.Shape.STRING)
    @ApiModelProperty(required = true, example = "2021-08-20T00:00:00")
    private List<LocalDateTime> data;

    public Sala(String numar, List<LocalDateTime> data) {
        this.numar = numar;
        this.data = data;
    }
    
}
