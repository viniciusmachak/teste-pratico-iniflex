package br.com.iniflex.view;

import br.com.iniflex.model.FuncionarioModel;
import br.com.iniflex.util.FormatadorUtil;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Map;

public class FuncionarioPrinter {

    public void imprimir(FuncionarioModel funcionario) {
        System.out.printf("Nome: %s, Data de nascimento: %s, Salário: %s, Função: %s\n", funcionario.getNome(), FormatadorUtil.formatarData(funcionario.getDataNascimento()), FormatadorUtil.formatarNumero(funcionario.getSalario()), funcionario.getFuncao());
    }

    public void imprimirTodos(List<FuncionarioModel> funcionarios) {
        funcionarios.forEach(this::imprimir);
    }

    public void imprimirPorFuncao(Map<String, List<FuncionarioModel>> funcionariosPorFuncao) {

        funcionariosPorFuncao.forEach((funcao, funcionarios) -> {
            System.out.println("Função: " + funcao);

            funcionarios.forEach(funcionario ->
                    System.out.println(" - " + funcionario.getNome())
            );

            System.out.println();
        });
    }

    public void imprimirNomeEIdade(FuncionarioModel funcionario) {
        int idade = Period.between(funcionario.getDataNascimento(), LocalDate.now()).getYears();

        System.out.printf("Nome: %s, Idade: %d anos\n", funcionario.getNome(), idade);
    }

    public void imprimirTotalSalarios(BigDecimal totalSalarios) {
        System.out.println("Total: " + FormatadorUtil.formatarNumero(totalSalarios));
    }

    public void imprimirSalariosMinimos(FuncionarioModel funcionario, BigDecimal quantidade) {
        System.out.printf("%s: %s salários mínimos%n", funcionario.getNome(), FormatadorUtil.formatarNumero(quantidade));
    }

    public void imprimirTitulo(String titulo) {
        System.out.println();
        System.out.println("----------------------------------------");
        System.out.println(titulo);
        System.out.println("----------------------------------------");
    }
}