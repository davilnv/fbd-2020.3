package br.com.dao;

import java.util.ArrayList;

import br.com.model.Produto;

public interface IDaoProduto {
	public Produto cadastrar(Produto produto);
	public Produto procurarPorId(int id);
	public ArrayList<Produto> procurarPorNome(String nome);
}
