package br.com.business;

import java.util.ArrayList;

import br.com.exception.BusinessException;
import br.com.model.Prato;

public interface IBusinessPrato {
	public Prato cadastrar(Prato prato) throws BusinessException;
	public Prato procurarPorId(int id) throws BusinessException;
	public ArrayList<Prato> procurarPorNome(String nome) throws BusinessException;
}
