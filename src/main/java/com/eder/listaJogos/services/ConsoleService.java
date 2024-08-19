package com.eder.listaJogos.services;

import com.eder.listaJogos.models.Console;
import com.eder.listaJogos.repositores.ConsoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsoleService {
    private ConsoleRepository repository;

    @Autowired
    public ConsoleService(ConsoleRepository repository){
        this.repository = repository;
    }

    public Console addConsole(Console console) {
        return repository.save(console);
    }

    public Console findById(String uuid) {
        return repository.findById(uuid).get();
    }

    public List<Console> findAll() {
        return repository.findAll();
    }

}
