package br.com.dao;

import java.text.ParseException;

import br.com.model.Produto;

public interface IDaoProduto {
	public Produto cadastrar(Produto produto);
	public Produto procurarPorId(int id) throws ParseException;
}
