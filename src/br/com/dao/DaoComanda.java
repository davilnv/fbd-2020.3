package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.connection.SqlConnection;
import br.com.exception.DaoException;
import br.com.model.Comanda;
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

	@Override
	public Comanda salvar(Comanda comanda) {
		this.abrirConexao();
		try {
			this.statement = conexao.prepareStatement(SqlUtil.ComandaSql.INSERT_ALL);
			this.statement.setString(1, comanda.getCódigo());
			this.statement.setString(2, comanda.getNome_cliente());
			this.statement.setString(3, comanda.converterDataString(comanda.getData()));
			this.statement.setInt(4, comanda.getMesa());
			this.statement.setFloat(5, comanda.getTotal());
			this.statement.setString(6, comanda.getPagamento());
			this.statement.setInt(7, comanda.getUsuário_id());
			this.statement.setString(8, comanda.getProdutosId());
			this.statement.setString(9, comanda.getPratosId());
			this.statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return comanda;
	}
	
	
}
