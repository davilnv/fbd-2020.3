package br.com.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.com.model.Prato;
import br.com.model.Produto;

public class TelaComanda extends JFrame{
	
	private PainelAdicionar painelAdicionar;
	private PainelRemover painelRemover;
	private PainelFecharMesa painelFecharMesa;
	
	public TelaComanda() {
		setSize(500, 500);
		setLocationRelativeTo(null);
		setResizable(false);
		
		painelAdicionar = new PainelAdicionar();
		painelRemover = new PainelRemover();
		painelFecharMesa = new PainelFecharMesa();
		
		add(painelAdicionar);
		add(painelRemover);
		add(painelFecharMesa);
		
		setVisible(false);
	}
	
	public void ligarPainelAdicionar() {
		setVisible(true);
		painelAdicionar.setVisible(true);
		painelRemover.setVisible(false);
		painelFecharMesa.setVisible(false);
		setTitle("Adicionar");
	}
	
	public void ligarPainelRemover() {
		setVisible(true);
		painelRemover.setVisible(true);
		painelAdicionar.setVisible(false);
		painelFecharMesa.setVisible(false);
		setTitle("Remover");
	}
	
	public void ligarPainelFecharMesa() {
		setVisible(true);
		painelFecharMesa.setVisible(true);
		painelRemover.setVisible(false);
		painelAdicionar.setVisible(false);
		setTitle("Fechar Mesa");
	}
	
	
	
	public PainelAdicionar getPainelAdicionar() {
		return painelAdicionar;
	}

	public PainelRemover getPainelRemover() {
		return painelRemover;
	}
	
	public PainelFecharMesa getPainelFecharMesa() {
		return painelFecharMesa;
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
			g.setColor(Color.LIGHT_GRAY);
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
		
		public void criarTabelaPrato(ArrayList<Prato> pratos) {
			for (Prato prato : pratos) {
				modelo.addRow(new Object[] {prato.getNome(), prato.getPreco(), prato.getDescricao(), prato.getPeso()});
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
		
		private JTextField loginField;
		private JPasswordField senhaField;
		private JButton confirmarButton;
		
		public PainelRemover() {
			setSize(500, 500);
			setLocation(0, 0);
			setLayout(null);
			
			loginField = new JTextField();
			loginField.setBounds(100, 165, 300, 30);
			senhaField = new JPasswordField();
			senhaField.setBounds(100, 220, 300, 30);
			confirmarButton = new JButton("Confirmar");
			confirmarButton.setBounds(175, 270, 150, 30);
			
			add(loginField);
			add(senhaField);
			add(confirmarButton);
			
			setVisible(false);
		}
		
		public void escreverLogin(String login) {
			loginField.setText(login);
		}
		
		public void escreverMensagemErro() {
			Graphics g = getGraphics();
			g.setColor(Color.RED);
			g.setFont(new Font("Roboto", Font.BOLD, 15));
			g.drawString("Uma linha deve ser selecionada na tabela da comanda.", 48, 100);
		}
		
		public void corrigirMensagemErro() {
			Graphics g = getGraphics();
			g.setColor(Color.LIGHT_GRAY);
			g.fillRect(48, 87, 400, 20);
		}
		
		public void msgErroUsuario(String mensagem) {
			Graphics g = this.getGraphics();
			g.setColor(Color.LIGHT_GRAY);
			g.fillRect(48, 87, 400, 20);
			g.setColor(Color.RED);
			g.setFont(new Font("Roboto", Font.BOLD, 15));
			g.drawString(mensagem, 48, 100);
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			g.setColor(Color.LIGHT_GRAY);
			g.fillRect(0, 0, 500, 500);
			g.setColor(Color.BLACK);
			g.setFont(new Font("Roboto", Font.BOLD, 16));
			g.drawString("Login:", 100, 160);
			g.drawString("Senha:", 100, 215);
		}
		
		public JTextField getLoginField() {
			return loginField;
		}

		public JPasswordField getSenhaField() {
			return senhaField;
		}

		public JButton getConfirmarButton() {
			return confirmarButton;
		}

	}

	public class PainelFecharMesa extends JPanel {
		
		private JComboBox<String> pagamentoBox, bandeiraBox;
		private JTextField dinheiroField, cartaoField, descontoField;
		private JButton confirmarButton, atualizarButton;
		private String[] pagamentos = {"", "Dinheiro", "Cartão de Crédito", "Cartão de Débito", "Dinheiro + Cartão de Crédito", "Dinheiro + Cartão de Débito"}; 
		private String[] bandeiras = {"", "MASTERCARD", "VISA", "ELO"};
		
		public PainelFecharMesa() {
			setSize(500, 500);
			setLocation(0, 0);
			setLayout(null);
			
			ImageIcon atualizarIcon = new ImageIcon(getClass().getClassLoader().getResource("atualizar-icon.png"));
			
			pagamentoBox = new JComboBox<>(pagamentos);
			pagamentoBox.setBounds(100, 51, 300, 30);
			
			bandeiraBox = new JComboBox<>(bandeiras);
			bandeiraBox.setBounds(106, 199, 288, 20);
			bandeiraBox.setEnabled(false);

			dinheiroField = new JTextField("0.0");
			dinheiroField.setBounds(100, 115, 300, 30);
			dinheiroField.setEnabled(false);
			cartaoField = new JTextField("0.0");
			cartaoField.setBounds(106, 247, 288, 20);
			cartaoField.setEnabled(false);	
			descontoField = new JTextField("0.0");
			descontoField.setBounds(100, 305, 260, 30);
			
			confirmarButton = new JButton("Encerrar Conta");
			confirmarButton.setBounds(175, 411, 150, 30);
			atualizarButton = new JButton(atualizarIcon);
			atualizarButton.setBounds(365, 305, 30, 30);
			
			add(pagamentoBox);
			add(bandeiraBox);
			add(dinheiroField);
			add(cartaoField);
			add(descontoField);
			add(confirmarButton);
			add(atualizarButton);
			
			setVisible(false);
		}
		
		public void escreverTotal(String total, String troco) {
			Graphics g = getGraphics();
			corrigirTotal();
			g.setColor(Color.RED);
			g.setFont(new Font("Roboto", Font.BOLD, 20));
			g.drawString(total, 110, 383);
			g.drawString(troco, 260, 383);
		}
		
		public void corrigirTotal() {
			Graphics g = getGraphics();
			g.setColor(new Color(38, 67, 77));
			g.fillRect(100, 361, 145, 30);
			g.fillRect(250, 361, 145, 30);
		}
		
		public void msgErro(String mensagem) {
			Graphics g = getGraphics();
			g.setColor(Color.RED);
			g.setFont(new Font("Roboto", Font.BOLD, 13));
			g.drawString(mensagem, 80, 406);
		}
		
		public void corrigirMsgErro() {
			Graphics g = getGraphics();
			g.setColor(Color.LIGHT_GRAY);
			g.fillRect(80, 395, 400, 15);
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			g.setColor(Color.LIGHT_GRAY);
			g.fillRect(0, 0, 500, 500);
			g.setColor(Color.BLACK);
			g.setFont(new Font("Roboto", Font.BOLD, 16));
			g.drawString("Forma de pagamento (Selecione uma):", 100, 41);
			g.drawString("Dinheiro (R$):", 100, 105);
			g.drawString("Recebimentos com cartão", 100, 165);
			g.drawString("Desconto (R$):", 100, 295);
			g.fillRect(100, 175, 300, 100);
			g.setColor(Color.LIGHT_GRAY);
			g.fillRect(102, 177, 296, 96);
			g.setColor(Color.BLACK);
			g.setFont(new Font("Roboto", Font.BOLD, 12));
			g.drawString("Bandeira do Cartão:", 106, 189);
			g.drawString("Valor (R$):", 106, 235);
			g.drawString("Total Pago (R$):", 100, 355);
			g.drawString("Troco (R$):", 250, 355);
			g.setColor(new Color(38, 67, 77));
			g.fillRect(100, 361, 145, 30);
			g.fillRect(250, 361, 145, 30);
		}

		public JComboBox<String> getPagamentoBox() {
			return pagamentoBox;
		}
		
		public JComboBox<String> getBandeiraBox() {
			return bandeiraBox;
		}

		public JTextField getDinheiroField() {
			return dinheiroField;
		}

		public JButton getConfirmarButton() {
			return confirmarButton;
		}

		public String[] getPagamentos() {
			return pagamentos;
		}

		public JTextField getCartaoField() {
			return cartaoField;
		}

		public JTextField getDescontoField() {
			return descontoField;
		}

		public String[] getBandeiras() {
			return bandeiras;
		}

		public JButton getAtualizarButton() {
			return atualizarButton;
		}
		
	}

}
