package br.com.business;

import br.com.dao.DaoComanda;
import br.com.exception.BusinessException;
import br.com.exception.DaoException;

public class BusinessComanda implements IBusinessComanda{
	private DaoComanda daoComanda;
	
	public BusinessComanda() {
		daoComanda = new DaoComanda();
	}

	@Override
	public boolean verificarCodico(String codigo){
		try {
			return daoComanda.verificarCodico(codigo);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
