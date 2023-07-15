package controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Funcionario;

//3 – Deve conter uma classe Principal para executar as seguintes ações:
public class Principal {

	public static void main(String[] args) {
		List<Funcionario> listaFuncionarios = insereFuncionarios();

		// 3.2 – Remover o funcionário “João” da lista.
		removeFuncionarioPorNome(listaFuncionarios, "João");

		// 3.3 – Imprimir todos os funcionários com todas suas informações
		System.out.println("3.3");
		imprimeFuncionarios(listaFuncionarios);
		System.out.println("");

		// 3.4 Os funcionários receberam 10% de aumento de salário, atualizar a lista de
		// funcionários com novo valor.
		System.out.println("3.4");
		aplicarAumentoSalarioConjunto(listaFuncionarios, new BigDecimal(0.1));
		System.out.println("");

		// 3.5 – Agrupar os funcionários por função em um MAP, sendo a chave a “função”
		// e o valor a “lista de funcionários”.
		Map<String, List<Funcionario>> agrupado = agrupaPorFuncao(listaFuncionarios);

		// 3.6 – Imprimir os funcionários, agrupados por função.
		System.out.println("3.6");
		for (List<Funcionario> lista : agrupado.values()) {
			imprimeFuncionarios(lista);

		}
		System.out.println("");

		// 3.8 – Imprimir os funcionários que fazem aniversário no mês 10 e 12.
		System.out.println("3.8");
		imprimeFuncionarioMes(listaFuncionarios, 10);
		imprimeFuncionarioMes(listaFuncionarios, 12);
		System.out.println("");

		// 3.9 – Imprimir o funcionário com a maior idade, exibir os atributos: nome e
		// idade.
		System.out.println("3.9");
		imprimeFuncionarioMaisVelho(listaFuncionarios);
		System.out.println("");

		// 3.10 – Imprimir a lista de funcionários por ordem alfabética.
		System.out.println("3.10");
		listaFuncionarios.sort(new Comparator<Funcionario>() {

			@Override
			public int compare(Funcionario f1, Funcionario f2) {

				return f1.getNome().compareTo(f2.getNome());
			}
		});
		imprimeFuncionarios(listaFuncionarios);
		System.out.println("");

		// 3.11 – Imprimir o total dos salários dos funcionários.
		System.out.println("3.11");
		imprimeTotalSalario(listaFuncionarios);
		System.out.println("");

		// 3.12 – Imprimir quantos salários mínimos ganha cada funcionário, considerando
		// que o salário mínimo é R$1212.00.
		System.out.println("3.12");
		imprimeQtdSalarioMinimo(listaFuncionarios);
		System.out.println("");

	}

	// 3.1 – Inserir todos os funcionários, na mesma ordem e informações da tabela
	// acima.
	public static List<Funcionario> insereFuncionarios() {

		Funcionario f1 = new Funcionario("Maria", LocalDate.of(2000, 10, 18), BigDecimal.valueOf(2009.44), "Operador");
		Funcionario f2 = new Funcionario("João", LocalDate.of(1990, 05, 12), BigDecimal.valueOf(2284.38), "Operador");
		Funcionario f3 = new Funcionario("Caio", LocalDate.of(1961, 05, 02), BigDecimal.valueOf(9836.14),
				"Coordenador");
		Funcionario f4 = new Funcionario("Miguel", LocalDate.of(1988, 10, 14), BigDecimal.valueOf(19119.88), "Diretor");
		Funcionario f5 = new Funcionario("Alice", LocalDate.of(1995, 01, 05), BigDecimal.valueOf(2234.68),
				"Recepcionista");
		Funcionario f6 = new Funcionario("Heitor", LocalDate.of(1999, 11, 19), BigDecimal.valueOf(1582.72), "Operador");
		Funcionario f7 = new Funcionario("Arthur", LocalDate.of(1993, 03, 31), BigDecimal.valueOf(4071.84), "Contador");
		Funcionario f8 = new Funcionario("Laura", LocalDate.of(1994, 07, 8), BigDecimal.valueOf(3017.45), "Gerente");
		Funcionario f9 = new Funcionario("Heloisa", LocalDate.of(2003, 05, 24), BigDecimal.valueOf(1606.85),
				"Eletricista");
		Funcionario f10 = new Funcionario("Helena", LocalDate.of(1996, 9, 02), BigDecimal.valueOf(2799.93), "Gerente");
		return new ArrayList<Funcionario>(Arrays.asList(f1, f2, f3, f4, f5, f6, f7, f8, f9, f10));
	}

	// 3.2 – Remover o funcionário “João” da lista.
	public static Boolean removeFuncionarioPorNome(List<Funcionario> listaFuncionarios, String nome) {
		for (Funcionario funcionario : listaFuncionarios) {
			if (funcionario.getNome().equals(nome)) {
				return listaFuncionarios.remove(funcionario);
			}
		}
		return false;
	}

	// 3.3 – Imprimir todos os funcionários com todas suas informações
	public static void imprimeFuncionarios(List<Funcionario> listaFuncionarios) {
		for (Funcionario funcionario : listaFuncionarios) {
			System.out.println(funcionario.toString());
		}
	}

	// 3.4 Os funcionários receberam 10% de aumento de salário, atualizar a lista de
	// funcionários com novo valor.
	public static void aplicarAumentoSalarioConjunto(List<Funcionario> listaFuncionarios, BigDecimal porcentagem) {
		for (Funcionario funcionario : listaFuncionarios) {
			funcionario.setSalario(funcionario.getSalario().add(funcionario.getSalario().multiply(porcentagem)));
		}
	}

	// 3.5 – Agrupar os funcionários por função em um MAP, sendo a chave a “função”
	// e o valor a “lista de funcionários”.
	public static Map<String, List<Funcionario>> agrupaPorFuncao(List<Funcionario> listaFuncionarios) {
		Map<String, List<Funcionario>> agrupamento = new HashMap<>();
		for (Funcionario funcionario : listaFuncionarios) {
			if (agrupamento.get(funcionario.getFuncao()) == null) {
				List<Funcionario> lista = new ArrayList<>();
				lista.add(funcionario);
				agrupamento.put(funcionario.getFuncao(), lista);
			} else {
				agrupamento.get(funcionario.getFuncao()).add(funcionario);
			}
		}
		return agrupamento;
	}

	// 3.8 – Imprimir os funcionários que fazem aniversário no mês 10 e 12.
	public static void imprimeFuncionarioMes(List<Funcionario> listaFuncionarios, int mes) {
		for (Funcionario funcionario : listaFuncionarios) {
			if (funcionario.getDataNascimento().getMonth().getValue() == mes) {
				System.out.println(funcionario.toString());
			}
		}
	}

	// 3.9 – Imprimir o funcionário com a maior idade, exibir os atributos: nome e
	// idade.
	public static void imprimeFuncionarioMaisVelho(List<Funcionario> listaFuncionarios) {
		Funcionario funcionarioMaisVelho = listaFuncionarios.get(0);
		for (Funcionario funcionario : listaFuncionarios) {
			if (funcionario.getDataNascimento().isBefore(funcionarioMaisVelho.getDataNascimento())) {
				funcionarioMaisVelho = funcionario;
			}
		}
		System.out.println("Nome: " + funcionarioMaisVelho.getNome() + " Idade: "
				+ funcionarioMaisVelho.getDataNascimento().until(LocalDate.now()).getYears());
	}

	// 3.11 – Imprimir o total dos salários dos funcionários.
	public static void imprimeTotalSalario(List<Funcionario> listaFuncionarios) {
		BigDecimal totalSalario = new BigDecimal(0);
		for (Funcionario funcionario : listaFuncionarios) {
			totalSalario = totalSalario.add(funcionario.getSalario());
		}
		DecimalFormatSymbols dfs = new DecimalFormatSymbols();
		dfs.setDecimalSeparator(',');
		dfs.setPerMill('.');
		DecimalFormat decimalFormat = new DecimalFormat("###,000.00", dfs);
		System.out.println("Total dos salários : " + decimalFormat.format(totalSalario));
	}

	// 3.12 – Imprimir quantos salários mínimos ganha cada funcionário, considerando
	// que o salário mínimo é R$1212.00.
	public static void imprimeQtdSalarioMinimo(List<Funcionario> listaFuncionarios) {
		DecimalFormatSymbols dfs = new DecimalFormatSymbols();
		dfs.setDecimalSeparator(',');
		dfs.setPerMill('.');
		DecimalFormat decimalFormat = new DecimalFormat("###,##0.0#", dfs);
		for (Funcionario funcionario : listaFuncionarios) {
			BigDecimal qtdSalarioMinimo = funcionario.getSalario().divide(new BigDecimal(1212), RoundingMode.HALF_DOWN);
			System.out.println("Nome: " + funcionario.getNome() + " Quantidade Salarios Minimos: "
					+ decimalFormat.format(qtdSalarioMinimo));
		}
	}
}
