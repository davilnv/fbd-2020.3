package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import br.com.connection.SqlConnection;
import br.com.model.Produto;
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

}
