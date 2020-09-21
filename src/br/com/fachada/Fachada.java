package br.com.fachada;

import java.util.ArrayList;

import br.com.business.BusinessUsuario;
import br.com.exception.BusinessException;
import br.com.model.Usuario;

public class Fachada implements IFachada{
	private BusinessUsuario businessUsuario = new BusinessUsuario();

	@Override
	public Usuario cadastrarUsuario(Usuario usuario) throws BusinessException {
		return this.businessUsuario.cadastrar(usuario);
	}

	@Override
	public ArrayList<Usuario> listarTodosUsuarios() {
		return this.businessUsuario.listarTodos();
	}

	@Override
	public boolean isCpf(String cpf) throws BusinessException {
		// TODO Auto-generated method stub
		return this.businessUsuario.isCpf(cpf);
	}

}
