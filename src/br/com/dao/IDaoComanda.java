package br.com.dao;

import br.com.exception.DaoException;

public interface IDaoComanda {
	public boolean verificarCodico(String codigo) throws DaoException;
}
