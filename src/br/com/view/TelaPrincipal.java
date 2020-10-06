package br.com.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaPrincipal extends TelaGenerica{
	private PainelPrincipal painelPrincipal;
	private PainelPedidos painelPedidos;
	private PainelPromocoes painelPromocoes;
	private PainelFinanceiro painelFinanceiro;
	private PainelEstoque painelEstoque;
	private PainelRelatorio painelRelatorio;
	private PainelConfiguracoes painelConfiguracoes;
	private PainelConta painelConta;
	private JLabel pedidoLabel, promocoesLabel, financeiroLabel, estoqueLabel, relatorioLabel, configuracoesLabel, perfilLabel;
	
	public TelaPrincipal(String titulo) {
		super(titulo);
		
		painelPrincipal = new PainelPrincipal();
		painelPedidos = new PainelPedidos();
		painelPromocoes = new PainelPromocoes();
		painelFinanceiro = new PainelFinanceiro();
		painelEstoque = new PainelEstoque();
		painelRelatorio = new PainelRelatorio();
		painelConfiguracoes = new PainelConfiguracoes();
		painelConta = new PainelConta();
		
		ImageIcon pedidoIcon = new ImageIcon(getClass().getClassLoader().getResource("icone-1.png"));
		ImageIcon promocoesIcon = new ImageIcon(getClass().getClassLoader().getResource("icone-2.png"));
		ImageIcon financeiroIcon = new ImageIcon(getClass().getClassLoader().getResource("icone-3.png"));
		ImageIcon estoqueIcon = new ImageIcon(getClass().getClassLoader().getResource("icone-4.png"));
		ImageIcon relatorioIcon = new ImageIcon(getClass().getClassLoader().getResource("icone-5.png"));
		ImageIcon configuracoesIcon = new ImageIcon(getClass().getClassLoader().getResource("icone-6.png"));
		ImageIcon perfilIcon = new ImageIcon(getClass().getClassLoader().getResource("icone-perfil.png"));
		
		pedidoLabel = new JLabel(pedidoIcon);
		pedidoLabel.setBounds(50, 5, 50, 50);
		
		promocoesLabel = new JLabel(promocoesIcon);
		promocoesLabel.setBounds(150, 5, 50, 50);
		
		financeiroLabel = new JLabel(financeiroIcon);
		financeiroLabel.setBounds(250, 5, 50, 50);
		
		estoqueLabel = new JLabel(estoqueIcon);
		estoqueLabel.setBounds(350, 5, 50, 50);
		
		relatorioLabel = new JLabel(relatorioIcon);
		relatorioLabel.setBounds(450, 5, 50, 50);
		
		configuracoesLabel = new JLabel(configuracoesIcon);
		configuracoesLabel.setBounds(550, 5, 50, 50);
		
		perfilLabel = new JLabel(perfilIcon);
		perfilLabel.setBounds(1166, 12, 150, 50);
		
		add(pedidoLabel);
		add(promocoesLabel);
		add(financeiroLabel);
		add(estoqueLabel);
		add(relatorioLabel);
		add(configuracoesLabel);
		add(perfilLabel);
		add(painelPedidos);
		add(painelPromocoes);
		add(painelFinanceiro);
		add(painelEstoque);
		add(painelRelatorio);
		add(painelConfiguracoes);
		add(painelConta);
		add(painelPrincipal);
		
	}

	public PainelPrincipal getPainelPrincipal() {
		return painelPrincipal;
	}

	public PainelPedidos getPainelPedidos() {
		return painelPedidos;
	}

	public PainelPromocoes getPainelPromocoes() {
		return painelPromocoes;
	}

	public PainelFinanceiro getPainelFinanceiro() {
		return painelFinanceiro;
	}

	public PainelEstoque getPainelEstoque() {
		return painelEstoque;
	}

	public PainelRelatorio getPainelRelatorio() {
		return painelRelatorio;
	}

	public PainelConfiguracoes getPainelConfiguracoes() {
		return painelConfiguracoes;
	}

	public PainelConta getPainelConta() {
		return painelConta;
	}

	public JLabel getPedidoLabel() {
		return pedidoLabel;
	}

	public JLabel getPromocoesLabel() {
		return promocoesLabel;
	}

	public JLabel getFinanceiroLabel() {
		return financeiroLabel;
	}

	public JLabel getEstoqueLabel() {
		return estoqueLabel;
	}

	public JLabel getRelatorioLabel() {
		return relatorioLabel;
	}

	public JLabel getConfiguracoesLabel() {
		return configuracoesLabel;
	}

	public JLabel getPerfilLabel() {
		return perfilLabel;
	}

	public class PainelPrincipal extends JPanel{
		
		public PainelPrincipal() {
			setSize(LARGURA, 688);
			setLocation(0, 0);
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			g.setColor(new Color(38, 67, 77));
			g.fillRect(0, 0, LARGURA, 80);
			g.setColor(Color.BLACK);
			g.setFont(new Font("Roboto", Font.BOLD, 14));
			g.drawString("Pedidos", 47, 70);
			g.drawString("Promoções", 135, 70);
			g.drawString("Financeiro", 240, 70);
			g.drawString("Estoque", 347, 70);
			g.drawString("Relatório", 442, 70);
			g.drawString("Configurações", 527, 70);
		}
	}
	
}
