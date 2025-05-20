package fiap.tds.entities;


import java.util.Objects;

public class Metro extends BaseEntities {
    private String rota;
    private String idMetro;
    private int linha;
    private String localAtual;

    public Metro() {
    }

    public Metro(String rota, String idMetro, int linha, String localAtual) {
        this.rota = rota;
        this.idMetro = idMetro;
        this.linha = linha;
        this.localAtual = localAtual;
    }

    public String getRota() {
        return rota;
    }

    public void setRota(String rota) {
        this.rota = rota;
    }

    public String getIdMetro() {
        return idMetro;
    }

    public void setIdMetro(String idMetro) {
        this.idMetro = idMetro;
    }

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public String getLocalAtual() {
        return localAtual;
    }

    public void setLocalAtual(String localAtual) {
        this.localAtual = localAtual;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Metro metro = (Metro) o;
        return linha == metro.linha && Objects.equals(rota, metro.rota) && Objects.equals(idMetro, metro.idMetro) && Objects.equals(localAtual, metro.localAtual);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rota, idMetro, linha, localAtual);
    }

    @Override
    public String toString() {
        return "Metro{" +
                "rota='" + rota + '\'' +
                ", idMetro='" + idMetro + '\'' +
                ", linha=" + linha +
                ", localAtual='" + localAtual + '\'' +
                '}';
    }
}