package br.com.iniflex.service;

import br.com.iniflex.model.FuncionarioModel;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

public class FuncionarioService {
    private static final BigDecimal FATOR_REAJUSTE = new BigDecimal("1.10");

    public void removerPorNome(List<FuncionarioModel> funcionarios, String nome) {
        funcionarios.removeIf(funcionario -> funcionario.getNome().equalsIgnoreCase(nome));
    }

    public void reajustarSalarios(List<FuncionarioModel> funcionarios) {
        funcionarios.forEach(funcionario -> {
            BigDecimal novoSalario = funcionario.getSalario().multiply(FATOR_REAJUSTE).setScale(2, RoundingMode.HALF_UP);
            funcionario.setSalario(novoSalario);
        });
    }

    public Map<String, List<FuncionarioModel>> agruparPorFuncao(List<FuncionarioModel> funcionarios) {
        return funcionarios.stream().collect(Collectors.groupingBy(FuncionarioModel::getFuncao));
    }

    public List<FuncionarioModel> buscarAniversariantes(List<FuncionarioModel> funcionarios, Set<Integer> meses) {
        return funcionarios.stream().filter(funcionario -> meses.contains(funcionario.getDataNascimento().getMonthValue())).toList();
    }

    public Optional<FuncionarioModel> buscarMaisVelho(List<FuncionarioModel> funcionarios) {
        return funcionarios.stream().min(Comparator.comparing(FuncionarioModel::getDataNascimento));
    }

    public List<FuncionarioModel> ordenarPorNome(List<FuncionarioModel> funcionarios) {
        return funcionarios.stream().sorted(Comparator.comparing(FuncionarioModel::getNome)).toList();
    }

    public BigDecimal calcularTotalSalarios(List<FuncionarioModel> funcionarios) {
        return funcionarios.stream().map(FuncionarioModel::getSalario).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal calcularSalariosMinimos(FuncionarioModel funcionario, BigDecimal salarioMinimo) {
        return funcionario.getSalario().divide(salarioMinimo, 2, RoundingMode.HALF_UP);
    }
}
