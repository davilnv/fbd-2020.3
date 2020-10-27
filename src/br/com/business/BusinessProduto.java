package br.com.business;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import br.com.dao.DaoProduto;
import br.com.exception.BusinessException;
import br.com.model.Produto;

public class BusinessProduto implements IBusinessProduto{
	private DaoProduto daoProduto;
	
	public BusinessProduto() {
		daoProduto = new DaoProduto();
	}

	@Override
	public Produto cadastrar(Produto produto) throws BusinessException {
		if (produto.getPreco() <= 0 || produto.getNome().trim().equals("") || produto.getDescricao().trim().equals("") || produto.getPeso() <= 0 || produto.getQuantidade() <= 0) {
			throw new BusinessException("Todos os campos devem ser preenchidos.");
		}
		Date data = new Date();
		if (produto.getValidade().after(data)) {			
			return daoProduto.cadastrar(produto);
		} else {
			throw new BusinessException("A data da validade é inferior a data de hoje.");
		}
	}

	@Override
	public Produto procurarPorId(int id){
		return daoProduto.procurarPorId(id);
	}

	@Override
	public ArrayList<Produto> procurarPorNome(String nome) throws BusinessException {
		if (nome.trim().equals("")) {
			throw new BusinessException("Barra de pesquisa em branco, digite o que deseja pesquisar.");
		}
		return daoProduto.procurarPorNome(nome);
	}

	@Override
	public boolean alterarQuantidade(int novaQuantidade, int id) throws BusinessException {
		if (novaQuantidade > 0 && id > 0) {
			return daoProduto.alterarQuantidade(novaQuantidade, id);
		} else {
			throw new BusinessException("Quantidade não pode ser menor ou igual a zero.");
		}
		
	}

	@Override
	public ArrayList<Produto> listarTodos(){
		return daoProduto.listarTodos();
	}

	@Override
	public Produto alterarProduto(Produto produto) throws BusinessException {
		if (produto.getPreco() <= 0 || produto.getNome().trim().equals("") || produto.getDescricao().trim().equals("") || produto.getPeso() <= 0 || produto.getQuantidade() <= 0) {
			throw new BusinessException("Todos os campos devem ser preenchidos.");
		}
		Date data = new Date();
		if (produto.getValidade().after(data)) {			
			return daoProduto.alterarProduto(produto);
		} else {
			throw new BusinessException("A data da validade é inferior a data de hoje.");
		}
	}

	@Override
	public int retornarRegistrosSalvos() {
		return daoProduto.retornarRegistrosSalvos();
	}

}
