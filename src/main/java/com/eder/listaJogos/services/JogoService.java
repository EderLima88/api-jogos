package com.eder.listaJogos.services;

import com.eder.listaJogos.models.Categoria;
import com.eder.listaJogos.models.Console;
import com.eder.listaJogos.models.Jogo;
import com.eder.listaJogos.repositores.CategoriaRepository;
import com.eder.listaJogos.repositores.ConsoleRepository;
import com.eder.listaJogos.repositores.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JogoService {
    private JogoRepository jogoRepository;
    private ConsoleRepository consoleRepository;
    private CategoriaRepository categoriaRepository;

    @Autowired
    public JogoService(JogoRepository jogoRepository, ConsoleRepository consoleRepository, CategoriaRepository categoriaRepository) {
        this.jogoRepository = jogoRepository;
        this.consoleRepository = consoleRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public Jogo addJogo(Jogo jogo) {
        Jogo jogoParaAdicionar = new Jogo(jogo.getNome(), jogo.getDescricao(), jogo.getUrlDaImagem());
        return jogoRepository.save(jogoParaAdicionar);
    }

    public  Jogo findById(String id) {
        return  jogoRepository.findById(id).get();
    }

    public List<Jogo> findAll() {
        return jogoRepository.findAll();
    }

    public Jogo addConsole(String idJogo, String idConsole){
        Optional<Jogo> jogoRetornado = jogoRepository.findById(idJogo);
        Optional<Console> consoleOptional = consoleRepository.findById(idConsole);

        if (jogoRetornado.isEmpty() || consoleOptional.isEmpty()) {
            throw new RuntimeException("Jogo ou console não existe");
        }

        jogoRetornado.get().addConsole(consoleOptional.get());
        return  jogoRepository.save(jogoRetornado.get());
    }

    public Jogo addCategoria(String idJogo, String idCategoria){
        Optional<Jogo> jogoRetornado = jogoRepository.findById(idJogo);
        Optional<Categoria> categoriaOptional = categoriaRepository.findById(idCategoria);

        if (jogoRetornado.isEmpty() || categoriaOptional.isEmpty()) {
            throw new RuntimeException("Jogo ou categoria não existe");
        }

        jogoRetornado.get().addCategoria(categoriaOptional.get());
        return  jogoRepository.save(jogoRetornado.get());
    }

}
