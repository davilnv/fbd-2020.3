package br.com.business;

import br.com.exception.BusinessException;
import br.com.model.Prato;

public interface IBusinessPrato {
	public Prato cadastrar(Prato prato) throws BusinessException;
	public Prato procurarPorId(int id) throws BusinessException;
}
