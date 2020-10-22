package br.com.fachada;

import java.util.ArrayList;

import br.com.business.BusinessComanda;
import br.com.business.BusinessPrato;
import br.com.business.BusinessProduto;
import br.com.business.BusinessUsuario;
import br.com.exception.BusinessException;
import br.com.model.Comanda;
import br.com.model.Prato;
import br.com.model.Produto;
import br.com.model.Usuario;

public class Fachada implements IFachada{
	private BusinessUsuario businessUsuario = new BusinessUsuario();
	private BusinessPrato businessPrato = new BusinessPrato();
	private BusinessProduto businessProduto = new BusinessProduto();
	private BusinessComanda businessComanda = new BusinessComanda();

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
		return this.businessUsuario.isCpf(cpf);
	}

	@Override
	public boolean verificarUsuario(Usuario usuario) throws BusinessException {
		return businessUsuario.verificarUsuario(usuario);
	}
	
	@Override
	public String pegarNomeUsuario(String login) {
		return businessUsuario.pegarNome(login);
	}
	
	@Override
	public int pegarIdUsuario(String login, String senha) {
		return businessUsuario.pegarId(login, senha);
	}

	@Override
	public Prato cadastrarPrato(Prato prato) throws BusinessException {
		return businessPrato.cadastrar(prato);
	}

	@Override
	public Prato procurarPratoPorId(int id) throws BusinessException {
		return businessPrato.procurarPorId(id);
	}
	
	public ArrayList<Prato> procurarPratoPorNome(String pesquisa) throws BusinessException {
		return businessPrato.procurarPorNome(pesquisa);
	}

	@Override
	public Produto cadastrarProduto(Produto produto) throws BusinessException {
		return businessProduto.cadastrar(produto);
	}

	@Override
	public Produto procurarProdutoPorId(int id) throws BusinessException{
		return businessProduto.procurar(id);
	}

	@Override
	public ArrayList<Produto> procurarProdutoPorNome(String nome) throws BusinessException {
		return businessProduto.procurarPorNome(nome);
	}

	@Override
	public boolean verificarCodicoComanda(String codigo){
		return businessComanda.verificarCodico(codigo);
	}

	@Override
	public Comanda salvarComanda(Comanda comanda) throws BusinessException {
		return businessComanda.salvar(comanda);
	}

	

}
