package br.com.business;

import java.text.ParseException;

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
		if (produto.getPreco() == 0) {
			throw new BusinessException("O produto não pode ser cadastrado com preço R$ 0.0");
		}
		return daoProduto.cadastrar(produto);
	}

	@Override
	public Produto procurar(int id) throws BusinessException, ParseException {
		if (id == 0) {
			throw new BusinessException("Número de id é 0, não foi possível encontrar o produto");
		}
		return daoProduto.procurarPorId(id);
	}

}
