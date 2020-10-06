package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.connection.SqlConnection;
import br.com.exception.DaoException;
import br.com.util.SqlUtil;

public class DaoComanda implements IDaoComanda{
	private Connection conexao;
	private PreparedStatement statement;
	private ResultSet result;
	
	public void abrirConexao() {
		this.conexao = SqlConnection.getInstace();
	}

	@Override
	public boolean verificarCodico(String codigo) throws DaoException {
		this.abrirConexao();
		try {
			this.statement = conexao.prepareStatement(SqlUtil.ComandaSql.SELECT_CODIGO);
			this.statement.setString(1, codigo);
			this.result = this.statement.executeQuery();
			return result.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DaoException("Código de comanda não existe");
		}
	}
	
	
}
