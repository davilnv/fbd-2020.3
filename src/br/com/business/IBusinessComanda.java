package br.com.business;

import br.com.exception.BusinessException;
import br.com.model.Comanda;

public interface IBusinessComanda {
	public boolean verificarCodico(String codigo);
	public Comanda salvar(Comanda comanda) throws BusinessException;
}
