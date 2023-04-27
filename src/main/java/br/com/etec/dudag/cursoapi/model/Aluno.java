package br.com.etec.dudag.cursoapi.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "aluno")

public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    // BigInt = Long
    private Long idaluno;

    private String nomealuno;

    //relacionamento = chave estrangeira FK
    @ManyToOne
    //relaciona - junta as tabelas
    @JoinColumn(name = "idcurso")
    private Curso curso;

    @ManyToOne
    @JoinColumn(name= "idcidade")
    private Cidade cidade;

    //getter and setter
    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Long getIdaluno() {
        return idaluno;
    }

    public void setIdaluno(Long idaluno) {
        this.idaluno = idaluno;
    }

    public String getNomealuno() {
        return nomealuno;
    }

    public void setNomealuno(String nomealuno) {
        this.nomealuno = nomealuno;
    }


    //equals PK e FK

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return idaluno.equals(aluno.idaluno) && curso.equals(aluno.curso) && cidade.equals(aluno.cidade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idaluno, curso, cidade);
    }
}
