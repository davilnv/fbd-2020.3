package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

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

}
