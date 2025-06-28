package manager;

import model.Professor;
//import model.Curso;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class ProfessorManager {
    private List<Professor> professores;

    public ProfessorManager() {
        this.professores = new ArrayList<>();
    }

    // Create
    public void addProfessor(Professor professor) {
        if (professor == null) {
            System.out.println("Erro: Professor não pode ser nulo.");
            return;
        }
        if (professor.getNome() == null || professor.getNome().trim().isEmpty()) {
            System.out.println("Erro: Nome do professor não pode ser vazio.");
            return;
        }
        if (getProfessorById(professor.getId()).isPresent()) {
            System.out.println("Erro: Professor com ID " + professor.getId() + " já existe.");
            return;
        }
        this.professores.add(professor);
        System.out.println("Professor " + professor.getNome() + " adicionado com sucesso.");
    }

    // List
    public List<Professor> getAllProfessores() {
        return new ArrayList<>(professores);
    }

    public Optional<Professor> getProfessorById(int id) {
        return professores.stream()
                .filter(p -> p.getId() == id)
                .findFirst();
    }

    public List<Professor> searchProfessoresByName(String name) {
        if (name == null || name.trim().isEmpty()) {
            return new ArrayList<>();
        }
        return professores.stream()
                .filter(p -> p.getNome().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    // Edit
    public void updateProfessor(Professor updatedProfessor) {
        if (updatedProfessor == null) {
            System.out.println("Erro: Professor atualizado não pode ser nulo.");
            return;
        }
        Optional<Professor> existingProfessorOpt = getProfessorById(updatedProfessor.getId());
        if (existingProfessorOpt.isPresent()) {
            Professor existingProfessor = existingProfessorOpt.get();
            existingProfessor.setNome(updatedProfessor.getNome());
            existingProfessor.setCelular(updatedProfessor.getCelular());
            existingProfessor.setCursos(updatedProfessor.getCursos());
            existingProfessor.setAlunoExercicio(updatedProfessor.getAlunoExercicio());
            System.out.println("Professor com ID " + updatedProfessor.getId() + " atualizado com sucesso.");
        } else {
            System.out.println("Erro: Professor com ID " + updatedProfessor.getId() + " não encontrado para atualização.");
        }
    }

    // Delete
    public void deleteProfessor(int id) {
        boolean removed = professores.removeIf(p -> p.getId() == id);
        if (removed) {
            System.out.println("Professor com ID " + id + " removido com sucesso.");
        } else {
            System.out.println("Erro: Professor com ID " + id + " não encontrado para remoção.");
        }
    }
}
