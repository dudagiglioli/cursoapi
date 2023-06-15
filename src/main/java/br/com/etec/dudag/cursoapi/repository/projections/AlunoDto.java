package br.com.etec.dudag.cursoapi.repository.projections;

public class AlunoDto {

  private Long id; //classe definida para pesquisa
  private String nomealuno;

  //campos que estão fazendo relacionamento com aluno <--> cidade e curso
  private String nomecidade;
  private String uf;
  private String nomecurso;

  //inserir um copnstrutor; cria uma classe para pegar e receber  os dados
  public AlunoDto(Long id, String nomealuno, String nomecidade, String uf, String nomecurso) {
    this.id = id;
    this.nomealuno = nomealuno;
    this.nomecidade = nomecidade;
    this.uf = uf;
    this.nomecurso = nomecurso;
  }

  //getter and setter
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNomealuno() {
    return nomealuno;
  }

  public void setNomealuno(String nomealuno) {
    this.nomealuno = nomealuno;
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

  public String getNomecurso() {
    return nomecurso;
  }

  public void setNomecurso(String nomecurso) {
    this.nomecurso = nomecurso;
  }


}
