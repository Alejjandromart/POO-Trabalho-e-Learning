package manager;

import model.Curso;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CursoManager {
    private List<Curso> cursos;

    public CursoManager() {
        this.cursos = new ArrayList<>();
    }

    // Create
    public void addCurso(Curso curso) {
        if (curso == null) {
            System.out.println("Erro: Curso não pode ser nulo.");
            return;
        }
        if (curso.getNomeCurso() == null || curso.getNomeCurso().trim().isEmpty()) {
            System.out.println("Erro: Nome do curso não pode ser vazio.");
            return;
        }
        if (getCursoById(curso.getIdCurso()).isPresent()) {
            System.out.println("Erro: Curso com ID " + curso.getIdCurso() + " já existe.");
            return;
        }
        this.cursos.add(curso);
        System.out.println("Curso '" + curso.getNomeCurso() + "' adicionado com sucesso.");
    }

    // List
    public List<Curso> getAllCursos() {
        return new ArrayList<>(cursos);
    }

    public Optional<Curso> getCursoById(int id) {
        return cursos.stream()
                .filter(c -> c.getIdCurso() == id)
                .findFirst();
    }

    public List<Curso> searchCursosByName(String name) {
        if (name == null || name.trim().isEmpty()) {
            return new ArrayList<>();
        }
        return cursos.stream()
                .filter(c -> c.getNomeCurso().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    // Edit
    public void updateCurso(Curso updatedCurso) {
        if (updatedCurso == null) {
            System.out.println("Erro: Curso atualizado não pode ser nulo.");
            return;
        }
        Optional<Curso> existingCursoOpt = getCursoById(updatedCurso.getIdCurso());
        if (existingCursoOpt.isPresent()) {
            Curso existingCurso = existingCursoOpt.get();
            existingCurso.setNomeCurso(updatedCurso.getNomeCurso());
            existingCurso.setPercRealizado(updatedCurso.getPercRealizado());
            System.out.println("Curso com ID " + updatedCurso.getIdCurso() + " atualizado com sucesso.");
        } else {
            System.out.println("Erro: Curso com ID " + updatedCurso.getIdCurso() + " não encontrado para atualização.");
        }
    }

    // Delete
    public void deleteCurso(int id) {
        boolean removed = cursos.removeIf(c -> c.getIdCurso() == id);
        if (removed) {
            System.out.println("Curso com ID " + id + " removido com sucesso.");
        } else {
            System.out.println("Erro: Curso com ID " + id + " não encontrado para remoção.");
        }
    }
}
