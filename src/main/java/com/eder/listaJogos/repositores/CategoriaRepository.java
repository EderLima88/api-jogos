package com.eder.listaJogos.repositores;

import com.eder.listaJogos.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria,String> {

}
