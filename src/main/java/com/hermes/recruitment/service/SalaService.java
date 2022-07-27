package com.hermes.recruitment.service;

import com.hermes.recruitment.model.Sala;
import com.hermes.recruitment.model.dto.SalaDTO;
import com.hermes.recruitment.repository.ISalaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SalaService {
    private final ISalaRepository repository;

    public void save(List<String> data, String numar)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        if (repository.findByNumar(numar) != null)
        {
            Sala el = repository.getByNumar(numar);
            for (String elem : data)
            {
                LocalDateTime dateTime = LocalDateTime.parse(elem, formatter);
                el.getData().add(dateTime);
            }
            repository.save(el);
        }
        else
        {
            ArrayList<LocalDateTime> date = new ArrayList<>();
            for (String elem : data)
            {
                LocalDateTime dateTime = LocalDateTime.parse(elem, formatter);
                date.add(dateTime);
            }
            Sala sala = new Sala(numar, date);
            repository.save(sala);
        }
    }

    public List<Sala> getSali()
    {
        return repository.findAll();
    }

    public Sala getSalaId(Long id)
    {
        return repository.findById(id).orElse(null);
    }

    public void deleteSala(Long id)
    {
        repository.deleteById(id);
    }

    public void deleteSalaOra(Long id, String ora)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(ora, formatter);
        Sala sala = repository.getReferenceById(id);
        if(repository.findById(id).isPresent())
            sala.getData().remove(dateTime);
        repository.save(sala);
    }

    public void saveSalaOra(Long id, String ora)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(ora, formatter);
        Sala sala = repository.getReferenceById(id);
        if(repository.findById(id).isPresent())
            sala.getData().add(dateTime);;
        repository.save(sala);
    }

    public void updateSala(Long id, List<String> data, String numar)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        ArrayList<LocalDateTime> date = new ArrayList<>();
        for (String elem : data)
        {
            LocalDateTime dateTime = LocalDateTime.parse(elem, formatter);
            date.add(dateTime);
        }
        deleteSala(id);
        Sala sala = new Sala(id, numar, date);
        repository.save(sala);

    }
}
