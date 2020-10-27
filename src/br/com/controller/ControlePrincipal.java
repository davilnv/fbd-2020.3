package br.com.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JLabel;

import br.com.exception.BusinessException;
import br.com.exception.ModelException;
import br.com.fachada.Fachada;
import br.com.model.Codigo;
import br.com.model.Comanda;
import br.com.model.Estoque;
import br.com.model.Prato;
import br.com.model.Produto;
import br.com.model.Usuario;
import br.com.view.TelaLogin;
import br.com.view.TelaPrincipal;

public class ControlePrincipal implements ActionListener, MouseListener{
	
	private Fachada fachada;
	private ControleLogin controleLogin;
	private TelaLogin telaLogin;
	private TelaPrincipal telaPrincipal;
	private ArrayList<Comanda> comandas = new ArrayList<>();
	private ArrayList<Produto> produtos;
	private ArrayList<Prato> pratos;
	private int index;
	private boolean mesaClicada;
	
	public ControlePrincipal(Fachada fachada, TelaLogin telaLogin, TelaPrincipal telaPrincipal, ControleLogin controleLogin) {
		this.fachada = fachada;
		this.telaLogin = telaLogin;
		this.telaPrincipal = telaPrincipal;
		this.controleLogin = controleLogin;
		
		for (int i = 0; i<40; i++) {
			comandas.add(new Comanda(fachada));
		}
		
		telaPrincipal.getPedidoLabel().addMouseListener(this);
		telaPrincipal.getPromocoesLabel().addMouseListener(this);
		telaPrincipal.getFinanceiroLabel().addMouseListener(this);
		telaPrincipal.getEstoqueLabel().addMouseListener(this);
		telaPrincipal.getRelatorioLabel().addMouseListener(this);
		telaPrincipal.getConfiguracoesLabel().addMouseListener(this);
		telaPrincipal.getPerfilLabel().addMouseListener(this);
		for (JLabel mesaLabel : telaPrincipal.getPainelPedidos().getMesas()) {
			mesaLabel.addMouseListener(this);
		}
		
		telaPrincipal.getPainelPedidos().getAdicionarButton().addActionListener(this);
		telaPrincipal.getPainelPedidos().getFecharMesaButton().addActionListener(this);
		telaPrincipal.getPainelPedidos().getRemoverButton().addActionListener(this);
		telaPrincipal.getPainelPedidos().getAbrirMesaButton().addActionListener(this);
		telaPrincipal.getPainelPedidos().getOkButton().addActionListener(this);
		telaPrincipal.getPainelPedidos().getTelaComanda().getPainelAdicionar().getProdutoButton().addActionListener(this);
		telaPrincipal.getPainelPedidos().getTelaComanda().getPainelAdicionar().getPratoButton().addActionListener(this);
		telaPrincipal.getPainelPedidos().getTelaComanda().getPainelAdicionar().getPesquisarButton().addActionListener(this);
		telaPrincipal.getPainelPedidos().getTelaComanda().getPainelAdicionar().getAdicionarButton().addActionListener(this);
		telaPrincipal.getPainelPedidos().getTelaComanda().getPainelRemover().getConfirmarButton().addActionListener(this);
		telaPrincipal.getPainelPedidos().getTelaComanda().getPainelFecharMesa().getPagamentoBox().addActionListener(this);
		telaPrincipal.getPainelPedidos().getTelaComanda().getPainelFecharMesa().getConfirmarButton().addActionListener(this);
		telaPrincipal.getPainelPedidos().getTelaComanda().getPainelFecharMesa().getAtualizarButton().addActionListener(this);
		
		telaPrincipal.getPainelEstoque().getCadastrarProdutoButton().addActionListener(this);
		telaPrincipal.getPainelEstoque().getCadastrarPratoButton().addActionListener(this);
		telaPrincipal.getPainelEstoque().getAtualizarButton().addActionListener(this);
		telaPrincipal.getPainelEstoque().getAlterarPratoButton().addActionListener(this);
		telaPrincipal.getPainelEstoque().getAlterarProdutoButton().addActionListener(this);
		telaPrincipal.getPainelEstoque().getTelaEstoque().getPainelCadastrarProduto().getConfirmarButton().addActionListener(this);
		telaPrincipal.getPainelEstoque().getTelaEstoque().getPainelCadastrarPrato().getConfirmarButton().addActionListener(this);
		telaPrincipal.getPainelEstoque().getTelaEstoque().getPainelAlterarProduto().getConfirmarButton().addActionListener(this);
		telaPrincipal.getPainelEstoque().getTelaEstoque().getPainelAlterarPrato().getConfirmarButton().addActionListener(this);
		
		telaPrincipal.getPainelConta().getAlterarNomeButton().addActionListener(this);
		telaPrincipal.getPainelConta().getAlterarSenhaButton().addActionListener(this);
		telaPrincipal.getPainelConta().getConfirmarAlterarNomeButton().addActionListener(this);
		telaPrincipal.getPainelConta().getConfirmarAlterarSenhaButton().addActionListener(this);
		telaPrincipal.getPainelConta().getSairButton().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(telaPrincipal.getPainelPedidos().getAdicionarButton() == arg0.getSource()) {
			telaPrincipal.getPainelPedidos().getTelaComanda().ligarPainelAdicionar();
		}
		
		if(telaPrincipal.getPainelPedidos().getRemoverButton() == arg0.getSource()) {
			telaPrincipal.getPainelPedidos().getTelaComanda().getPainelRemover().escreverLogin(controleLogin.usuarioLogado.getLogin());
			telaPrincipal.getPainelPedidos().getTelaComanda().ligarPainelRemover();
		}
		
		if(telaPrincipal.getPainelPedidos().getFecharMesaButton() == arg0.getSource()) {
			telaPrincipal.getPainelPedidos().getTelaComanda().ligarPainelFecharMesa();
		}
		
		if(telaPrincipal.getPainelPedidos().getAbrirMesaButton() == arg0.getSource()) {
			if (telaPrincipal.getPainelPedidos().getNomeClienteLabel().isVisible() &&
					telaPrincipal.getPainelPedidos().getNomeClienteField().isVisible() &&
					telaPrincipal.getPainelPedidos().getOkButton().isVisible()) {
				telaPrincipal.getPainelPedidos().getNomeClienteLabel().setVisible(false);
				telaPrincipal.getPainelPedidos().getNomeClienteField().setVisible(false);
				telaPrincipal.getPainelPedidos().getOkButton().setVisible(false);
			} else {				
				telaPrincipal.getPainelPedidos().getNomeClienteLabel().setVisible(true);
				telaPrincipal.getPainelPedidos().getNomeClienteField().setVisible(true);
				telaPrincipal.getPainelPedidos().getOkButton().setVisible(true);
			}
		}
		
		if(telaPrincipal.getPainelPedidos().getOkButton() == arg0.getSource()) {
			String nomeCliente = telaPrincipal.getPainelPedidos().getNomeClienteField().getText();
			if (nomeCliente.trim().equals("")) {
				telaPrincipal.getPainelPedidos().escreverMensagemErro();
			} else {
				
				telaPrincipal.getPainelPedidos().corrigirMensagemErro();
				comandas.get(index).setNome_cliente(nomeCliente);
			}
		}
		
		if (telaPrincipal.getPainelPedidos().getTelaComanda().getPainelAdicionar().getPesquisarButton() == arg0.getSource()) {
			String pesquisa = telaPrincipal.getPainelPedidos().getTelaComanda().getPainelAdicionar().getPesquisarField().getText();
			if(telaPrincipal.getPainelPedidos().getTelaComanda().getPainelAdicionar().getProdutoButton().isSelected()) {
				try {
					produtos = fachada.procurarProdutoPorNome(pesquisa);
				} catch (BusinessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				telaPrincipal.getPainelPedidos().getTelaComanda().getPainelAdicionar().getModelo().setNumRows(0);
				telaPrincipal.getPainelPedidos().getTelaComanda().getPainelAdicionar().criarTabelaProduto(produtos);
			}
			
			if(telaPrincipal.getPainelPedidos().getTelaComanda().getPainelAdicionar().getPratoButton().isSelected()) {
				try {
					pratos = fachada.procurarPratoPorNome(pesquisa);
				} catch (BusinessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				telaPrincipal.getPainelPedidos().getTelaComanda().getPainelAdicionar().getModelo().setNumRows(0);
				telaPrincipal.getPainelPedidos().getTelaComanda().getPainelAdicionar().criarTabelaPrato(pratos);
			}
		}
		
		
		if (telaPrincipal.getPainelPedidos().getTelaComanda().getPainelAdicionar().getAdicionarButton() == arg0.getSource()) {
			int i = telaPrincipal.getPainelPedidos().getTelaComanda().getPainelAdicionar().getTabela().getSelectedRow();
			if (telaPrincipal.getPainelPedidos().getTelaComanda().getPainelAdicionar().getProdutoButton().isSelected()) {				
				comandas.get(index).getProdutos().add(produtos.get(i));
				try {
					int quant = fachada.procurarProdutoPorId(produtos.get(i).getId()).getQuantidade();
					quant -= 1;
					fachada.alterarQuantidadeProduto(quant, produtos.get(i).getId());
				} catch (BusinessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if (telaPrincipal.getPainelPedidos().getTelaComanda().getPainelAdicionar().getPratoButton().isSelected()) {				
				comandas.get(index).getPratos().add(pratos.get(i));
			}
			comandas.get(index).somarCompras();
			
		}
		
		if (telaPrincipal.getPainelPedidos().getTelaComanda().getPainelRemover().getConfirmarButton() == arg0.getSource()) {
			int iPro = telaPrincipal.getPainelPedidos().getTabelaProduto().getSelectedRow();
			int iPra = telaPrincipal.getPainelPedidos().getTabelaPrato().getSelectedRow();
			String login = telaPrincipal.getPainelPedidos().getTelaComanda().getPainelRemover().getLoginField().getText();
			String senha = new String(telaPrincipal.getPainelPedidos().getTelaComanda().getPainelRemover().getSenhaField().getPassword()).trim();
			Usuario user = new Usuario("", "", login, senha);
			if (iPro == -1 && iPra == -1) {
				telaPrincipal.getPainelPedidos().getTelaComanda().getPainelRemover().escreverMensagemErro();
			} else {
				telaPrincipal.getPainelPedidos().getTelaComanda().getPainelRemover().corrigirMensagemErro();
				try {
					if (fachada.verificarUsuario(user)) {
						if (iPro != -1) {
							int quant = fachada.procurarProdutoPorId(comandas.get(index).getProdutos().get(iPro).getId()).getQuantidade();
							quant += 1;
							fachada.alterarQuantidadeProduto(quant, comandas.get(index).getProdutos().get(iPro).getId());
							telaPrincipal.getPainelPedidos().getModeloProduto().removeRow(iPro);
							comandas.get(index).getProdutos().remove(iPro);
						}
					}
				} catch (BusinessException e1) {
					// TODO Auto-generated catch block
					telaPrincipal.getPainelPedidos().getTelaComanda().getPainelRemover().msgErroUsuario(e1.getMessage());
				}
			}
			if (iPra == -1 && iPro == -1) {
				telaPrincipal.getPainelPedidos().getTelaComanda().getPainelRemover().escreverMensagemErro();
			} else {
				telaPrincipal.getPainelPedidos().getTelaComanda().getPainelRemover().corrigirMensagemErro();
				try {
					if (fachada.verificarUsuario(user)) {
						if (iPra != -1) {							
							telaPrincipal.getPainelPedidos().getModeloPrato().removeRow(iPra);
							comandas.get(index).getPratos().remove(iPra);
						}
					}
				} catch (BusinessException e1) {
					// TODO Auto-generated catch block
					telaPrincipal.getPainelPedidos().getTelaComanda().getPainelRemover().msgErroUsuario(e1.getMessage());
				}
			}
			comandas.get(index).somarCompras();
			telaPrincipal.getPainelPedidos().getTelaComanda().getPainelRemover().getSenhaField().setText("");
		}
		
		if (telaPrincipal.getPainelPedidos().getTelaComanda().getPainelFecharMesa().getPagamentoBox().getSelectedItem().equals("")) {
			telaPrincipal.getPainelPedidos().getTelaComanda().getPainelFecharMesa().getDinheiroField().setEnabled(false);
			telaPrincipal.getPainelPedidos().getTelaComanda().getPainelFecharMesa().getBandeiraBox().setEnabled(false);
			telaPrincipal.getPainelPedidos().getTelaComanda().getPainelFecharMesa().getCartaoField().setEnabled(false);
			telaPrincipal.getPainelPedidos().getTelaComanda().getPainelFecharMesa().getDinheiroField().setText("0.0");
			telaPrincipal.getPainelPedidos().getTelaComanda().getPainelFecharMesa().getCartaoField().setText("0.0");
			telaPrincipal.getPainelPedidos().getTelaComanda().getPainelFecharMesa().getPagamentoBox().setSelectedItem("");
			telaPrincipal.getPainelPedidos().getTelaComanda().getPainelFecharMesa().getBandeiraBox().setSelectedItem("");
		}
		
		if (telaPrincipal.getPainelPedidos().getTelaComanda().getPainelFecharMesa().getPagamentoBox().getSelectedItem().equals("Dinheiro")) {
			telaPrincipal.getPainelPedidos().getTelaComanda().getPainelFecharMesa().getDinheiroField().setEnabled(true);
			telaPrincipal.getPainelPedidos().getTelaComanda().getPainelFecharMesa().getBandeiraBox().setEnabled(false);
			telaPrincipal.getPainelPedidos().getTelaComanda().getPainelFecharMesa().getCartaoField().setEnabled(false);
			telaPrincipal.getPainelPedidos().getTelaComanda().getPainelFecharMesa().getCartaoField().setText("0.0");
			telaPrincipal.getPainelPedidos().getTelaComanda().getPainelFecharMesa().getBandeiraBox().setSelectedItem("");
		}
		
		if (telaPrincipal.getPainelPedidos().getTelaComanda().getPainelFecharMesa().getPagamentoBox().getSelectedItem().equals("Cartão de Crédito") ||
				telaPrincipal.getPainelPedidos().getTelaComanda().getPainelFecharMesa().getPagamentoBox().getSelectedItem().equals("Cartão de Débito")) {
			telaPrincipal.getPainelPedidos().getTelaComanda().getPainelFecharMesa().getDinheiroField().setEnabled(false);
			telaPrincipal.getPainelPedidos().getTelaComanda().getPainelFecharMesa().getBandeiraBox().setEnabled(true);
			telaPrincipal.getPainelPedidos().getTelaComanda().getPainelFecharMesa().getCartaoField().setEnabled(true);
			telaPrincipal.getPainelPedidos().getTelaComanda().getPainelFecharMesa().getDinheiroField().setText("0.0");
		}
		
		if (telaPrincipal.getPainelPedidos().getTelaComanda().getPainelFecharMesa().getPagamentoBox().getSelectedItem().equals("Dinheiro + Cartão de Crédito") ||
				telaPrincipal.getPainelPedidos().getTelaComanda().getPainelFecharMesa().getPagamentoBox().getSelectedItem().equals("Dinheiro + Cartão de Débito")) {
			telaPrincipal.getPainelPedidos().getTelaComanda().getPainelFecharMesa().getDinheiroField().setEnabled(true);
			telaPrincipal.getPainelPedidos().getTelaComanda().getPainelFecharMesa().getBandeiraBox().setEnabled(true);
			telaPrincipal.getPainelPedidos().getTelaComanda().getPainelFecharMesa().getCartaoField().setEnabled(true);
		}
		
		if (telaPrincipal.getPainelPedidos().getTelaComanda().getPainelFecharMesa().getAtualizarButton() == arg0.getSource()) {
			float dinheiro = Float.parseFloat(telaPrincipal.getPainelPedidos().getTelaComanda().getPainelFecharMesa().getDinheiroField().getText());
			float cartao = Float.parseFloat(telaPrincipal.getPainelPedidos().getTelaComanda().getPainelFecharMesa().getCartaoField().getText());
			float desconto = Float.parseFloat(telaPrincipal.getPainelPedidos().getTelaComanda().getPainelFecharMesa().getDescontoField().getText());
			telaPrincipal.getPainelPedidos().getTelaComanda().getPainelFecharMesa().corrigirMsgErro();
			try {
				comandas.get(index).calculoFinal(dinheiro, cartao, desconto);
			} catch (ModelException e) {
				e.printStackTrace();
				telaPrincipal.getPainelPedidos().getTelaComanda().getPainelFecharMesa().msgErro(e.getMessage());
			}
			if (telaPrincipal.getPainelPedidos().getTelaComanda().getPainelFecharMesa().getPagamentoBox().getSelectedItem().equals("Cartão de Crédito") ||
					telaPrincipal.getPainelPedidos().getTelaComanda().getPainelFecharMesa().getPagamentoBox().getSelectedItem().equals("Cartão de Débito")) {
				comandas.get(index).setTroco(0);
			}
			telaPrincipal.getPainelPedidos().getTelaComanda().getPainelFecharMesa().escreverTotal(""+comandas.get(index).getTotalConta(), String.format(java.util.Locale.US,"%.2f", comandas.get(index).getTroco()));
		}
		
		if (telaPrincipal.getPainelPedidos().getTelaComanda().getPainelFecharMesa().getConfirmarButton() == arg0.getSource()) {
			if (comandas.get(index).calculoFinal(comandas.get(index))) {
				comandas.get(index).converterArrayStringId();
				Date data = new Date();
				comandas.get(index).setData(data);
				if (mesaClicada) {					
					comandas.get(index).setMesa(index+1);
				}
				comandas.get(index).setUsuário_id(controleLogin.usuarioLogado.getId());
				comandas.get(index).setPagamento(telaPrincipal.getPainelPedidos().getTelaComanda().getPainelFecharMesa().getPagamentoBox().getSelectedItem().toString()+"/"+telaPrincipal.getPainelPedidos().getTelaComanda().getPainelFecharMesa().getBandeiraBox().getSelectedItem().toString());
				telaPrincipal.getPainelPedidos().getTelaComanda().getPainelFecharMesa().corrigirMsgErro();
				try {
					fachada.salvarComanda(comandas.get(index));
					for (Produto pro : comandas.get(index).getProdutos()) {
						int quant = fachada.procurarProdutoPorId(pro.getId()).getQuantidade();
						quant -= 1;
						fachada.alterarQuantidadeProduto(quant, pro.getId());
					}
					comandas.get(index).setCódigo(Codigo.gerarCodigo(fachada));
					comandas.get(index).setNome_cliente("");
					comandas.get(index).setTotal(0);
					comandas.get(index).setPagamento("");
					comandas.get(index).getProdutos().clear();
					comandas.get(index).getPratos().clear();
					comandas.get(index).setProdutosId("");
					comandas.get(index).setPratosId("");
					telaPrincipal.getPainelPedidos().getTelaComanda().getPainelFecharMesa().getDinheiroField().setText("0.0");
					telaPrincipal.getPainelPedidos().getTelaComanda().getPainelFecharMesa().getCartaoField().setText("0.0");
					telaPrincipal.getPainelPedidos().getTelaComanda().getPainelFecharMesa().getDescontoField().setText("0.0");
					telaPrincipal.getPainelPedidos().getTelaComanda().getPainelFecharMesa().getPagamentoBox().setSelectedItem("");
					telaPrincipal.getPainelPedidos().getTelaComanda().getPainelFecharMesa().getBandeiraBox().setSelectedItem("");
					telaPrincipal.getPainelPedidos().getTelaComanda().getPainelFecharMesa().corrigirTotal();
					telaPrincipal.getPainelPedidos().getTelaComanda().setVisible(false);
				} catch (BusinessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					telaPrincipal.getPainelPedidos().getTelaComanda().getPainelFecharMesa().msgErro(e.getMessage());
				}
			}
		}
		
		if(telaPrincipal.getPainelEstoque().getCadastrarProdutoButton() == arg0.getSource()) {
			telaPrincipal.getPainelEstoque().getTelaEstoque().ligarPainelCadastrarProduto("Cadastrar Produto");
		}
		

		if(telaPrincipal.getPainelEstoque().getCadastrarPratoButton() == arg0.getSource()) {
			telaPrincipal.getPainelEstoque().getTelaEstoque().ligarPainelCadastrarPrato("Cadastrar Prato");
		}
		
		if(telaPrincipal.getPainelEstoque().getTelaEstoque().getPainelCadastrarProduto().getConfirmarButton() == arg0.getSource()) {
			String nome = telaPrincipal.getPainelEstoque().getTelaEstoque().getPainelCadastrarProduto().getNomeField().getText();
			float preco = Float.parseFloat(telaPrincipal.getPainelEstoque().getTelaEstoque().getPainelCadastrarProduto().getPrecoField().getText());
			String descricao = telaPrincipal.getPainelEstoque().getTelaEstoque().getPainelCadastrarProduto().getDescricaoField().getText();
			float peso = Float.parseFloat(telaPrincipal.getPainelEstoque().getTelaEstoque().getPainelCadastrarProduto().getPesoField().getText());
			String validade = telaPrincipal.getPainelEstoque().getTelaEstoque().getPainelCadastrarProduto().getValidadeField().getText();
			int quantidade = Integer.parseInt(telaPrincipal.getPainelEstoque().getTelaEstoque().getPainelCadastrarProduto().getQuantidadeField().getText());

			Produto produto = new Produto();
			produto.setNome(nome);
			produto.setPreco(preco);
			produto.setDescricao(descricao);
			produto.setPeso(peso);
			try {
				produto.setValidade(produto.converterStringData(validade));
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			produto.setQuantidade(quantidade);
			telaPrincipal.getPainelEstoque().getTelaEstoque().getPainelCadastrarProduto().corrigirMensagemErro();
			try {
				fachada.cadastrarProduto(produto);
				Estoque estoque = new Estoque(fachada.retornarRegistrosSalvosProduto(), new Date(), controleLogin.usuarioLogado.getId(), "CADASTRO/PRODUTO");
				fachada.registrarEstoque(estoque);
				telaPrincipal.getPainelEstoque().getTelaEstoque().getPainelCadastrarProduto().getNomeField().setText("");
				telaPrincipal.getPainelEstoque().getTelaEstoque().getPainelCadastrarProduto().getPrecoField().setText("0.0");
				telaPrincipal.getPainelEstoque().getTelaEstoque().getPainelCadastrarProduto().getPesoField().setText("0.0");
				telaPrincipal.getPainelEstoque().getTelaEstoque().getPainelCadastrarProduto().getDescricaoField().setText("");
				telaPrincipal.getPainelEstoque().getTelaEstoque().getPainelCadastrarProduto().getValidadeField().setText(produto.converterDataString(new Date()));
				telaPrincipal.getPainelEstoque().getTelaEstoque().getPainelCadastrarProduto().getQuantidadeField().setText("0");
				telaPrincipal.getPainelEstoque().getTelaEstoque().setVisible(false);
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				telaPrincipal.getPainelEstoque().getTelaEstoque().getPainelCadastrarProduto().escreverMensagemErro(e.getMessage());
			}
		}
		
		if(telaPrincipal.getPainelEstoque().getTelaEstoque().getPainelCadastrarPrato().getConfirmarButton() == arg0.getSource()) {
			String nome = telaPrincipal.getPainelEstoque().getTelaEstoque().getPainelCadastrarPrato().getNomeField().getText();
			float preco = Float.parseFloat(telaPrincipal.getPainelEstoque().getTelaEstoque().getPainelCadastrarPrato().getPrecoField().getText());
			String descricao = telaPrincipal.getPainelEstoque().getTelaEstoque().getPainelCadastrarPrato().getDescricaoField().getText();
			float peso = Float.parseFloat(telaPrincipal.getPainelEstoque().getTelaEstoque().getPainelCadastrarPrato().getPesoField().getText());
			Prato prato = new Prato();
			prato.setNome(nome);
			prato.setPreco(preco);
			prato.setDescricao(descricao);
			prato.setPeso(peso);
			telaPrincipal.getPainelEstoque().getTelaEstoque().getPainelCadastrarPrato().corrigirMensagemErro();
			try {
				fachada.cadastrarPrato(prato);
				Estoque estoque = new Estoque(fachada.retornarRegistrosSalvosPrato(), new Date(), controleLogin.usuarioLogado.getId(), "CADASTRO/PRATO");
				fachada.registrarEstoque(estoque);
				telaPrincipal.getPainelEstoque().getTelaEstoque().getPainelCadastrarPrato().getNomeField().setText("");
				telaPrincipal.getPainelEstoque().getTelaEstoque().getPainelCadastrarPrato().getPrecoField().setText("0.0");
				telaPrincipal.getPainelEstoque().getTelaEstoque().getPainelCadastrarPrato().getPesoField().setText("0.0");
				telaPrincipal.getPainelEstoque().getTelaEstoque().getPainelCadastrarPrato().getDescricaoField().setText("");
				telaPrincipal.getPainelEstoque().getTelaEstoque().setVisible(false);
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				telaPrincipal.getPainelEstoque().getTelaEstoque().getPainelCadastrarPrato().escreverMensagemErro(e.getMessage());
			}
		}
		
		if(telaPrincipal.getPainelEstoque().getAtualizarButton() == arg0.getSource()) {
			if(telaPrincipal.getPainelEstoque().getProdutoButton().isSelected()) {
				telaPrincipal.getPainelEstoque().criarTabelaProduto(fachada.listarTodosProdutos());
				int registros = fachada.retornarRegistrosSalvosProduto();
				String ultimoRegistro = "";
				try {
					ultimoRegistro = fachada.procurarProdutoPorId(registros).toString();
				} catch (BusinessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Estoque estoque = fachada.buscarEstoque("CADASTRO/PRODUTO", "ALTERAÇÃO/PRODUTO").get(fachada.buscarEstoque("CADASTRO/PRODUTO", "ALTERAÇÃO/PRODUTO").size()-1);
				Usuario user = new Usuario();
				for (Usuario u : fachada.listarTodosUsuarios()) {
					if (u.getId() == estoque.getUsuario_id()) {
						user = u;
					}
				}
				telaPrincipal.getPainelEstoque().pintarComponentesEstoque(registros, ultimoRegistro, user.getNome(), estoque.converterDataString(estoque.getData()));
			}
			
			if(telaPrincipal.getPainelEstoque().getPratoButton().isSelected()) {
				telaPrincipal.getPainelEstoque().criarTabelaPrato(fachada.listarTodosPratos());
				int registros = fachada.retornarRegistrosSalvosPrato();
				String ultimoRegistro = "";
				try {
					ultimoRegistro = fachada.procurarPratoPorId(registros).toString();
				} catch (BusinessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Estoque estoque = fachada.buscarEstoque("CADASTRO/PRATO", "ALTERAÇÃO/PRATO").get(fachada.buscarEstoque("CADASTRO/PRATO", "ALTERAÇÃO/PRATO").size()-1);
				Usuario user = new Usuario();
				for (Usuario u : fachada.listarTodosUsuarios()) {
					if (u.getId() == estoque.getUsuario_id()) {
						user = u;
					}
				}
				telaPrincipal.getPainelEstoque().pintarComponentesEstoque(registros, ultimoRegistro, user.getNome(), estoque.converterDataString(estoque.getData()));
			}
		}
		
		if(telaPrincipal.getPainelEstoque().getAlterarProdutoButton() == arg0.getSource()) {
			telaPrincipal.getPainelEstoque().getTelaEstoque().ligarPainelAlterarProduto("Alterar produto");
			int i = telaPrincipal.getPainelEstoque().getTabela().getSelectedRow();
			Produto produto = new Produto();
			try {
				produto = fachada.procurarProdutoPorId(i+1);
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			telaPrincipal.getPainelEstoque().getTelaEstoque().getPainelAlterarProduto().getNomeField().setText(produto.getNome());
			telaPrincipal.getPainelEstoque().getTelaEstoque().getPainelAlterarProduto().getPrecoField().setText(""+produto.getPreco());
			telaPrincipal.getPainelEstoque().getTelaEstoque().getPainelAlterarProduto().getDescricaoField().setText(produto.getDescricao());
			telaPrincipal.getPainelEstoque().getTelaEstoque().getPainelAlterarProduto().getPesoField().setText(""+produto.getPeso());
			if (produto.getValidade() != null) {
				telaPrincipal.getPainelEstoque().getTelaEstoque().getPainelAlterarProduto().getValidadeField().setText(produto.converterDataString(produto.getValidade()));
			}
			telaPrincipal.getPainelEstoque().getTelaEstoque().getPainelAlterarProduto().getQuantidadeField().setText(""+produto.getQuantidade());
			telaPrincipal.getPainelEstoque().getTelaEstoque().getPainelAlterarProduto().getConfirmarButton().setText("Confirmar Alteração");
		}
		
		if(telaPrincipal.getPainelEstoque().getAlterarPratoButton() == arg0.getSource()) {
			telaPrincipal.getPainelEstoque().getTelaEstoque().ligarPainelAlterarPrato("Alterar Prato");
			int i = telaPrincipal.getPainelEstoque().getTabela().getSelectedRow();
			Prato prato = new Prato();
			try {
				prato = fachada.procurarPratoPorId(i+1);
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			telaPrincipal.getPainelEstoque().getTelaEstoque().getPainelAlterarPrato().getNomeField().setText(prato.getNome());
			telaPrincipal.getPainelEstoque().getTelaEstoque().getPainelAlterarPrato().getPrecoField().setText(""+prato.getPreco());
			telaPrincipal.getPainelEstoque().getTelaEstoque().getPainelAlterarPrato().getDescricaoField().setText(prato.getDescricao());
			telaPrincipal.getPainelEstoque().getTelaEstoque().getPainelAlterarPrato().getPesoField().setText(""+prato.getPeso());
			telaPrincipal.getPainelEstoque().getTelaEstoque().getPainelAlterarPrato().getConfirmarButton().setText("Confirmar Alteração");
		}
		
		if(telaPrincipal.getPainelEstoque().getTelaEstoque().getPainelAlterarProduto().getConfirmarButton() == arg0.getSource()) {
			String nome = telaPrincipal.getPainelEstoque().getTelaEstoque().getPainelAlterarProduto().getNomeField().getText();
			float preco = Float.parseFloat(telaPrincipal.getPainelEstoque().getTelaEstoque().getPainelAlterarProduto().getPrecoField().getText());
			String descricao = telaPrincipal.getPainelEstoque().getTelaEstoque().getPainelAlterarProduto().getDescricaoField().getText();
			float peso = Float.parseFloat(telaPrincipal.getPainelEstoque().getTelaEstoque().getPainelAlterarProduto().getPesoField().getText());
			String validade = telaPrincipal.getPainelEstoque().getTelaEstoque().getPainelAlterarProduto().getValidadeField().getText();
			int quantidade = Integer.parseInt(telaPrincipal.getPainelEstoque().getTelaEstoque().getPainelAlterarProduto().getQuantidadeField().getText());

			Produto produto = new Produto();
			produto.setId(telaPrincipal.getPainelEstoque().getTabela().getSelectedRow()+1);
			produto.setNome(nome);
			produto.setPreco(preco);
			produto.setDescricao(descricao);
			produto.setPeso(peso);
			try {
				produto.setValidade(produto.converterStringData(validade));
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			produto.setQuantidade(quantidade);
			telaPrincipal.getPainelEstoque().getTelaEstoque().getPainelAlterarProduto().corrigirMensagemErro();
			try {
				fachada.alterarProduto(produto);
				Estoque estoque = new Estoque(fachada.procurarProdutoPorNome(nome).get(0).getId(), new Date(), controleLogin.usuarioLogado.getId(), "ALTERAÇÃO/PRODUTO");
				fachada.registrarEstoque(estoque);
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			telaPrincipal.getPainelEstoque().getTelaEstoque().setVisible(false);
		}
		
		if(telaPrincipal.getPainelEstoque().getTelaEstoque().getPainelAlterarPrato().getConfirmarButton() == arg0.getSource()) {
			String nome = telaPrincipal.getPainelEstoque().getTelaEstoque().getPainelAlterarPrato().getNomeField().getText();
			float preco = Float.parseFloat(telaPrincipal.getPainelEstoque().getTelaEstoque().getPainelAlterarPrato().getPrecoField().getText());
			String descricao = telaPrincipal.getPainelEstoque().getTelaEstoque().getPainelAlterarPrato().getDescricaoField().getText();
			float peso = Float.parseFloat(telaPrincipal.getPainelEstoque().getTelaEstoque().getPainelAlterarPrato().getPesoField().getText());

			Prato prato = new Prato();
			prato.setId(telaPrincipal.getPainelEstoque().getTabela().getSelectedRow()+1);
			prato.setNome(nome);
			prato.setPreco(preco);
			prato.setDescricao(descricao);
			prato.setPeso(peso);
			try {
				fachada.alterarPrato(prato);
				Estoque estoque = new Estoque(fachada.procurarPratoPorNome(nome).get(0).getId(), new Date(), controleLogin.usuarioLogado.getId(), "ALTERAÇÃO/PRATO");
				fachada.registrarEstoque(estoque);
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			telaPrincipal.getPainelEstoque().getTelaEstoque().setVisible(false);
		}
		
		if (telaPrincipal.getPainelConta().getAlterarNomeButton() == arg0.getSource()) {
			Usuario usuario = new Usuario();
			String login = telaLogin.getLoginField().getText();
			String senha = new String(telaLogin.getSenhaField().getPassword()).trim();
			for (Usuario u : fachada.listarTodosUsuarios()) {
				if (u.getLogin().equals(login) && u.getSenha().equals(senha)) {
					usuario = u;
				}
			}
			telaPrincipal.getPainelConta().getNomeField().setText(usuario.getNome());
			telaPrincipal.getPainelConta().getNomeField().setEnabled(true);
			telaPrincipal.getPainelConta().getConfirmarAlterarNomeButton().setEnabled(true);
		}
		
		if (telaPrincipal.getPainelConta().getAlterarSenhaButton() == arg0.getSource()) {	
			telaPrincipal.getPainelConta().getConfirmarAlterarSenhaButton().setEnabled(true);
			telaPrincipal.getPainelConta().getSenhaAntigaField().setEnabled(true);
			telaPrincipal.getPainelConta().getSenhaField().setEnabled(true);
			telaPrincipal.getPainelConta().getConfirmarSenhaField().setEnabled(true);
		}
		
		if(telaPrincipal.getPainelConta().getConfirmarAlterarNomeButton() == arg0.getSource()) {
			String nome = telaPrincipal.getPainelConta().getNomeField().getText();
			try {
				fachada.alterarNomeUsuario(nome, controleLogin.usuarioLogado.getId());
				telaPrincipal.getPainelConta().getNomeField().setText("");
				telaPrincipal.getPainelConta().getNomeField().setEnabled(false);
				telaPrincipal.getPainelConta().getConfirmarAlterarNomeButton().setEnabled(false);
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(telaPrincipal.getPainelConta().getConfirmarAlterarSenhaButton() == arg0.getSource()) {
			String antigaSenha = new String(telaPrincipal.getPainelConta().getSenhaAntigaField().getPassword()).trim();
			String novaSenha = new String(telaPrincipal.getPainelConta().getSenhaField().getPassword()).trim();
			String confirmarNovaSenha = new String(telaPrincipal.getPainelConta().getConfirmarSenhaField().getPassword()).trim();
			
			Usuario user = new Usuario("", "", controleLogin.usuarioLogado.getLogin(), antigaSenha);
			telaPrincipal.getPainelConta().concertarMensagemErro();
			try {
				if (fachada.verificarUsuario(user)) {
					if (novaSenha.equals(confirmarNovaSenha)) {
						fachada.alterarSenhaUsuario(novaSenha, controleLogin.usuarioLogado.getId());
						telaPrincipal.getPainelConta().getConfirmarAlterarSenhaButton().setEnabled(false);
						telaPrincipal.getPainelConta().getSenhaAntigaField().setText("");
						telaPrincipal.getPainelConta().getSenhaAntigaField().setEnabled(false);
						telaPrincipal.getPainelConta().getSenhaField().setText("");
						telaPrincipal.getPainelConta().getSenhaField().setEnabled(false);
						telaPrincipal.getPainelConta().getConfirmarSenhaField().setText("");
						telaPrincipal.getPainelConta().getConfirmarSenhaField().setEnabled(false);
					}
				}
			} catch (BusinessException e) {
				telaPrincipal.getPainelConta().escreverMensagemErro(e.getMessage());
				e.printStackTrace();
			}
			
		}
		
		if(telaPrincipal.getPainelConta().getSairButton() == arg0.getSource()) {
			telaPrincipal.setVisible(false);
			telaLogin.setVisible(true);
			telaLogin.getLoginField().setText("");
			telaLogin.getSenhaField().setText("");
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
		if (telaPrincipal.getPedidoLabel() == arg0.getSource()) {
			telaPrincipal.getPainelPedidos().setVisible(true);
			telaPrincipal.getPainelPromocoes().setVisible(false);
			telaPrincipal.getPainelFinanceiro().setVisible(false);
			telaPrincipal.getPainelEstoque().setVisible(false);
			telaPrincipal.getPainelRelatorio().setVisible(false);
			telaPrincipal.getPainelConfiguracoes().setVisible(false);
			telaPrincipal.getPainelConta().setVisible(false);
			
		}
		
		if (telaPrincipal.getPromocoesLabel() == arg0.getSource()) {
			telaPrincipal.getPainelPedidos().setVisible(false);
			telaPrincipal.getPainelPromocoes().setVisible(true);
			telaPrincipal.getPainelFinanceiro().setVisible(false);
			telaPrincipal.getPainelEstoque().setVisible(false);
			telaPrincipal.getPainelRelatorio().setVisible(false);
			telaPrincipal.getPainelConfiguracoes().setVisible(false);
			telaPrincipal.getPainelConta().setVisible(false);
		}
		
		if (telaPrincipal.getFinanceiroLabel() == arg0.getSource()) {
			telaPrincipal.getPainelPedidos().setVisible(false);
			telaPrincipal.getPainelPromocoes().setVisible(false);
			telaPrincipal.getPainelFinanceiro().setVisible(true);
			telaPrincipal.getPainelEstoque().setVisible(false);
			telaPrincipal.getPainelRelatorio().setVisible(false);
			telaPrincipal.getPainelConfiguracoes().setVisible(false);
			telaPrincipal.getPainelConta().setVisible(false);
		}
		
		if (telaPrincipal.getEstoqueLabel() == arg0.getSource()) {
			telaPrincipal.getPainelPedidos().setVisible(false);
			telaPrincipal.getPainelPromocoes().setVisible(false);
			telaPrincipal.getPainelFinanceiro().setVisible(false);
			telaPrincipal.getPainelEstoque().setVisible(true);
			telaPrincipal.getPainelRelatorio().setVisible(false);
			telaPrincipal.getPainelConfiguracoes().setVisible(false);
			telaPrincipal.getPainelConta().setVisible(false);
		}
		
		if (telaPrincipal.getRelatorioLabel() == arg0.getSource()) {
			telaPrincipal.getPainelPedidos().setVisible(false);
			telaPrincipal.getPainelPromocoes().setVisible(false);
			telaPrincipal.getPainelFinanceiro().setVisible(false);
			telaPrincipal.getPainelEstoque().setVisible(false);
			telaPrincipal.getPainelRelatorio().setVisible(true);
			telaPrincipal.getPainelConfiguracoes().setVisible(false);
			telaPrincipal.getPainelConta().setVisible(false);
		}
		
		if (telaPrincipal.getConfiguracoesLabel() == arg0.getSource()) {
			telaPrincipal.getPainelPedidos().setVisible(false);
			telaPrincipal.getPainelPromocoes().setVisible(false);
			telaPrincipal.getPainelFinanceiro().setVisible(false);
			telaPrincipal.getPainelEstoque().setVisible(false);
			telaPrincipal.getPainelRelatorio().setVisible(false);
			telaPrincipal.getPainelConfiguracoes().setVisible(true);
			telaPrincipal.getPainelConta().setVisible(false);
		}
		
		if (telaPrincipal.getPerfilLabel() == arg0.getSource()) {
			telaPrincipal.getPainelPedidos().setVisible(false);
			telaPrincipal.getPainelPromocoes().setVisible(false);
			telaPrincipal.getPainelFinanceiro().setVisible(false);
			telaPrincipal.getPainelEstoque().setVisible(false);
			telaPrincipal.getPainelRelatorio().setVisible(false);
			telaPrincipal.getPainelConfiguracoes().setVisible(false);
			Usuario usuario = new Usuario();
			String login = telaLogin.getLoginField().getText();
			String senha = new String(telaLogin.getSenhaField().getPassword()).trim();
			for (Usuario u : fachada.listarTodosUsuarios()) {
				if (u.getLogin().equals(login) && u.getSenha().equals(senha)) {
					usuario = u;
				}
			}
			int id = fachada.registrosUsuario(usuario.getId());
			telaPrincipal.getPainelConta().desenharDados(usuario, id);
			telaPrincipal.getPainelConta().setVisible(true);
		}
		
		for (JLabel mesaLabel : telaPrincipal.getPainelPedidos().getMesas()) {
			if (mesaLabel == arg0.getSource()) {
				mesaClicada = true;
				index = telaPrincipal.getPainelPedidos().getMesas().indexOf(mesaLabel);
				String operador = fachada.pegarNomeUsuario(controleLogin.usuarioLogado.getLogin());
				telaPrincipal.getPainelPedidos().desenharComponetesComanda(index+1, comandas.get(index), operador);
				telaPrincipal.getPainelPedidos().criarTabelaPrato(comandas.get(index).getPratos());
				telaPrincipal.getPainelPedidos().criarTabelaProduto(comandas.get(index).getProdutos());
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
