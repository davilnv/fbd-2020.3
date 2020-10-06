package br.com.dao;

import java.util.ArrayList;

import br.com.exception.DaoException;
import br.com.model.Usuario;

public interface IDaoUsuario {
	public Usuario cadastrar(Usuario usuario) throws DaoException;
	public ArrayList<Usuario> listarTodos();
	public boolean isCpf(String cpf) throws DaoException;
	public boolean verificarUsuario(Usuario usuario) throws DaoException;
}
