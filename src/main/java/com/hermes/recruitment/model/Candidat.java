package com.hermes.recruitment.model;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "candidat")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Candidat implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "firstname", nullable = false)
    private String firstname;

    @Column(name = "mail", nullable = false)
    private String mail;

    @Column(name = "phone", nullable = false, length = 10)
    private String phone;

    @Column(name = "department", nullable = false)
    private String department;

    @Column(name = "motivation", nullable = false)
    private String motivation;

    public Candidat(String surname, String firstname, String mail, String phone, String department, String motivation)
    {
        this.surname = surname;
        this.firstname = firstname;
        this.mail = mail;
        this.phone = phone;
        this.department = department;
        this.motivation = motivation;
    }

}
