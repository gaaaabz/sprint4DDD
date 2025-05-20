package fiap.tds.entities;


import java.util.Objects;

public class Linha extends BaseEntities {
    private String nome;
    private boolean operando;


    public Linha() {
    }

    public Linha(String nome, boolean operando) {
        this.nome = nome;
        this.operando = operando;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isOperando() {
        return operando;
    }

    public void setOperando(boolean operando) {
        this.operando = operando;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Linha linha = (Linha) o;
        return operando == linha.operando && Objects.equals(nome, linha.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, operando);
    }

    @Override
    public String toString() {
        return "Linha{" +
                "nome='" + nome + '\'' +
                ", operando=" + operando +
                '}';
    }
}