package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Atendente {
    private int id;
    private String nome;
    private String funcao;
    private String fone;
    private List<String> historico; // list of pairs: idUsuario + string

    public Atendente(int id, String nome, String funcao, String fone) {
        this.id = id;
        this.nome = nome;
        this.funcao = funcao;
        this.fone = fone;
        this.historico = new ArrayList<>();
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

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public List<String> getHistorico() {
        return historico;
    }

    public void setHistorico(List<String> historico) {
        this.historico = historico;
    }

    public void efetuarAssinatura(int id) {
        String log = "Atendente " + nome + " efetuou assinatura para o usuário ID: " + id;
        historico.add(log);
        System.out.println(log);
    }

    public void atenderUsuario(int id) {
        String log = "Atendente " + nome + " atendeu o usuário ID: " + id;
        historico.add(log);
        System.out.println(log);
    }

    public void acertarCadastro(int id) {
        String log = "Atendente " + nome + " acertou o cadastro do usuário ID: " + id;
        historico.add(log);
        System.out.println(log);
    }

    public void resolverPagamento(int id) {
        String log = "Atendente " + nome + " resolveu pagamento para o usuário ID: " + id;
        historico.add(log);
        System.out.println(log);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Atendente atendente = (Atendente) o;
        return id == atendente.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Atendente{" +
               "id=" + id +
               ", nome='" + nome + '\'' +
               ", funcao='" + funcao + '\'' +
               ", fone='" + fone + '\'' +
               ", historico=" + historico.size() + " entries" +
               '}';
    }
}
