package br.com.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaEstoque extends JFrame{
	private PainelCadastrarProduto painelCadastrarProduto;
	private PainelCadastrarPrato painelCadastrarPrato;
	private PainelAlterarPrato painelAlterarPrato;
	private PainelAlterarProduto painelAlterarProduto;
	
	public TelaEstoque() {
		setSize(500, 500);
		setLocationRelativeTo(null);
		setResizable(false);

		painelCadastrarProduto = new PainelCadastrarProduto();
		painelCadastrarPrato = new PainelCadastrarPrato();
		painelAlterarPrato = new PainelAlterarPrato();
		painelAlterarProduto = new PainelAlterarProduto();
		
		add(painelCadastrarProduto);
		add(painelCadastrarPrato);
		add(painelAlterarPrato);
		add(painelAlterarProduto);
		
		setVisible(false);
	}

	public void ligarPainelCadastrarProduto(String titulo) {
		setVisible(true);
		painelCadastrarProduto.setVisible(true);
		painelCadastrarPrato.setVisible(false);
		setTitle(titulo);
	}
	
	public void ligarPainelCadastrarPrato(String titulo) {
		setVisible(true);
		painelCadastrarPrato.setVisible(true);
		painelCadastrarProduto.setVisible(false);
		setTitle(titulo);
	}
	
	public void ligarPainelAlterarProduto(String titulo) {
		setVisible(true);
		painelAlterarProduto.setVisible(true);
		painelAlterarPrato.setVisible(false);
		setTitle(titulo);
	}
	
	public void ligarPainelAlterarPrato(String titulo) {
		setVisible(true);
		painelAlterarPrato.setVisible(true);
		painelAlterarProduto.setVisible(false);
		setTitle(titulo);
	}
	
	public class PainelCadastrarProduto extends JPanel{
		private JTextField nomeField, precoField, descricaoField, pesoField, validadeField, quantidadeField;
		private JButton confirmarButton;
		
		public PainelCadastrarProduto() {
			setSize(500, 500);
			setLocation(0, 0);
			setLayout(null);
			
			nomeField = new JTextField();
			nomeField.setBounds(190, 70, 270, 30);
			precoField = new JTextField("0.0");
			precoField.setBounds(130, 130, 120, 30);
			pesoField = new JTextField("0.0");
			pesoField.setBounds(340, 130, 120, 30);
			descricaoField = new JTextField();
			descricaoField.setBounds(130, 190, 330, 30);
			validadeField = new JTextField("22/10/2020");
			validadeField.setHorizontalAlignment(JTextField.CENTER);
			validadeField.setFont(new Font("Dialog", Font.BOLD, 16));
			validadeField.setBounds(290, 250, 170, 30);
			quantidadeField = new JTextField("0");
			quantidadeField.setBounds(200, 310, 200, 30);
			
			confirmarButton = new JButton("Confirmar Cadastro");
			confirmarButton.setBounds(160, 370, 180, 30);
			
			add(nomeField);
			add(precoField);
			add(pesoField);
			add(descricaoField);
			add(validadeField);
			add(quantidadeField);
			add(confirmarButton);
			
			setVisible(false);
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			g.setColor(Color.LIGHT_GRAY);
			g.fillRect(0, 0, 500, 500);
			g.setColor(Color.BLACK);
			g.setFont(new Font("Roboto", Font.BOLD, 15));
			g.drawString("Nome do Produto: ", 40, 90);
			g.drawString("Preço (R$): ", 40, 150);
			g.drawString("Peso (kg): ", 260, 150);
			g.drawString("Descrição: ", 40, 210);
			g.drawString("Data de Validade (dd/mm/aaaa): ", 40, 270);
			g.drawString("Quantidade: ", 100, 330);
		}

		public void escreverMensagemErro(String mensagem) {
			Graphics g = getGraphics();
			g.setColor(Color.RED);
			g.setFont(new Font("Roboto", Font.BOLD, 15));
			g.drawString(mensagem, 100, 420);
		}
		
		public void corrigirMensagemErro() {
			Graphics g = getGraphics();
			g.setColor(Color.LIGHT_GRAY);
			g.fillRect(100, 405, 320, 20);
		}
		
		public JTextField getNomeField() {
			return nomeField;
		}

		public JTextField getPrecoField() {
			return precoField;
		}

		public JTextField getDescricaoField() {
			return descricaoField;
		}

		public JTextField getPesoField() {
			return pesoField;
		}

		public JTextField getValidadeField() {
			return validadeField;
		}

		public JTextField getQuantidadeField() {
			return quantidadeField;
		}

		public JButton getConfirmarButton() {
			return confirmarButton;
		}
		
	}

	public class PainelCadastrarPrato extends JPanel{
		private JTextField nomeField, precoField, descricaoField, pesoField;
		private JButton confirmarButton;
		
		public PainelCadastrarPrato() {
			setSize(500, 500);
			setLocation(0, 0);
			setLayout(null);
			
			nomeField = new JTextField();
			nomeField.setBounds(190, 145, 270, 30);
			precoField = new JTextField("0.0");
			precoField.setBounds(130, 205, 120, 30);
			pesoField = new JTextField("0.0");
			pesoField.setBounds(340, 205, 120, 30);
			descricaoField = new JTextField();
			descricaoField.setBounds(130, 265, 330, 30);
			
			confirmarButton = new JButton("Confirmar Cadastro");
			confirmarButton.setBounds(160, 325, 180, 30);
			
			add(nomeField);
			add(precoField);
			add(pesoField);
			add(descricaoField);
			add(confirmarButton);
			
			setVisible(false);
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			g.setColor(Color.LIGHT_GRAY);
			g.fillRect(0, 0, 500, 500);
			g.setColor(Color.BLACK);
			g.setFont(new Font("Roboto", Font.BOLD, 15));
			g.drawString("Nome do Prato: ", 40, 165);
			g.drawString("Preço (R$): ", 40, 225);
			g.drawString("Peso (kg): ", 260, 225);
			g.drawString("Descrição: ", 40, 285);
		}
		
		public void escreverMensagemErro(String mensagem) {
			Graphics g = getGraphics();
			g.setColor(Color.RED);
			g.setFont(new Font("Roboto", Font.BOLD, 15));
			g.drawString(mensagem, 100, 420);
		}
		
		public void corrigirMensagemErro() {
			Graphics g = getGraphics();
			g.setColor(Color.LIGHT_GRAY);
			g.fillRect(100, 405, 320, 20);
		}
		
		public JTextField getNomeField() {
			return nomeField;
		}

		public JTextField getPrecoField() {
			return precoField;
		}

		public JTextField getDescricaoField() {
			return descricaoField;
		}

		public JTextField getPesoField() {
			return pesoField;
		}

		public JButton getConfirmarButton() {
			return confirmarButton;
		}
		
	}
	
	public class PainelAlterarProduto extends PainelCadastrarProduto {}
	
	public class PainelAlterarPrato extends PainelCadastrarPrato {}
	
	public PainelCadastrarProduto getPainelCadastrarProduto() {
		return painelCadastrarProduto;
	}
	
	public PainelCadastrarPrato getPainelCadastrarPrato() {
		return painelCadastrarPrato;
	}

	public PainelAlterarPrato getPainelAlterarPrato() {
		return painelAlterarPrato;
	}

	public PainelAlterarProduto getPainelAlterarProduto() {
		return painelAlterarProduto;
	}
	
}
