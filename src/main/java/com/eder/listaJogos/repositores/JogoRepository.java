package com.eder.listaJogos.repositores;

import com.eder.listaJogos.models.Categoria;
import com.eder.listaJogos.models.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogoRepository extends JpaRepository<Jogo,String> {

}
