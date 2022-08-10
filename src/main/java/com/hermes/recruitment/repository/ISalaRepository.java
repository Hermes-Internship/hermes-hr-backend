package com.hermes.recruitment.repository;

import com.hermes.recruitment.model.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISalaRepository extends JpaRepository<Sala, Long> {
    Sala getByNumar(String numar);
}
