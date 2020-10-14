package br.com.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JLabel;

import br.com.exception.BusinessException;
import br.com.exception.ControllerException;
import br.com.fachada.Fachada;
import br.com.model.Comanda;
import br.com.model.Prato;
import br.com.model.Produto;
import br.com.view.TelaLogin;
import br.com.view.TelaPrincipal;

public class ControlePrincipal implements ActionListener, MouseListener{
	
	private Fachada fachada;
	private ControleLogin controleLogin;
	private TelaLogin telaLogin;
	private TelaPrincipal telaPrincipal;
	private ArrayList<Comanda> comandas = new ArrayList<>();
	private ArrayList<Produto> produtos;
	private int index;
	
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
		
		telaPrincipal.getPainelConta().getSairButton().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(telaPrincipal.getPainelPedidos().getAdicionarButton() == arg0.getSource()) {
//			ArrayList<Prato> pratos = new ArrayList<>();
//			ArrayList<Produto> produtos = new ArrayList<>();
//			Prato prato = new Prato("Feijoada", 17.5f,"Feijoada", 0.5f);
//			pratos.add(prato);
//			Produto produto = new Produto("Bala", 0.1f, "Bala de goma", 0.01f, new Date(), 50);
//			produtos.add(produto);
//			telaPrincipal.getPainelPedidos().criarTabela(pratos, produtos);
			telaPrincipal.getPainelPedidos().getTelaComanda().ligarPainelAdicionar();
		}
		
		if(telaPrincipal.getPainelPedidos().getRemoverButton() == arg0.getSource()) {
//			telaPrincipal.getPainelPedidos().criarTabela(null, null);
			telaPrincipal.getPainelPedidos().getTelaComanda().ligarPainelRemover();
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
			if (nomeCliente.equals("")) {
				telaPrincipal.getPainelPedidos().escreverMensagemErro();
			} else {
				
				telaPrincipal.getPainelPedidos().corrigirMensagemErro();
				comandas.get(index).setNome_cliente(nomeCliente);
			}
		}
		
		if(telaPrincipal.getPainelPedidos().getTelaComanda().getPainelAdicionar().getProdutoButton().isSelected()) {
			if (telaPrincipal.getPainelPedidos().getTelaComanda().getPainelAdicionar().getPesquisarButton() == arg0.getSource()) {
				String pesquisa = telaPrincipal.getPainelPedidos().getTelaComanda().getPainelAdicionar().getPesquisarField().getText();
				try {
					produtos = fachada.procurarProdutoPorNome(pesquisa);
				} catch (BusinessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				telaPrincipal.getPainelPedidos().getTelaComanda().getPainelAdicionar().getModelo().setNumRows(0);
				telaPrincipal.getPainelPedidos().getTelaComanda().getPainelAdicionar().criarTabelaProduto(produtos);
			}
		}
		
		if (telaPrincipal.getPainelPedidos().getTelaComanda().getPainelAdicionar().getAdicionarButton() == arg0.getSource()) {
			int i = telaPrincipal.getPainelPedidos().getTelaComanda().getPainelAdicionar().getTabela().getSelectedRow();
			comandas.get(index).getProdutos().add(produtos.get(i));
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
				index = telaPrincipal.getPainelPedidos().getMesas().indexOf(mesaLabel);
				String operador = fachada.pegarNomeUsuario(controleLogin.usuarioLogado.getLogin());
				telaPrincipal.getPainelPedidos().desenharComponetesComanda(index+1, comandas.get(index), operador);
				telaPrincipal.getPainelPedidos().criarTabela(comandas.get(index).getPratos(), comandas.get(index).getProdutos());
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
