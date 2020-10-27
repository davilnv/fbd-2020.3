package br.com.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Produto {
	private int id;
	private String nome;
	private float preco;
	private String descricao;
	private float peso;
	private Date validade;
	private int quantidade;
	
	public Produto() {}
	
	public Produto(String nome, float preco, String descricao, float peso, Date validade, int quantidade) {
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
		this.peso = peso;
		this.validade = validade;
		this.quantidade = quantidade;
	}
	
	public String converterDataString(Date data) {
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		return f.format(data);
	}
	
	public Date converterStringData(String data) throws ParseException {
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		return f.parse(data);
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public Date getValidade() {
		return validade;
	}

	public void setValidade(Date validade) {
		this.validade = validade;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "[ID: " + id + ", Nome: " + nome + ", Preço: " + preco + ", Peso: "
				+ peso + ", Validade: " + converterDataString(validade) + ", Quantidade: " + quantidade + "]";
	}
	
}
