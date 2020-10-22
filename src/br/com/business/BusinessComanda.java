package br.com.business;

import br.com.dao.DaoComanda;
import br.com.exception.BusinessException;
import br.com.exception.DaoException;
import br.com.model.Comanda;

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

	@Override
	public Comanda salvar(Comanda comanda) throws BusinessException {
		if (comanda.getMesa() > 0) {			
			if (!comanda.getProdutos().isEmpty() && !comanda.getProdutos().isEmpty()) {
				return daoComanda.salvar(comanda);
			} else {
				throw new BusinessException("Comanda não foi salva, adicione um produto ou prato.");
			}
		} else {
			throw new BusinessException("Comanda não foi salva, um mesa precisa ser selecinada");
		}
	}

}
