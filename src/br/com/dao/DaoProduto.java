package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import br.com.connection.SqlConnection;
import br.com.model.Produto;
import br.com.model.Usuario;
import br.com.util.SqlUtil;

public class DaoProduto implements IDaoProduto{
	
	private Connection conexao;
	private PreparedStatement statement;
	private ResultSet result;
	
	public void abrirConexao() {
		this.conexao = SqlConnection.getInstace();
	}

	@Override
	public Produto cadastrar(Produto produto) {
		this.abrirConexao();
		try {
			this.statement = conexao.prepareStatement(SqlUtil.ProdutoSql.INSERT_ALL);
			this.statement.setString(1, produto.getNome());
			this.statement.setFloat(2, produto.getPreco());
			this.statement.setString(3, produto.getDescricao());
			this.statement.setFloat(4, produto.getPeso());
			this.statement.setString(5, produto.converterDataString(produto.getValidade()));
			this.statement.setInt(6, produto.getQuantidade());
			this.statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return produto;
	}

	@Override
	public Produto procurarPorId(int id){
		this.abrirConexao();
		Produto produto = new Produto();
		try {
			this.statement = conexao.prepareStatement(SqlUtil.ProdutoSql.SELECT_ID);
			this.statement.setInt(1, id);
			this.result = statement.executeQuery();
			while (result.next()) {				
				produto.setId(Integer.parseInt(result.getObject(1).toString()));
				produto.setNome(result.getObject(2).toString());
				produto.setPreco(Float.parseFloat(result.getObject(3).toString()));
				produto.setDescricao(result.getObject(4).toString());
				produto.setPeso(Float.parseFloat(result.getObject(5).toString()));
				produto.setValidade(produto.converterStringData(result.getObject(6).toString()));
				produto.setQuantidade(Integer.parseInt(result.getObject(7).toString()));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return produto;
	}

	@Override
	public ArrayList<Produto> procurarPorNome(String nome){
		this.abrirConexao();
		ArrayList<Produto> produtos = new ArrayList<>();
		try {
			this.statement = conexao.prepareStatement(SqlUtil.ProdutoSql.SELECT_PESQUISA_NOME);
			this.statement.setString(1, nome);
			this.result = statement.executeQuery();
			while (result.next()) {				
				Produto produto = new Produto();
				produto.setId(Integer.parseInt(result.getObject(1).toString()));
				produto.setNome(result.getObject(2).toString());
				produto.setPreco(Float.parseFloat(result.getObject(3).toString()));
				produto.setDescricao(result.getObject(4).toString());
				produto.setPeso(Float.parseFloat(result.getObject(5).toString()));
				produto.setValidade(produto.converterStringData(result.getObject(6).toString()));
				produto.setQuantidade(Integer.parseInt(result.getObject(7).toString()));
				produtos.add(produto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return produtos;
	}

	@Override
	public boolean alterarQuantidade(int novaQuantidade, int id) {
		this.abrirConexao();
		Produto produto = new Produto();
		try {
			this.statement = conexao.prepareStatement(SqlUtil.ProdutoSql.UPDATE_QUANTIDADE);
			this.statement.setInt(1, novaQuantidade);
			this.statement.setInt(2, id);
			this.statement.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ArrayList<Produto> listarTodos(){
		this.abrirConexao();
		ArrayList<Produto> produtos = new ArrayList<>();
		try {
			this.statement = conexao.prepareStatement(SqlUtil.ProdutoSql.SELECT_ALL);
			this.result = statement.executeQuery();
			while (this.result.next()) {
				Produto pro = new Produto();
				pro.setId(Integer.parseInt(result.getObject(1).toString()));
				pro.setNome(result.getObject(2).toString());
				pro.setPreco(Float.parseFloat(result.getObject(3).toString()));
				pro.setDescricao(result.getObject(4).toString());
				pro.setPeso(Float.parseFloat(result.getObject(5).toString()));
				pro.setValidade(pro.converterStringData(result.getObject(6).toString()));
				pro.setQuantidade(Integer.parseInt(result.getObject(7).toString()));
				produtos.add(pro);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return produtos;
	}
	
	@Override
	public Produto alterarProduto(Produto produto) {
		this.abrirConexao();
		try {
			this.statement = conexao.prepareStatement(SqlUtil.ProdutoSql.UPDATE_ALL);
			this.statement.setInt(1, produto.getId());
			this.statement.setString(2, produto.getNome());
			this.statement.setFloat(3, produto.getPreco());
			this.statement.setString(4, produto.getDescricao());
			this.statement.setFloat(5, produto.getPeso());
			this.statement.setString(6, produto.converterDataString(produto.getValidade()));
			this.statement.setInt(7, produto.getQuantidade());
			this.statement.setInt(8, produto.getId());
			this.statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return produto;
	}

	@Override
	public int retornarRegistrosSalvos() {
		this.abrirConexao();
		int registros = 0;
		try {
			this.statement = conexao.prepareStatement(SqlUtil.ProdutoSql.SELECT_REGISTROS);
			this.result = statement.executeQuery();
			while(this.result.next()) {
				registros = this.result.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return registros;
	}

}
