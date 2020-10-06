package br.com.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JLabel;

import br.com.fachada.Fachada;
import br.com.model.Comanda;
import br.com.view.TelaLogin;
import br.com.view.TelaPrincipal;

public class ControlePrincipal implements ActionListener, MouseListener{
	
	private Fachada fachada;
	private TelaLogin telaLogin;
	private TelaPrincipal telaPrincipal;
	private ArrayList<Comanda> comandas = new ArrayList<>(); 
	
	public ControlePrincipal(Fachada fachada, TelaLogin telaLogin, TelaPrincipal telaPrincipal) {
		this.fachada = fachada;
		this.telaLogin = telaLogin;
		this.telaPrincipal = telaPrincipal;
		
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
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(telaPrincipal.getPainelPedidos().getAdicionarButton() == arg0.getSource()) {
//			telaPrincipal.getPainelPedidos().criarTabela(null, null);
			telaPrincipal.getPainelPedidos().getTelaComanda().ligarPainelAdicionar();
		}
		
		if(telaPrincipal.getPainelPedidos().getRemoverButton() == arg0.getSource()) {
//			telaPrincipal.getPainelPedidos().criarTabela(null, null);
			telaPrincipal.getPainelPedidos().getTelaComanda().ligarPainelRemover();
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
				int index = telaPrincipal.getPainelPedidos().getMesas().indexOf(mesaLabel);
				telaPrincipal.getPainelPedidos().desenharComponetesComanda(index+1, comandas.get(index));
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
