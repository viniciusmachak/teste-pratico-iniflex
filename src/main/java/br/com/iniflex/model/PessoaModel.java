package br.com.iniflex.model;

import java.time.LocalDate;
import java.util.Objects;

public class PessoaModel {
    private final String nome;
    private final LocalDate dataNascimento;

    public PessoaModel(String nome, LocalDate dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PessoaModel that)) return false;
        return Objects.equals(nome, that.nome) && Objects.equals(dataNascimento, that.dataNascimento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, dataNascimento);
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                '}';
    }
}
