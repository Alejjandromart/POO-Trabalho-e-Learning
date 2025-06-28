package model;

import java.util.Objects;

public class Assinatura {
    private int idAssinatura;
    private int idAluno;
    private String nomePlano;
    private double valorPlanoAnual;
    private String notaFiscal;
    private String idVia;

    public Assinatura(int idAssinatura, int idAluno, String nomePlano, double valorPlanoAnual, String notaFiscal, String idVia) {
        this.idAssinatura = idAssinatura;
        this.idAluno = idAluno;
        this.nomePlano = nomePlano;
        this.valorPlanoAnual = valorPlanoAnual;
        this.notaFiscal = notaFiscal;
        this.idVia = idVia;
    }

    public int getIdAssinatura() {
        return idAssinatura;
    }

    public void setIdAssinatura(int idAssinatura) {
        this.idAssinatura = idAssinatura;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public String getNomePlano() {
        return nomePlano;
    }

    public void setNomePlano(String nomePlano) {
        this.nomePlano = nomePlano;
    }

    public double getValorPlanoAnual() {
        return valorPlanoAnual;
    }

    public void setValorPlanoAnual(double valorPlanoAnual) {
        this.valorPlanoAnual = valorPlanoAnual;
    }

    public String getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(String notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

    public String getIdVia() {
        return idVia;
    }

    public void setIdVia(String idVia) {
        this.idVia = idVia;
    }

    // These methods would typically interact with a data store,
    // but for this base structure, they print messages.
    public void incluirPlano(Assinatura assinatura) {
        System.out.println("Assinatura " + assinatura.getIdAssinatura() + " para aluno " + assinatura.getIdAluno() + " (" + assinatura.getNomePlano() + ") incluída.");
    }

    public void editarPlano(Assinatura assinatura) {
        System.out.println("Assinatura " + assinatura.getIdAssinatura() + " para aluno " + assinatura.getIdAluno() + " (" + assinatura.getNomePlano() + ") editada.");
    }

    public void excluirPlano(int idAssinatura) {
        System.out.println("Assinatura " + idAssinatura + " excluída.");
    }

    public void imprimirPlano(int idAssinatura) {
        System.out.println("Imprimindo detalhes para Assinatura " + idAssinatura + ".");
        // In a real app, this would fetch and display details
    }

    public void emitirFatura(int idAssinatura) {
        System.out.println("Emitindo fatura para Assinatura " + idAssinatura + ".");
        // In a real app, this would generate and store a fatura
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Assinatura that = (Assinatura) o;
        return idAssinatura == that.idAssinatura;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAssinatura);
    }

    @Override
    public String toString() {
        return "Assinatura{" +
               "idAssinatura=" + idAssinatura +
               ", idAluno=" + idAluno +
               ", nomePlano='" + nomePlano + '\'' +
               ", valorPlanoAnual=" + valorPlanoAnual +
               ", notaFiscal='" + notaFiscal + '\'' +
               ", idVia='" + idVia + '\'' +
               '}';
    }
}
