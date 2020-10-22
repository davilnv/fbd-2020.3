package br.com.dao;

import java.util.ArrayList;

import br.com.model.Prato;

public interface IDaoPrato {
	public Prato cadastrar(Prato prato);
	public Prato procurarPorId(int id);
	public ArrayList<Prato> procurarPorNome(String nome);
}
