package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import br.com.connection.SqlConnection;
import br.com.model.Estoque;
import br.com.util.SqlUtil;

public class DaoEstoque implements IDaoEstoque{
	private Connection conexao;
	private PreparedStatement statement;
	private ResultSet result;
	
	public void abrirConexao() {
		this.conexao = SqlConnection.getInstace();
	}

	@Override
	public boolean registrar(Estoque estoque) {
		this.abrirConexao();
		try {
			this.statement = conexao.prepareStatement(SqlUtil.EstoqueSql.INSERT_ALL);
			this.statement.setInt(1, estoque.getProduto_id());
			this.statement.setString(2, estoque.converterDataString(estoque.getData()));
			this.statement.setInt(3, estoque.getUsuario_id());
			this.statement.setString(4, estoque.getFuncao());
			this.statement.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public int registros(int id) {
		this.abrirConexao();
		int registros = 0;
		try {
			this.statement = conexao.prepareStatement(SqlUtil.EstoqueSql.SELECT_REGISTROS);
			this.statement.setInt(1, id);
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

	@Override
	public ArrayList<Estoque> buscarEstoque(String cadastro, String alteracao){
		this.abrirConexao();
		ArrayList<Estoque> estoque = new ArrayList<>();
		try {
			this.statement = conexao.prepareStatement(SqlUtil.EstoqueSql.SELECT_ID);
			this.statement.setString(1, cadastro);
			this.statement.setString(2, alteracao);
			this.result = statement.executeQuery();
			while(this.result.next()) {
				Estoque e = new Estoque();
				e.setId(result.getInt(1));
				e.setProduto_id(result.getInt(2));
				e.setData(e.converterStringData(result.getString(3)));
				e.setUsuario_id(result.getInt(4));
				e.setFuncao(result.getString(5));
				estoque.add(e);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return estoque;
	}
	
	
}
