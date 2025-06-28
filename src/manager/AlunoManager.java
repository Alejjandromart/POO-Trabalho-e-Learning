package manager;

import model.Aluno;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AlunoManager {
    private List<Aluno> alunos;

    public AlunoManager() {
        this.alunos = new ArrayList<>();
    }

    // Create
    public void addAluno(Aluno aluno) {
        if (aluno == null) {
            System.out.println("Erro: Aluno não pode ser nulo.");
            return;
        }
        if (aluno.getNome() == null || aluno.getNome().trim().isEmpty()) {
            System.out.println("Erro: Nome do aluno não pode ser vazio.");
            return;
        }
        if (getAlunoById(aluno.getId()).isPresent()) {
            System.out.println("Erro: Aluno com ID " + aluno.getId() + " já existe.");
            return;
        }
        this.alunos.add(aluno);
        System.out.println("Aluno " + aluno.getNome() + " adicionado com sucesso.");
    }

    // List
    public List<Aluno> getAllAlunos() {
        return new ArrayList<>(alunos); // Return a copy to prevent external modification
    }

    public Optional<Aluno> getAlunoById(int id) {
        return alunos.stream()
                .filter(a -> a.getId() == id)
                .findFirst();
    }

    public List<Aluno> searchAlunosByName(String name) {
        if (name == null || name.trim().isEmpty()) {
            return new ArrayList<>();
        }
        return alunos.stream()
                .filter(a -> a.getNome().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    // Edit
    public void updateAluno(Aluno updatedAluno) {
        if (updatedAluno == null) {
            System.out.println("Erro: Aluno atualizado não pode ser nulo.");
            return;
        }
        Optional<Aluno> existingAlunoOpt = getAlunoById(updatedAluno.getId());
        if (existingAlunoOpt.isPresent()) {
            Aluno existingAluno = existingAlunoOpt.get();
            existingAluno.setNome(updatedAluno.getNome());
            existingAluno.setCelular(updatedAluno.getCelular());
            existingAluno.setDataNasc(updatedAluno.getDataNasc());
            existingAluno.setAulaAtual(updatedAluno.getAulaAtual());
            existingAluno.setPontos(updatedAluno.getPontos());
            System.out.println("Aluno com ID " + updatedAluno.getId() + " atualizado com sucesso.");
        } else {
            System.out.println("Erro: Aluno com ID " + updatedAluno.getId() + " não encontrado para atualização.");
        }
    }

    // Delete
    public void deleteAluno(int id) {
        boolean removed = alunos.removeIf(a -> a.getId() == id);
        if (removed) {
            System.out.println("Aluno com ID " + id + " removido com sucesso.");
        } else {
            System.out.println("Erro: Aluno com ID " + id + " não encontrado para remoção.");
        }
    }

}
