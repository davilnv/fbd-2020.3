package br.com.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JLabel;

import br.com.exception.BusinessException;
import br.com.exception.ModelException;
import br.com.fachada.Fachada;
import br.com.model.Codigo;
import br.com.model.Comanda;
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
