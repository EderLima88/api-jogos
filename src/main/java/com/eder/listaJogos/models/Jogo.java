package com.eder.listaJogos.models;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "tb_jogo")
public class Jogo {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;
    
    private String nome;
    private String descricao;
    private String urlDaImagem;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tb_jogo_console",
            joinColumns = @JoinColumn(name = "jogo_id"),
            inverseJoinColumns = @JoinColumn(name = "console_id"))
    private List<Console> consoles = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tb_jogo_categoria",
            joinColumns = @JoinColumn(name = "jogo_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    private List<Categoria> categorias = new ArrayList<>();

    // Construtor vazio obrigatório para o Hibernate funcionar no H2
    public Jogo() {
    }

    // Construtor de 3 parâmetros que o seu JogoService utiliza
    public Jogo(String nome, String descricao, String urlDaImagem) {
        this.nome = nome;
        this.descricao = descricao;
        this.urlDaImagem = urlDaImagem;
    }

    // Getters manuais básicos para o seu Service ler os dados sem depender de ferramentas externas
    public String getUuid() { return uuid; }
    public String getNome() { return nome; }
    public String getDescricao() { return descricao; }
    public String getUrlDaImagem() { return urlDaImagem; }

    public void addCategoria(Categoria categoria) { this.categorias.add(categoria); }
    public void addConsole(Console console) { this.consoles.add(console); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jogo jogo = (Jogo) o;
        return Objects.equals(uuid, jogo.uuid) && Objects.equals(nome, jogo.nome);
    }

    @Override
    public int hashCode() { return Objects.hash(uuid, nome); }
}
