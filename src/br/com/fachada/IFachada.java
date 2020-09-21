package br.com.fachada;

import java.util.ArrayList;

import br.com.exception.BusinessException;
import br.com.model.Usuario;

public interface IFachada {
	public Usuario cadastrarUsuario(Usuario usuario) throws BusinessException;
	public ArrayList<Usuario> listarTodosUsuarios();
	public boolean isCpf(String cpf) throws BusinessException;
}
