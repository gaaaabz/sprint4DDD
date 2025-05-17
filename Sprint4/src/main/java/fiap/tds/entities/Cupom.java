package fiap.tds.entities;


import java.time.LocalDate;
import java.util.Objects;

public class Cupom extends BaseEntities {
    private String id;
    private LocalDate data;
    private String codigo;
    private String descricao;
    private boolean ativo;
    private String idCliente;

    public Cupom() {
    }

    public Cupom(String id, LocalDate data, String codigo, String descricao, boolean ativo, String idCliente) {
        this.id = id;
        this.data = data;
        this.codigo = codigo;
        this.descricao = descricao;
        this.ativo = ativo;
        this.idCliente = idCliente;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cupom cupom = (Cupom) o;
        return ativo == cupom.ativo && Objects.equals(id, cupom.id) && Objects.equals(data, cupom.data) && Objects.equals(codigo, cupom.codigo) && Objects.equals(descricao, cupom.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, data, codigo, descricao, ativo);
    }
}

