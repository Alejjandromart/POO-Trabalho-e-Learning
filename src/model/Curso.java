package model;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.HashMap;

public class Curso {
    private int idCurso;
    private String nomeCurso;
    private double percRealizado; // This might be aggregate for a specific student, or overall for the course

    public Curso(int idCurso, String nomeCurso, double percRealizado) {
        this.idCurso = idCurso;
        this.nomeCurso = nomeCurso;
        this.percRealizado = percRealizado;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public double getPercRealizado() {
        return percRealizado;
    }

    public void setPercRealizado(double percRealizado) {
        this.percRealizado = percRealizado;
    }

    public Map<Aluno, Integer> calcularProgresso(List<Aluno> alunos, Curso curso) {
        Map<Aluno, Integer> progressoPorAluno = new HashMap<>();
        System.out.println("Calculando progresso para o curso '" + curso.getNomeCurso() + "'.");
        for (Aluno aluno : alunos) {
            // This is a simplified calculation. In a real system, it would involve
            // checking completed lessons, exercises, etc.
            // For now, let's use a placeholder, e.g., points divided by a max
            int simulatedProgress = aluno.getPontos() / 2; // Arbitrary calculation
            progressoPorAluno.put(aluno, simulatedProgress);
            System.out.println("  - Aluno " + aluno.getNome() + ": " + simulatedProgress + "% de progresso.");
        }
        return progressoPorAluno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Curso curso = (Curso) o;
        return idCurso == curso.idCurso;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCurso);
    }

    @Override
    public String toString() {
        return "Curso{" +
               "idCurso=" + idCurso +
               ", nomeCurso='" + nomeCurso + '\'' +
               ", percRealizado=" + percRealizado +
               '}';
    }
}
