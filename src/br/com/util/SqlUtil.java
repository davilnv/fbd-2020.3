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
		public final static String SELECT_ALL = "SELECT * FROM " + NAME_TABLE;
		public final static String SELECT_LOGIN_SENHA = "SELECT * FROM " + NAME_TABLE + " WHERE login = ? AND senha = ?";
		public static final String SELECT_NOME = "SELECT " + COL_NOME +" FROM " + NAME_TABLE + " WHERE login = ?";
		public static final String SELECT_ID = "SELECT " + COL_ID +" FROM " + NAME_TABLE + " WHERE login = ? AND senha = ?";
	}
	
	public static class PratoSql {
		public final static String NAME_TABLE = "prato";
		
		public final static String COL_NOME = "nome";
		public final static String COL_PRECO= "preco";
		public final static String COL_DESCRICAO = "descricao";
		public final static String COL_PESO = "peso";
		
		public final static String INSERT_ALL = "INSERT INTO " + NAME_TABLE +
				"(" + COL_NOME + ", " + COL_PRECO + ", " + COL_DESCRICAO + ", " + COL_PESO + ")" +
				" VALUES(?,?,?,?)";
		public final static String SELECT_ID = "SELECT * FROM " + NAME_TABLE + " WHERE " + COL_ID + " = ?";
		public static final String SELECT_PESQUISA_NOME = "SELECT * FROM " + NAME_TABLE +
				" WHERE LOWER(" + COL_NOME +") LIKE ALL" + 
				" (string_to_array('%' || regexp_replace(LOWER(?), '\\s+', '% %', 'g') || '%', ' '));";
	}
	
	public static class ProdutoSql {
		public final static String NAME_TABLE = "produto";
		
		public final static String COL_NOME = "nome";
		public final static String COL_PRECO= "preco";
		public final static String COL_DESCRICAO = "descricao";
		public final static String COL_PESO = "peso";
		public final static String COL_VALIDADE = "validade";
		public final static String COL_QUANTIDADE = "quantidade";
		
		public final static String INSERT_ALL = "INSERT INTO " + NAME_TABLE +
				"(" + COL_NOME + ", " + COL_PRECO + ", " + COL_DESCRICAO + ", " + COL_PESO + ", " + 
				COL_VALIDADE + ", " + COL_QUANTIDADE + ")" +
				" VALUES(?,?,?,?,?,?)";
		public final static String SELECT_ID = "SELECT * FROM " + NAME_TABLE + " WHERE " + COL_ID + " = ?";
		public static final String SELECT_PESQUISA_NOME = "SELECT * FROM " + NAME_TABLE +
				" WHERE LOWER(" + COL_NOME +") LIKE ALL" + 
				" (string_to_array('%' || regexp_replace(LOWER(?), '\\s+', '% %', 'g') || '%', ' '));";
	}
	
	public static class ComandaSql {
		public final static String NAME_TABLE = "comanda";
		
		public final static String COL_CODIGO = "codigo";
		public final static String COL_NOME_CLIENTE= "nome_cliente";
		public final static String COL_DATA = "data";
		public final static String COL_MESA = "mesa";
		public final static String COL_TOTAL = "total";
		public final static String COL_PAGAMENTO = "pagamento";
		public final static String COL_USUARIO_ID = "usuario_id";
		public final static String COL_PRODUTOS = "produtos";
		public final static String COL_PRATOS = "pratos";
		
		public final static String SELECT_CODIGO = "SELECT * FROM " + NAME_TABLE + " WHERE " + COL_CODIGO + " = ?";

		public static final String INSERT_ALL = "INSERT INTO " + NAME_TABLE + 
				"(" + COL_CODIGO + ", " + COL_NOME_CLIENTE + ", " + COL_DATA + ", " + COL_MESA + ", " 
				+ COL_TOTAL + ", " + COL_PAGAMENTO + ", " + COL_USUARIO_ID + ", " + COL_PRODUTOS + ", " 
				+ COL_PRATOS +")" +
				" VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";;
	}
}
