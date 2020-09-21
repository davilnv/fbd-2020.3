package br.com.business;

import java.util.ArrayList;

import br.com.dao.DaoUsuario;
import br.com.exception.BusinessException;
import br.com.exception.DaoException;
import br.com.model.Usuario;

public class BusinessUsuario implements IBusinessUsuario{
	private DaoUsuario daoUsuario;
	
	public BusinessUsuario() {
		daoUsuario = new DaoUsuario();
	}

	@Override
	public Usuario cadastrar(Usuario usuario) throws BusinessException{
		try {
			if (daoUsuario.isCpf(usuario.getCpf())) {
				throw new BusinessException("Este usuário já está cadastrado");
			}
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return daoUsuario.cadastrar(usuario);
	}

	@Override
	public ArrayList<Usuario> listarTodos() {
		return null;
	}

	@Override
	public boolean isCpf(String cpf) throws BusinessException {
		try {
			return this.daoUsuario.isCpf(cpf);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

}
