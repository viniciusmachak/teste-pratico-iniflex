package br.com.iniflex;

import br.com.iniflex.model.FuncionarioModel;
import br.com.iniflex.view.FuncionarioPrinter;
import br.com.iniflex.service.FuncionarioService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    private static final BigDecimal SALARIO_MINIMO = new BigDecimal("1212.00");

    public static void main(String[] args) {
        List<FuncionarioModel> funcionarios = criarFuncionarios();

        FuncionarioService funcionarioService = new FuncionarioService();
        FuncionarioPrinter funcionarioPrinter = new FuncionarioPrinter();

        funcionarioService.removerPorNome(funcionarios, "João");

        funcionarioPrinter.imprimirTitulo("FUNCIONÁRIOS");
        funcionarioPrinter.imprimirTodos(funcionarios);

        funcionarioService.reajustarSalarios(funcionarios);

        Map<String, List<FuncionarioModel>> funcionariosPorFuncao = funcionarioService.agruparPorFuncao(funcionarios);

        funcionarioPrinter.imprimirTitulo("FUNCIONÁRIOS AGRUPADOS POR FUNÇÃO");
        funcionarioPrinter.imprimirPorFuncao(funcionariosPorFuncao);

        List<FuncionarioModel> aniversariantes = funcionarioService.buscarAniversariantes(funcionarios, Set.of(10, 12));

        funcionarioPrinter.imprimirTitulo("ANIVERSARIANTES DOS MESES 10 E 12");
        funcionarioPrinter.imprimirTodos(aniversariantes);

        funcionarioPrinter.imprimirTitulo("FUNCIONÁRIO COM MAIOR IDADE");

        funcionarioService.buscarMaisVelho(funcionarios).ifPresent(funcionarioPrinter::imprimirNomeEIdade);

        List<FuncionarioModel> funcionariosOrdenados = funcionarioService.ordenarPorNome(funcionarios);

        funcionarioPrinter.imprimirTitulo("FUNCIONÁRIOS EM ORDEM ALFABÉTICA");
        funcionarioPrinter.imprimirTodos(funcionariosOrdenados);

        BigDecimal totalSalarios = funcionarioService.calcularTotalSalarios(funcionarios);

        funcionarioPrinter.imprimirTitulo("TOTAL DOS SALÁRIOS");
        funcionarioPrinter.imprimirTotalSalarios(totalSalarios);

        funcionarioPrinter.imprimirTitulo("SALÁRIOS MÍNIMOS POR FUNCIONÁRIO");

        funcionarios.forEach(funcionario -> {
            BigDecimal quantidadeSalariosMinimos = funcionarioService.calcularSalariosMinimos(funcionario,SALARIO_MINIMO);

            funcionarioPrinter.imprimirSalariosMinimos(funcionario,quantidadeSalariosMinimos);
        });
    }

    private static List<FuncionarioModel> criarFuncionarios() {

        List<FuncionarioModel> funcionarios = new ArrayList<>();

        funcionarios.add(new FuncionarioModel("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));

        funcionarios.add(new FuncionarioModel("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));

        funcionarios.add(new FuncionarioModel("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"));

        funcionarios.add(new FuncionarioModel("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));

        funcionarios.add(new FuncionarioModel("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));

        funcionarios.add(new FuncionarioModel("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"
        ));

        funcionarios.add(new FuncionarioModel("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));

        funcionarios.add(new FuncionarioModel("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));

        funcionarios.add(new FuncionarioModel("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));

        funcionarios.add(new FuncionarioModel("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));

        return funcionarios;
    }
}