package model;

import java.util.Date;
import java.util.Objects;

public class Aluno implements Usuarios {
    private int id;
    private String nome;
    private String celular;
    private Date dataNasc;
    private String aulaAtual;
    private int pontos;

    public Aluno(int id, String nome, String celular, Date dataNasc, String aulaAtual, int pontos) {
        this.id = id;
        this.nome = nome;
        this.celular = celular;
        this.dataNasc = dataNasc;
        this.aulaAtual = aulaAtual;
        this.pontos = pontos;
    }
    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

        public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getAulaAtual() {
        return aulaAtual;
    }

    public void setAulaAtual(String aulaAtual) {
        this.aulaAtual = aulaAtual;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public boolean entregarExercicio() {
        System.out.println("Aluno " + nome + "entregou um execício.");
        this.pontos += 10;
        return true;
    }

    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return id == aluno.id;
    }
        @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Aluno{" +
               "id=" + id +
               ", nome='" + nome + '\'' +
               ", celular='" + celular + '\'' +
               ", dataNasc=" + dataNasc +
               ", aulaAtual='" + aulaAtual + '\'' +
               ", pontos=" + pontos +
               '}';
    }

}
