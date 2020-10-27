package br.com.business;

import java.text.ParseException;
import java.util.ArrayList;

import br.com.exception.BusinessException;
import br.com.model.Produto;

public interface IBusinessProduto {
	public Produto cadastrar(Produto produto) throws BusinessException;
	public Produto procurarPorId(int id) throws BusinessException;
	public ArrayList<Produto> procurarPorNome(String nome) throws BusinessException;
	public boolean alterarQuantidade(int novaQuantidade, int id) throws BusinessException;
	public ArrayList<Produto> listarTodos();
	public Produto alterarProduto(Produto produto) throws BusinessException;
	public int retornarRegistrosSalvos();
}
