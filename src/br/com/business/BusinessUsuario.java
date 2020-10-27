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
			if(usuario.getNome().trim().equals("") || usuario.getSenha().trim().equals("") || usuario.getLogin().trim().equals("") || usuario.getCpf().trim().equals("")) {
				throw new BusinessException("Todos os campos devem ser preenchidos");
			} else if (daoUsuario.isCpf(usuario.getCpf())) {
				throw new BusinessException("Este usuário já está cadastrado");
			}
			
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return daoUsuario.cadastrar(usuario);
	}

	@Override
	public ArrayList<Usuario> listarTodos() {
		return daoUsuario.listarTodos();
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

	@Override
	public boolean verificarUsuario(Usuario usuario) throws BusinessException{
		try {
			if (usuario.getLogin().trim().equals("") || usuario.getSenha().trim().equals("")) {
				throw new BusinessException("Todos os campos devem ser preenchidos");
			}
			return daoUsuario.verificarUsuario(usuario);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public String pegarNome(String login) {
		return daoUsuario.pegarNome(login);
	}

	@Override
	public int pegarId(String login, String senha) {
		return daoUsuario.pegarId(login, senha);
	}

	@Override
	public boolean alterarNome(String nome, int id) throws BusinessException {
		if (nome.trim().equals("")) {
			throw new BusinessException("Todos os campos devem ser preenchidos");
		}
		return daoUsuario.alterarNome(nome, id);
	}

	@Override
	public boolean alterarSenha(String senha, int id) throws BusinessException {
		if (senha.trim().equals("")) {
			throw new BusinessException("Todos os campos devem ser preenchidos");
		}
		return daoUsuario.alterarSenha(senha, id);
	}

}
