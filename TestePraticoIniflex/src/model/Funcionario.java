package model;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//2 – Classe Funcionário que estenda a classe Pessoa, com os atributos: salário (BigDecimal) e função (String).
public class Funcionario extends Pessoa {

	private BigDecimal salario;
	private String funcao;

	public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
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

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	// 3.3 – Imprimir todos os funcionários com todas suas informações
	@Override
	public String toString() {
		DecimalFormatSymbols dfs = new DecimalFormatSymbols();
		dfs.setDecimalSeparator(',');
		dfs.setPerMill('.');
		DecimalFormat decimalFormat = new DecimalFormat("###,000.00", dfs);
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return ("Nome: " + this.getNome() + " - Data Nascimento: " + this.getDataNascimento().format(dateFormat)
				+ " - Salário: " + decimalFormat.format(this.getSalario()) + " - Função: " + this.getFuncao());
	}

}
