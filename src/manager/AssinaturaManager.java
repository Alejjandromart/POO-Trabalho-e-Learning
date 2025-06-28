package manager;

import model.Assinatura;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AssinaturaManager {
    private List<Assinatura> assinaturas;

    public AssinaturaManager() {
        this.assinaturas = new ArrayList<>();
    }

    // Create
    public void addAssinatura(Assinatura assinatura) {
        if (assinatura == null) {
            System.out.println("Erro: Assinatura não pode ser nula.");
            return;
        }
        if (assinatura.getNomePlano() == null || assinatura.getNomePlano().trim().isEmpty()) {
            System.out.println("Erro: Nome do plano da assinatura não pode ser vazio.");
            return;
        }
        if (getAssinaturaById(assinatura.getIdAssinatura()).isPresent()) {
            System.out.println("Erro: Assinatura com ID " + assinatura.getIdAssinatura() + " já existe.");
            return;
        }
        this.assinaturas.add(assinatura);
        System.out.println("Assinatura com ID " + assinatura.getIdAssinatura() + " adicionada com sucesso.");
    }

    // List
    public List<Assinatura> getAllAssinaturas() {
        return new ArrayList<>(assinaturas);
    }

    public Optional<Assinatura> getAssinaturaById(int id) {
        return assinaturas.stream()
                .filter(a -> a.getIdAssinatura() == id)
                .findFirst();
    }

    public List<Assinatura> getAssinaturasByAlunoId(int alunoId) {
        return assinaturas.stream()
                .filter(a -> a.getIdAluno() == alunoId)
                .collect(Collectors.toList());
    }

    // Edit
    public void updateAssinatura(Assinatura updatedAssinatura) {
        if (updatedAssinatura == null) {
            System.out.println("Erro: Assinatura atualizada não pode ser nula.");
            return;
        }
        Optional<Assinatura> existingAssinaturaOpt = getAssinaturaById(updatedAssinatura.getIdAssinatura());
        if (existingAssinaturaOpt.isPresent()) {
            Assinatura existingAssinatura = existingAssinaturaOpt.get();
            existingAssinatura.setIdAluno(updatedAssinatura.getIdAluno());
            existingAssinatura.setNomePlano(updatedAssinatura.getNomePlano());
            existingAssinatura.setValorPlanoAnual(updatedAssinatura.getValorPlanoAnual());
            existingAssinatura.setNotaFiscal(updatedAssinatura.getNotaFiscal());
            existingAssinatura.setIdVia(updatedAssinatura.getIdVia());
            System.out.println("Assinatura com ID " + updatedAssinatura.getIdAssinatura() + " atualizada com sucesso.");
        } else {
            System.out.println("Erro: Assinatura com ID " + updatedAssinatura.getIdAssinatura() + " não encontrada para atualização.");
        }
    }

    // Delete
    public void deleteAssinatura(int id) {
        boolean removed = assinaturas.removeIf(a -> a.getIdAssinatura() == id);
        if (removed) {
            System.out.println("Assinatura com ID " + id + " removida com sucesso.");
        } else {
            System.out.println("Erro: Assinatura com ID " + id + " não encontrada para remoção.");
        }
    }
}
