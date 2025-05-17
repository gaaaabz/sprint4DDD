package fiap.tds.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.Objects;

public class Problema extends BaseEntities {
    private String descricao;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate data;
    private String id_passageiro;

    public Problema() {
    }

    public Problema(String descricao, LocalDate data, String id_passageiro) {
        this.descricao = descricao;
        this.data = data;
        this.id_passageiro = id_passageiro;
    }

    public String getId() {
        return id_passageiro;
    }

    public void setId(String id_passageiro) {
        this.id_passageiro = id_passageiro;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getId_passageiro() {
        return id_passageiro;
    }

    public void setId_passageiro(String id_passageiro) {
        this.id_passageiro = id_passageiro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Problema problema = (Problema) o;
        return Objects.equals(descricao, problema.descricao) && Objects.equals(data, problema.data) && Objects.equals(id_passageiro, problema.id_passageiro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(descricao, data, id_passageiro);
    }

    @Override
    public String toString() {
        return "Problema{" +
                "descricao='" + descricao + '\'' +
                ", data=" + data +
                ", id_passageiro='" + id_passageiro + '\'' +
                '}';
    }
}