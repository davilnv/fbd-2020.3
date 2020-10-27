package br.com.business;

import java.util.ArrayList;

import br.com.dao.DaoEstoque;
import br.com.model.Estoque;

public class BusinessEstoque implements IBusinessEstoque{
	private DaoEstoque daoEstoque;
	
	public BusinessEstoque() {
		daoEstoque = new DaoEstoque();
	}

	@Override
	public boolean registrar(Estoque estoque) {
		return daoEstoque.registrar(estoque);
	}

	@Override
	public int registros(int id) {
		return daoEstoque.registros(id);
	}

	@Override
	public ArrayList<Estoque> buscarEstoque(String cadastro, String alteracao) {
		return daoEstoque.buscarEstoque(cadastro, alteracao);
	}

}
