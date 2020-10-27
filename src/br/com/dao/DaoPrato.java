package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import br.com.connection.SqlConnection;
import br.com.model.Prato;
import br.com.model.Produto;
import br.com.util.SqlUtil;

public class DaoPrato implements IDaoPrato{
	
	private Connection conexao;
	private PreparedStatement statement;
	private ResultSet result;
	
	public void abrirConexao() {
		this.conexao = SqlConnection.getInstace();
	}

	@Override
	public Prato cadastrar(Prato prato) {
		this.abrirConexao();
		try {
			this.statement = conexao.prepareStatement(SqlUtil.PratoSql.INSERT_ALL);
			this.statement.setString(1, prato.getNome());
			this.statement.setFloat(2, prato.getPreco());
			this.statement.setString(3, prato.getDescricao());
			this.statement.setFloat(4, prato.getPeso());
			this.statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prato;
	}

	@Override
	public Prato procurarPorId(int id) {
		this.abrirConexao();
		Prato prato = new Prato();
		try {
			this.statement = conexao.prepareStatement(SqlUtil.PratoSql.SELECT_ID);
			this.statement.setInt(1, id);
			this.result = statement.executeQuery();
			while (result.next()) {				
				prato.setId(Integer.parseInt(result.getObject(1).toString()));
				prato.setNome(result.getObject(2).toString());
				prato.setPreco(Float.parseFloat(result.getObject(3).toString()));
				prato.setDescricao(result.getObject(4).toString());
				prato.setPeso(Float.parseFloat(result.getObject(5).toString()));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prato;
	}

	@Override
	public ArrayList<Prato> procurarPorNome(String nome) {
		this.abrirConexao();
		ArrayList<Prato> pratos = new ArrayList<>();
		try {
			this.statement = conexao.prepareStatement(SqlUtil.PratoSql.SELECT_PESQUISA_NOME);
			this.statement.setString(1, nome);
			this.result = statement.executeQuery();
			while (result.next()) {				
				Prato prato = new Prato();
				prato.setId(Integer.parseInt(result.getObject(1).toString()));
				prato.setNome(result.getObject(2).toString());
				prato.setPreco(Float.parseFloat(result.getObject(3).toString()));
				prato.setDescricao(result.getObject(4).toString());
				prato.setPeso(Float.parseFloat(result.getObject(5).toString()));
				pratos.add(prato);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pratos;
	}

	@Override
	public ArrayList<Prato> listarTodos() {
		this.abrirConexao();
		ArrayList<Prato> pratos = new ArrayList<>();
		try {
			this.statement = conexao.prepareStatement(SqlUtil.PratoSql.SELECT_ALL);
			this.result = statement.executeQuery();
			while (this.result.next()) {
				Prato pra = new Prato();
				pra.setId(Integer.parseInt(result.getObject(1).toString()));
				pra.setNome(result.getObject(2).toString());
				pra.setPreco(Float.parseFloat(result.getObject(3).toString()));
				pra.setDescricao(result.getObject(4).toString());
				pra.setPeso(Float.parseFloat(result.getObject(5).toString()));
				pratos.add(pra);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pratos;
	}

	@Override
	public Prato alterarPrato(Prato prato) {
		this.abrirConexao();
		try {
			this.statement = conexao.prepareStatement(SqlUtil.PratoSql.UPDATE_ALL);
			this.statement.setInt(1, prato.getId());
			this.statement.setString(2, prato.getNome());
			this.statement.setFloat(3, prato.getPreco());
			this.statement.setString(4, prato.getDescricao());
			this.statement.setFloat(5, prato.getPeso());
			this.statement.setInt(6, prato.getId());
			this.statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prato;
	}

	@Override
	public int retornarRegistrosSalvos() {
		this.abrirConexao();
		int registros = 0;
		try {
			this.statement = conexao.prepareStatement(SqlUtil.PratoSql.SELECT_REGISTROS);
			this.result = statement.executeQuery();
			while (this.result.next()) {
				registros = this.result.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return registros;
	}
	
}
