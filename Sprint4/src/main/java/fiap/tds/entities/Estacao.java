package fiap.tds.entities;


import java.util.Objects;

public class Estacao extends BaseEntities {
    private String nome;
    private String linha;
    private boolean aberta;

    public Estacao() {
    }

    public Estacao(String nome, String linha, boolean aberta) {
        this.nome = nome;
        this.linha = linha;
        this.aberta = aberta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLinha() {
        return linha;
    }

    public void setLinha(String linha) {
        this.linha = linha;
    }

    public boolean isAberta() {
        return aberta;
    }

    public void setAberta(boolean aberta) {
        this.aberta = aberta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estacao estacao = (Estacao) o;
        return aberta == estacao.aberta && Objects.equals(nome, estacao.nome) && Objects.equals(linha, estacao.linha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, linha, aberta);
    }

    @Override
    public String toString() {
        return "Estacao{" +
                "nome='" + nome + '\'' +
                ", linha='" + linha + '\'' +
                ", aberta=" + aberta +
                '}';
    }
}