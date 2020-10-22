package br.com.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import br.com.exception.ModelException;
import br.com.fachada.Fachada;

public class Comanda {
	private Fachada fachada;
	private String código;
	private String nome_cliente;
	private Date data;
	private int mesa;
	private float total;
	private float troco;
	private float totalConta;
	private String pagamento;
	private int usuário_id;
	private ArrayList<Produto> produtos = new ArrayList<>();
	private ArrayList<Prato> pratos = new ArrayList<>();
	private String produtosId = "";
	private String pratosId = "";
	
	public Comanda(Fachada fachada) {
		this.código = Codigo.gerarCodigo(fachada);
	}

	public Comanda(String nome_cliente, Date data, int mesa, float total,
			String pagamento, int usuário_id) {
		super();
		this.nome_cliente = nome_cliente;
		this.data = data;
		this.mesa = mesa;
		this.total = total;
		this.pagamento = pagamento;
		this.usuário_id = usuário_id;
	}
	
	public void somarCompras() {
		float total = 0;
		for (Produto produto : produtos) {
			total += produto.getPreco();
		}
		for (Prato prato : pratos) {
			total += prato.getPreco();
		}
		this.total = total;
	}
	
	public boolean calculoFinal(float dinheiro, float cartao, float desconto) throws ModelException {
		totalConta = dinheiro + cartao;
		if (total > 0 && desconto < total) {			
			total -= desconto;
		} else {
			throw new ModelException("Desconto não aplicado, valor superior ao total ou menor que 0.");
		}
		
		if (totalConta >= total) {
			troco = totalConta - total;
			return true;
		} else {
			throw new ModelException("Dinheiro não é suficente para realzar o pagamento");
		}
	}
	
	public boolean calculoFinal(Comanda comanda){
		if (comanda.getTotalConta() >= comanda.getTotal()) {
			return true;
		}
		return false;
	}
	
	public String converterDataString(Date data) {
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		return f.format(data);
	}
	
	public void converterArrayStringId() {
		for (Produto produto : produtos) {
			produtosId += produto.getId() + ",";
		}
		
		for (Prato prato : pratos) {
			pratosId += prato.getId() + ",";
		}
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

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public float getTroco() {
		return troco;
	}

	public void setTroco(float troco) {
		this.troco = troco;
	}

	public float getTotalConta() {
		return totalConta;
	}

	public void setTotalConta(float totalConta) {
		this.totalConta = totalConta;
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

	public String getProdutosId() {
		return produtosId;
	}

	public void setProdutosId(String produtosId) {
		this.produtosId = produtosId;
	}

	public String getPratosId() {
		return pratosId;
	}

	public void setPratosId(String pratosId) {
		this.pratosId = pratosId;
	}
	
}
