package br.com.fachada;

import java.text.ParseException;
import java.util.ArrayList;

import br.com.exception.BusinessException;
import br.com.exception.DaoException;
import br.com.model.Prato;
import br.com.model.Produto;
import br.com.model.Usuario;

public interface IFachada {
	public Usuario cadastrarUsuario(Usuario usuario) throws BusinessException;
	public ArrayList<Usuario> listarTodosUsuarios();
	public boolean isCpf(String cpf) throws BusinessException;
	public boolean verificarUsuario(Usuario usuario) throws BusinessException;
	public Prato cadastrarPrato(Prato prato) throws BusinessException;
	public Produto cadastrarProduto(Produto produto) throws BusinessException;
	public Produto procurarProdutoPorId(int id) throws BusinessException, ParseException;
	public Prato procurarPratoPorId(int id) throws BusinessException;
	public boolean verificarCodicoComanda(String codigo);
}
