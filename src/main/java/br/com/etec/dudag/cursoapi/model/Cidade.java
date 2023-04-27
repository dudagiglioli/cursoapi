package br.com.etec.dudag.cursoapi.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "cidade")

public class Cidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    //campos da tabela
    private Integer idcidade;

    private String nomecidade;

    private String uf;

    @OneToMany(mappedBy = "cidade")
    private List<Aluno> alunoscidade = new ArrayList<>();

    //getter and setter
    public List<Aluno> getAlunoscidade() {
        return alunoscidade;
    }

    public void setAlunoscidade(List<Aluno> alunoscidade) {
        this.alunoscidade = alunoscidade;
    }

    public Integer getIdcidade() {
        return idcidade;
    }

    public void setIdcidade(Integer idcidade) {
        this.idcidade = idcidade;
    }

    public String getNomecidade() {
        return nomecidade;
    }

    public void setNomecidade(String nomecidade) {
        this.nomecidade = nomecidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }


    //equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cidade cidade = (Cidade) o;
        return idcidade.equals(cidade.idcidade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idcidade);
    }
}
