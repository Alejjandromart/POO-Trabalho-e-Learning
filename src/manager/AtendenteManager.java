package manager;

import model.Atendente;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AtendenteManager {
    private List<Atendente> atendentes;

    public AtendenteManager() {
        this.atendentes = new ArrayList<>();
    }

    // Create
    public void addAtendente(Atendente atendente) {
        if (atendente == null) {
            System.out.println("Erro: Atendente não pode ser nulo.");
            return;
        }
        if (atendente.getNome() == null || atendente.getNome().trim().isEmpty()) {
            System.out.println("Erro: Nome do atendente não pode ser vazio.");
            return;
        }
        if (getAtendenteById(atendente.getId()).isPresent()) {
            System.out.println("Erro: Atendente com ID " + atendente.getId() + " já existe.");
            return;
        }
        this.atendentes.add(atendente);
        System.out.println("Atendente " + atendente.getNome() + " adicionado com sucesso.");
    }

    // List
    public List<Atendente> getAllAtendentes() {
        return new ArrayList<>(atendentes);
    }

    public Optional<Atendente> getAtendenteById(int id) {
        return atendentes.stream()
                .filter(a -> a.getId() == id)
                .findFirst();
    }

    public List<Atendente> searchAtendentesByName(String name) {
        if (name == null || name.trim().isEmpty()) {
            return new ArrayList<>();
        }
        return atendentes.stream()
                .filter(a -> a.getNome().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    // Edit
    public void updateAtendente(Atendente updatedAtendente) {
        if (updatedAtendente == null) {
            System.out.println("Erro: Atendente atualizado não pode ser nulo.");
            return;
        }
        Optional<Atendente> existingAtendenteOpt = getAtendenteById(updatedAtendente.getId());
        if (existingAtendenteOpt.isPresent()) {
            Atendente existingAtendente = existingAtendenteOpt.get();
            existingAtendente.setNome(updatedAtendente.getNome());
            existingAtendente.setFuncao(updatedAtendente.getFuncao());
            existingAtendente.setFone(updatedAtendente.getFone());
            existingAtendente.setHistorico(updatedAtendente.getHistorico());
            System.out.println("Atendente com ID " + updatedAtendente.getId() + " atualizado com sucesso.");
        } else {
            System.out.println("Erro: Atendente com ID " + updatedAtendente.getId() + " não encontrado para atualização.");
        }
    }

    // Delete
    public void deleteAtendente(int id) {
        boolean removed = atendentes.removeIf(a -> a.getId() == id);
        if (removed) {
            System.out.println("Atendente com ID " + id + " removido com sucesso.");
        } else {
            System.out.println("Erro: Atendente com ID " + id + " não encontrado para remoção.");
        }
    }
}
