package br.com.business;

import java.util.ArrayList;

import br.com.exception.BusinessException;
import br.com.model.Produto;

public interface IBusinessProduto {
	public Produto cadastrar(Produto produto) throws BusinessException;
	public Produto procurar(int id) throws BusinessException;
	public ArrayList<Produto> procurarPorNome(String nome) throws BusinessException;
}
