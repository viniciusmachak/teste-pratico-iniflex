package br.com.iniflex.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class FuncionarioModel extends PessoaModel {
    private BigDecimal salario;
    private final String funcao;

    public FuncionarioModel(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "salario=" + salario +
                ", funcao='" + funcao + '\'' +
                '}';
    }
}
