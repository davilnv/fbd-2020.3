package br.com.dao;

import java.text.ParseException;
import java.util.ArrayList;

import br.com.model.Produto;

public interface IDaoProduto {
	public Produto cadastrar(Produto produto);
	public Produto procurarPorId(int id);
	public ArrayList<Produto> procurarPorNome(String nome);
	public boolean alterarQuantidade(int novaQuantidade, int id);
	public ArrayList<Produto> listarTodos();
	public Produto alterarProduto(Produto produto);
	public int retornarRegistrosSalvos();
}
