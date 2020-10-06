package br.com.model;

import java.util.ArrayList;
import java.util.Date;

import br.com.fachada.Fachada;

public class Comanda {
	private Fachada fachada;
	private String código;
	private String nome_cliente;
	private Date data;
	private int mesa;
	private String descrição;
	private float total;
	private String pagamento;
	private int usuário_id;
	private ArrayList<Produto> produtos = new ArrayList<>();
	private ArrayList<Prato> pratos = new ArrayList<>();
	
	public Comanda(Fachada fachada) {
		this.código = Codigo.gerarCodigo(fachada);
	}

	public Comanda(String nome_cliente, Date data, int mesa, String descrição, float total,
			String pagamento, int usuário_id) {
		super();
		this.nome_cliente = nome_cliente;
		this.data = data;
		this.mesa = mesa;
		this.descrição = descrição;
		this.total = total;
		this.pagamento = pagamento;
		this.usuário_id = usuário_id;
	}

	public String getCódigo() {
		return código;
	}

	public void setCódigo(String código) {
		this.código = código;
	}

	public String getNome_cliente() {
		return nome_cliente;
	}

	public void setNome_cliente(String nome_cliente) {
		this.nome_cliente = nome_cliente;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getMesa() {
		return mesa;
	}

	public void setMesa(int mesa) {
		this.mesa = mesa;
	}

	public String getDescrição() {
		return descrição;
	}

	public void setDescrição(String descrição) {
		this.descrição = descrição;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public String getPagamento() {
		return pagamento;
	}

	public void setPagamento(String pagamento) {
		this.pagamento = pagamento;
	}

	public int getUsuário_id() {
		return usuário_id;
	}

	public void setUsuário_id(int usuário_id) {
		this.usuário_id = usuário_id;
	}

	public ArrayList<Produto> getProdutos() {
		return produtos;
	}

	public ArrayList<Prato> getPratos() {
		return pratos;
	}
	
}
