package br.com.business;

import br.com.dao.DaoPrato;
import br.com.exception.BusinessException;
import br.com.model.Prato;

public class BusinessPrato implements IBusinessPrato{
	private DaoPrato daoPrato;
	
	public BusinessPrato() {
		daoPrato = new DaoPrato();
	}

	@Override
	public Prato cadastrar(Prato prato) throws BusinessException {
		if (prato.getPreco() == 0) {
			throw new BusinessException("O produto não pode ser cadastrado com preço R$ 0.0");
		}
		return daoPrato.cadastrar(prato);
	}

	@Override
	public Prato procurarPorId(int id) throws BusinessException{
		if (id == 0) {
			throw new BusinessException("O produto não pode ser cadastrado com preço R$ 0.0");
		}
		return daoPrato.procurarPorId(id);
	}

}
