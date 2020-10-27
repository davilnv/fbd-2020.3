package br.com.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Estoque {
	private int id;
	private int produto_id;
	private Date data;
	private int usuario_id;
	private String funcao;
	
	public Estoque(int produto_id, Date data, int usuario_id, String funcao) {
		this.produto_id = produto_id;
		this.data = data;
		this.usuario_id = usuario_id;
		this.funcao = funcao;
	}
	
	public Estoque() {
		// TODO Auto-generated constructor stub
	}

	public String converterDataString(Date data) {
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		return f.format(data);
	}
	
	public Date converterStringData(String data) throws ParseException {
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		return f.parse(data);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProduto_id() {
		return produto_id;
	}

	public void setProduto_id(int produto_id) {
		this.produto_id = produto_id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(int usuario_id) {
		this.usuario_id = usuario_id;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	
}
