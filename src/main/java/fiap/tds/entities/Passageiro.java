package fiap.tds.entities;


import fiap.tds.repositories.ProblemaRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;


public class Passageiro extends Usuario {
    private String telefone;


    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passageiro that = (Passageiro) o;
        return Objects.equals(telefone, that.telefone);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(telefone);
    }

    @Override
    public String toString() {
        return "Passageiro{" +
                "telefone='" + telefone + '\'' +
                '}';
    }

}