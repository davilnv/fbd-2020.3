package br.com.business;

import java.util.ArrayList;

import br.com.exception.BusinessException;
import br.com.exception.DaoException;
import br.com.model.Usuario;

public interface IBusinessUsuario {
	public Usuario cadastrar(Usuario usuario) throws BusinessException;
	public ArrayList<Usuario> listarTodos();
	public boolean isCpf(String cpf) throws BusinessException;
}
