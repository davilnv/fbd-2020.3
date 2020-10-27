package br.com.dao;

import java.text.ParseException;
import java.util.ArrayList;

import br.com.model.Estoque;

public interface IDaoEstoque {
	public boolean registrar(Estoque estoque);
	public int registros(int id);
	public ArrayList<Estoque> buscarEstoque(String cadastro, String alteracao) throws ParseException;
}
