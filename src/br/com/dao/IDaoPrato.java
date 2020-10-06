package br.com.dao;

import br.com.model.Prato;

public interface IDaoPrato {
	public Prato cadastrar(Prato prato);
	public Prato procurarPorId(int id);
}
