package com.hermes.recruitment.service;

import com.hermes.recruitment.model.Candidat;
import com.hermes.recruitment.model.dto.CandidatDTO;
import com.hermes.recruitment.repository.ICandidatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CandidatService {

    private final ICandidatRepository repository;

    public void save(CandidatDTO candidatDTO) {
        Candidat candidat = new Candidat(candidatDTO.getSurname(), candidatDTO.getFirstname(), candidatDTO.getMail(), candidatDTO.getPhone(), candidatDTO.getDepartment(), candidatDTO.getMotivation());

        repository.save(candidat);
    }

    public List<Candidat> getCandidati()
    {
        return repository.findAll();
    }

    public List<Candidat> getCandidat(String surname)
    {
        return repository.findAllBySurname(surname);
    }

    public Optional<Candidat> findCandidat(Long id)
    {
        return repository.findById(id);
    }

    public void deleteCandidat(Long id)
    {
        repository.deleteById(id);
    }

}
