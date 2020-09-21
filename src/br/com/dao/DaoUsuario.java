package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.connection.SqlConnection;
import br.com.exception.DaoException;
import br.com.model.Usuario;
import br.com.util.SqlUtil;

public class DaoUsuario implements IDaoUsuario{
	
	private Connection conexao;
	private PreparedStatement statement;
	private ResultSet result;
	
	public void abrirConexao() {
		this.conexao = SqlConnection.getInstace();
	}

	@Override
	public Usuario cadastrar(Usuario usuario) {
		this.abrirConexao();
		try {
			this.statement = conexao.prepareStatement(SqlUtil.UsuarioSql.INSERT_ALL);
			this.statement.setString(1, usuario.getNome());
			this.statement.setString(2, usuario.getCpf());
			this.statement.setString(3, usuario.getLogin());
			this.statement.setString(4, usuario.getSenha());
			this.statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usuario;
	}

	@Override
	public ArrayList<Usuario> listarTodos() {
		return null;
	}

	@Override
	public boolean isCpf(String cpf) throws DaoException {
		this.abrirConexao();
		try {
			this.statement = this.conexao.prepareStatement(SqlUtil.UsuarioSql.SELECT_CPF);
			this.statement.setString(1, cpf);
			this.result = this.statement.executeQuery();
			return result.next();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Usuário não existe");
		}
	}

}
