package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Professor {
    private int id;
    private String nome;
    private String celular;
    private List<Curso> cursos;
    private List<Map<String, Object>> alunoExercicio; // tupla: aula, data, acertou

    public Professor(int id, String nome, String celular) {
        this.id = id;
        this.nome = nome;
        this.celular = celular;
        this.cursos = new ArrayList<>();
        this.alunoExercicio = new ArrayList<>();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public List<Map<String, Object>> getAlunoExercicio() {
        return alunoExercicio;
    }

    public void setAlunoExercicio(List<Map<String, Object>> alunoExercicio) {
        this.alunoExercicio = alunoExercicio;
    }

    public void corrigirExercicio(Aluno aluno, Curso curso, boolean acertou) {
        System.out.println("Professor " + nome + " corrigiu o exercício do aluno " + aluno.getNome() + " para o curso " + curso.getNomeCurso() + ".");
        // Simulate recording the correction
        Map<String, Object> record = Map.of(
                "aula", curso.getNomeCurso(), // Using course name as placeholder for 'aula'
                "data", new java.util.Date(),
                "acertou", acertou
        );
        alunoExercicio.add(record);

        if (acertou) {
            System.out.println("Aluno " + aluno.getNome() + " acertou o exercício!");
        } else {
            System.out.println("Aluno " + aluno.getNome() + " errou o exercício.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Professor professor = (Professor) o;
        return id == professor.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Professor{" +
               "id=" + id +
               ", nome='" + nome + '\'' +
               ", celular='" + celular + '\'' +
               ", cursos=" + cursos.size() + " cursos" +
               ", alunoExercicio=" + alunoExercicio.size() + " records" +
               '}';
    }
}
