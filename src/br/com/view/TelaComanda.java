package br.com.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.com.model.Produto;

public class TelaComanda extends JFrame{
	
	private PainelAdicionar painelAdicionar;
	private PainelRemover painelRemover;
	
	public TelaComanda() {
		setSize(500, 500);
		setLocationRelativeTo(null);
		setResizable(false);
		
		painelAdicionar = new PainelAdicionar();
		painelRemover = new PainelRemover();
		
		add(painelAdicionar);
		add(painelRemover);
		
		setVisible(false);
	}
	
	public void ligarPainelAdicionar() {
		setVisible(true);
		painelAdicionar.setVisible(true);
		painelRemover.setVisible(false);
		setTitle("Adicionar");
	}
	
	public void ligarPainelRemover() {
		setVisible(true);
		painelRemover.setVisible(true);
		painelAdicionar.setVisible(false);
		setTitle("Remover");
	}
	
	public PainelAdicionar getPainelAdicionar() {
		return painelAdicionar;
	}

	public PainelRemover getPainelRemover() {
		return painelRemover;
	}

	public class PainelAdicionar extends JPanel {
		
		private JTextField pesquisarField;
		private JButton pesquisarButton, adicionarButton;
		private JRadioButton produtoButton, pratoButton;
		private JTable tabela;
		private JScrollPane barraRolagem;
		private DefaultTableModel modelo = new DefaultTableModel();
		
		public PainelAdicionar() {
			setSize(500, 500);
			setLocation(0, 0);
			setLayout(null);
			
			tabela = new JTable(modelo);
			modelo.addColumn("Nome");
			modelo.addColumn("Preço");
			modelo.addColumn("Descrição");
			modelo.addColumn("Peso");
			modelo.addColumn("Validade");
			modelo.addColumn("Quant.");
			tabela.getColumnModel().getColumn(0).setPreferredWidth(170);
			tabela.getColumnModel().getColumn(1).setPreferredWidth(45);
			tabela.getColumnModel().getColumn(2).setPreferredWidth(105);
			tabela.getColumnModel().getColumn(3).setPreferredWidth(40);
			tabela.getColumnModel().getColumn(4).setPreferredWidth(85);
			tabela.getColumnModel().getColumn(5).setPreferredWidth(45);
			modelo.setNumRows(0);
			
			barraRolagem = new JScrollPane(tabela);
			barraRolagem.setBounds(5, 75, 490, 300);
			
			pesquisarField = new JTextField();
			pesquisarField.setBounds(25, 35, 300, 30);
			pesquisarButton = new JButton("Pesquisar");
			pesquisarButton.setBounds(350, 35, 120, 30);
			adicionarButton = new JButton("Adicionar Item");
			adicionarButton.setBounds(170, 395, 150, 30);
			
			ButtonGroup grupo = new ButtonGroup();
			produtoButton = new JRadioButton("Produto", true);
			produtoButton.setBounds(115, 10, 90, 20);
			pratoButton = new JRadioButton("Prato", false);
			pratoButton.setBounds(215, 10, 90, 20);
			grupo.add(produtoButton);
			grupo.add(pratoButton);
			
			add(barraRolagem);
			add(pesquisarField);
			add(pesquisarButton);
			add(produtoButton);
			add(pratoButton);
			add(adicionarButton);
			
			setVisible(false);
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, 500, 500);
			g.setColor(Color.WHITE);
			g.fillRect(5, 5, 490, 455);
			g.setColor(Color.BLACK);
			g.setFont(new Font("Roboto", Font.BOLD, 15));
			g.drawString("Pesquisar:", 25, 25);
		}
		
		public void criarTabelaProduto(ArrayList<Produto> produtos) {
			for (Produto produto : produtos) {
				modelo.addRow(new Object[] {produto.getNome(), produto.getPreco(),
						produto.getDescricao(), produto.getPeso(), 
						produto.converterDataString(produto.getValidade()), produto.getQuantidade()});
			}
		}

		public JTextField getPesquisarField() {
			return pesquisarField;
		}

		public JButton getPesquisarButton() {
			return pesquisarButton;
		}

		public JRadioButton getProdutoButton() {
			return produtoButton;
		}

		public JRadioButton getPratoButton() {
			return pratoButton;
		}

		public JButton getAdicionarButton() {
			return adicionarButton;
		}

		public JTable getTabela() {
			return tabela;
		}

		public JScrollPane getBarraRolagem() {
			return barraRolagem;
		}

		public DefaultTableModel getModelo() {
			return modelo;
		}
		
	}
	
	public class PainelRemover extends JPanel {
		
		public PainelRemover() {
			setSize(500, 500);
			setLocation(0, 0);
			
			setVisible(false);
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, 500, 500);
		}
	}
	
}
