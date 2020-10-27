package br.com.model;

public class Prato {
	private int id;
	private String nome;
	private float preco;
	private String descricao;
	private float peso;
	
	public Prato() {}
	
	public Prato(String nome, float preco, String descricao, float peso) {
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
		this.peso = peso;
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

	@Override
	public String toString() {
		return "[ID: " + id + ", Nome: " + nome + ", Preço: " + preco + ", Peso: "
				+ peso + "]";
	}
	
}
