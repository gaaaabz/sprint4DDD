package fiap.tds.entities;


import java.util.Objects;

public class Vagao extends BaseEntities {
    private String idVagao;

    public Vagao() {
    }

    public Vagao(String idVagao) {
        this.idVagao = idVagao;
    }

    public String getIdVagao() {
        return idVagao;
    }

    public void setIdVagao(String idVagao) {
        this.idVagao = idVagao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vagao vagao = (Vagao) o;
        return Objects.equals(idVagao, vagao.idVagao);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idVagao);
    }

    @Override
    public String toString() {
        return "Vagao{" +
                "idVagao='" + idVagao + '\'' +
                '}';
    }
}