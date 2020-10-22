package br.com.dao;

import br.com.exception.DaoException;
import br.com.model.Comanda;

public interface IDaoComanda {
	public boolean verificarCodico(String codigo) throws DaoException;
	public Comanda salvar(Comanda comanda);
}
