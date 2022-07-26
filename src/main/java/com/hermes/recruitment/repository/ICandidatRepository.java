package com.hermes.recruitment.repository;

import com.hermes.recruitment.model.Candidat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ICandidatRepository extends JpaRepository<Candidat, Long> {

    default List<Candidat> findAllBySurname(String surname) {
        List<Candidat> candidati = new ArrayList<>();
        for (Candidat candidat : findAll()) {
            if (candidat.getSurname().equals(surname))
                candidati.add(candidat);
        }
        return candidati;
    }
}
