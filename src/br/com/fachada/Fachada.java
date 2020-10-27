package br.com.fachada;

import java.text.ParseException;
import java.util.ArrayList;

import br.com.business.BusinessComanda;
import br.com.business.BusinessEstoque;
import br.com.business.BusinessPrato;
import br.com.business.BusinessProduto;
import br.com.business.BusinessUsuario;
import br.com.exception.BusinessException;
import br.com.model.Comanda;
import br.com.model.Estoque;
import br.com.model.Prato;
import br.com.model.Produto;
import br.com.model.Usuario;

public class Fachada implements IFachada{
	private BusinessUsuario businessUsuario = new BusinessUsuario();
	private BusinessPrato businessPrato = new BusinessPrato();
	private BusinessProduto businessProduto = new BusinessProduto();
	private BusinessComanda businessComanda = new BusinessComanda();
	private BusinessEstoque businessEstoque = new BusinessEstoque();

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
	public boolean alterarNomeUsuario(String nome, int id) throws BusinessException {
		// TODO Auto-generated method stub
		return businessUsuario.alterarNome(nome, id);
	}

	@Override
	public boolean alterarSenhaUsuario(String senha, int id) throws BusinessException {
		// TODO Auto-generated method stub
		return businessUsuario.alterarSenha(senha, id);
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
	public ArrayList<Prato> listarTodosPratos() {
		return businessPrato.listarTodos();
	}
	
	@Override
	public Prato alterarPrato(Prato prato) throws BusinessException {
		return businessPrato.alterarPrato(prato);
	}
	
	@Override
	public int retornarRegistrosSalvosPrato() {
		return businessPrato.retornarRegistrosSalvos();
	}
	
	@Override
	public Produto cadastrarProduto(Produto produto) throws BusinessException {
		return businessProduto.cadastrar(produto);
	}

	@Override
	public Produto procurarProdutoPorId(int id) throws BusinessException{
		return businessProduto.procurarPorId(id);
	}

	@Override
	public ArrayList<Produto> procurarProdutoPorNome(String nome) throws BusinessException {
		return businessProduto.procurarPorNome(nome);
	}
	
	@Override
	public boolean alterarQuantidadeProduto(int novaQuantidade, int id) throws BusinessException {
		return businessProduto.alterarQuantidade(novaQuantidade, id);
	}
	
	@Override
	public ArrayList<Produto> listarTodosProdutos(){
		return businessProduto.listarTodos();
	}
	
	@Override
	public Produto alterarProduto(Produto produto) throws BusinessException {
		return businessProduto.alterarProduto(produto);
	}
	
	@Override
	public int retornarRegistrosSalvosProduto() {
		return businessProduto.retornarRegistrosSalvos();
	}

	@Override
	public boolean verificarCodicoComanda(String codigo){
		return businessComanda.verificarCodico(codigo);
	}

	@Override
	public Comanda salvarComanda(Comanda comanda) throws BusinessException {
		return businessComanda.salvar(comanda);
	}

	@Override
	public boolean registrarEstoque(Estoque estoque) {
		return businessEstoque.registrar(estoque);
	}

	@Override
	public int registrosUsuario(int id) {
		return businessEstoque.registros(id);
	}

	@Override
	public ArrayList<Estoque> buscarEstoque(String cadastro, String alteracao) {
		return businessEstoque.buscarEstoque(cadastro, alteracao);
	}

}
