package br.com.business;

import java.util.ArrayList;

import br.com.model.Estoque;

public interface IBusinessEstoque {
	public boolean registrar(Estoque estoque);
	public int registros(int id);
	public ArrayList<Estoque> buscarEstoque(String cadastro, String alteracao);
}
