package br.com.fachada;

import java.text.ParseException;
import java.util.ArrayList;

import br.com.exception.BusinessException;
import br.com.model.Comanda;
import br.com.model.Estoque;
import br.com.model.Prato;
import br.com.model.Produto;
import br.com.model.Usuario;

public interface IFachada {
	public Usuario cadastrarUsuario(Usuario usuario) throws BusinessException;
	public ArrayList<Usuario> listarTodosUsuarios();
	public boolean isCpf(String cpf) throws BusinessException;
	public boolean verificarUsuario(Usuario usuario) throws BusinessException;
	public String pegarNomeUsuario(String login);
	public int pegarIdUsuario(String login, String senha);
	public boolean alterarNomeUsuario(String nome, int id) throws BusinessException; 
	public boolean alterarSenhaUsuario(String senha, int id) throws BusinessException; 
	
	public Prato cadastrarPrato(Prato prato) throws BusinessException;
	public Prato procurarPratoPorId(int id) throws BusinessException;
	public ArrayList<Prato> procurarPratoPorNome(String pesquisa) throws BusinessException;
	public ArrayList<Prato> listarTodosPratos();
	public Prato alterarPrato(Prato prato) throws BusinessException;
	public int retornarRegistrosSalvosPrato();
	
	public Produto cadastrarProduto(Produto produto) throws BusinessException;
	public Produto procurarProdutoPorId(int id) throws BusinessException;
	public ArrayList<Produto> procurarProdutoPorNome(String nome) throws BusinessException;
	public boolean alterarQuantidadeProduto(int novaQuantidade, int id) throws BusinessException;
	public ArrayList<Produto> listarTodosProdutos();
	public Produto alterarProduto(Produto produto) throws BusinessException;
	public int retornarRegistrosSalvosProduto();
	
	public boolean verificarCodicoComanda(String codigo);
	public Comanda salvarComanda(Comanda comanda) throws BusinessException;
	
	public boolean registrarEstoque(Estoque estoque);
	public int registrosUsuario(int id);
	public ArrayList<Estoque> buscarEstoque(String cadastro, String alteracao);
}
