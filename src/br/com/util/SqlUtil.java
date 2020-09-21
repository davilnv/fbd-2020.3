package br.com.util;

public class SqlUtil {
	public final static String URL = "jdbc:postgresql://localhost:5432/meuprojeto";
	public final static String LOGIN = "postgres";
	public final static String PASSWORD = "Dln#3519";
	public final static String COL_ID  = "id";
	
	public static class UsuarioSql {
		public final static String NAME_TABLE = "usuario";
		
		public final static String COL_NOME = "nome";
		public final static String COL_CPF = "cpf";
		public final static String COL_LOGIN = "login";
		public final static String COL_SENHA = "senha";
		
		public final static String INSERT_ALL = "INSERT INTO " + NAME_TABLE + 
				"(" + COL_NOME + ", " + COL_CPF + ", " + COL_LOGIN + ", " + COL_SENHA + ")" +
				" VALUES(?,?,?,?)";
		
		public final static String SELECT_CPF = "SELECT * FROM " + NAME_TABLE + " a WHERE a.cpf = ?";
	}
}
