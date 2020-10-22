package br.com.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.com.model.Comanda;
import br.com.model.Prato;
import br.com.model.Produto;

public class PainelPedidos extends PainelGenerico{
	private ArrayList<JLabel> mesas = new ArrayList<>();
	private ImageIcon mesaIcon = new ImageIcon(getClass().getClassLoader().getResource("mesa-icon.png"));
	private JLabel nomeClienteLabel;
	private JTextField nomeClienteField;
	private JButton adicionarButton, removerButton, abrirMesa, fecharMesaButton, okButton;
	private TelaComanda telaComanda;
	private JTable tabelaProduto, tabelaPrato;
	private JScrollPane barraRolagemProduto, barraRolagemPrato;
	private DefaultTableModel modeloProduto = new DefaultTableModel();
	private DefaultTableModel modeloPrato = new DefaultTableModel();
	
	public PainelPedidos() {
		ImageIcon addIcon = new ImageIcon(getClass().getClassLoader().getResource("add-icon.png"));
		ImageIcon removerIcon = new ImageIcon(getClass().getClassLoader().getResource("remover-icon.png"));
		ImageIcon fecharMesaIcon = new ImageIcon(getClass().getClassLoader().getResource("fecha-icon.png"));
		ImageIcon abrirMesaIcon = new ImageIcon(getClass().getClassLoader().getResource("abrir-icon.png"));
		
		criarColunasMesas();
		telaComanda = new TelaComanda();
		
		tabelaProduto = new JTable(modeloProduto);
		tabelaPrato = new JTable(modeloPrato);
		modeloProduto.addColumn("Nome (Produto)");
		modeloProduto.addColumn("Preço");
		modeloProduto.addColumn("Peso");
		tabelaProduto.getColumnModel().getColumn(0).setPreferredWidth(170);
		tabelaProduto.getColumnModel().getColumn(1).setPreferredWidth(45);
		tabelaProduto.getColumnModel().getColumn(2).setPreferredWidth(40);
		modeloPrato.addColumn("Nome (Prato)");
		modeloPrato.addColumn("Preço");
		modeloPrato.addColumn("Peso");
		tabelaPrato.getColumnModel().getColumn(0).setPreferredWidth(170);
		tabelaPrato.getColumnModel().getColumn(1).setPreferredWidth(45);
		tabelaPrato.getColumnModel().getColumn(2).setPreferredWidth(40);
		modeloProduto.setNumRows(0);
		modeloPrato.setNumRows(0);
		
		barraRolagemProduto = new JScrollPane(tabelaProduto);
		barraRolagemProduto.setBounds(1055, 315, 255, 100);
		
		barraRolagemPrato = new JScrollPane(tabelaPrato);
		barraRolagemPrato.setBounds(1055, 415, 255, 85);
		
		adicionarButton = new JButton(addIcon);
		adicionarButton.setBounds(1065, 535, 30, 30);
		removerButton = new JButton(removerIcon);
		removerButton.setBounds(1105, 535, 30, 30);
		abrirMesa = new JButton("Abrir Mesa", abrirMesaIcon);
		abrirMesa.setBounds(50, 115, 140, 30);
		fecharMesaButton = new JButton("Fechar Mesa", fecharMesaIcon);
		fecharMesaButton.setBounds(1145, 535, 150, 30);
		okButton = new JButton("Ok");
		okButton.setBounds(540, 115, 60, 30);
		okButton.setVisible(false);
		
		nomeClienteLabel = new JLabel("Nome do cliente:");
		nomeClienteLabel.setBounds(200, 120, 120, 20);
		nomeClienteLabel.setVisible(false);
		nomeClienteField = new JTextField();
		nomeClienteField.setBounds(330, 115, 200, 30);
		nomeClienteField.setVisible(false);
		
		add(barraRolagemProduto);
		add(barraRolagemPrato);
		add(adicionarButton);
		add(removerButton);
		add(abrirMesa);
		add(fecharMesaButton);
		add(okButton);
		add(nomeClienteLabel);
		add(nomeClienteField);
		
		setVisible(true);
	}
	
	public void criarTabelaProduto(ArrayList<Produto> produtos) {
		modeloProduto.setNumRows(0);
		for (Produto produto : produtos) {
			modeloProduto.addRow(new Object[] {produto.getNome(), produto.getPreco(), produto.getPeso()});
		}
	}
	
	public void criarTabelaPrato(ArrayList<Prato> pratos) {
		modeloPrato.setNumRows(0);
		for (Prato prato : pratos) {
			modeloPrato.addRow(new Object[] {prato.getNome(), prato.getPreco(), prato.getPeso()});
		}
	}

	public void colunaMesas(int x) {
		int cont = 130;
		for(int i = 0; i<=3; i++) {
			JLabel mesa = new JLabel(mesaIcon);
			cont= cont + 100;
			mesa.setBounds(x, cont, 50, 50);
			add(mesa);
			mesas.add(mesa);
		}
	}
	
	public void criarColunasMesas() {
		colunaMesas(50);
		colunaMesas(150);
		colunaMesas(250);
		colunaMesas(350);
		colunaMesas(450);
		colunaMesas(550);
		colunaMesas(650);
		colunaMesas(750);
		colunaMesas(850);
		colunaMesas(950);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 80, TelaPrincipal.LARGURA, 700);
		g.setColor(Color.GRAY);
		g.fillRect(0, 80, TelaPrincipal.LARGURA, 100);
		g.fillRect(1050, 230, 266, 350);
		g.setColor(Color.WHITE);
		g.fillRect(1055, 235, 255, 340);

		g.setFont(new Font("Roboto", Font.BOLD, 15));
		
		g.setColor(Color.DARK_GRAY);
		g.fillRect(1216, 95, 50, 50);
		g.drawImage(mesaIcon.getImage(), 1216, 95, null);
		g.setColor(Color.BLACK);
		g.drawString("Manutenção", 1197, 165);
		
		g.setColor(Color.YELLOW);
		g.fillRect(1116, 95, 50, 50);
		g.drawImage(mesaIcon.getImage(), 1116, 95, null);
		g.setColor(Color.BLACK);
		g.drawString("Reserva", 1111, 165);
		
		g.setColor(Color.ORANGE);
		g.fillRect(1016, 95, 50, 50);
		g.drawImage(mesaIcon.getImage(), 1016, 95, null);
		g.setColor(Color.BLACK);
		g.drawString("Limpeza", 1011, 165);
		
		g.setColor(Color.RED);
		g.fillRect(916, 95, 50, 50);
		g.drawImage(mesaIcon.getImage(), 916, 95, null);
		g.setColor(Color.BLACK);
		g.drawString("Em uso", 915, 165);
		
		g.setColor(Color.GREEN);
		g.fillRect(816, 95, 50, 50);
		g.drawImage(mesaIcon.getImage(), 816, 95, null);
		g.setColor(Color.BLACK);
		g.drawString("Livre", 823, 165);
		
		for (int i = 0; i <= mesas.size()-1; i++) {
			g.setColor(Color.GREEN);
			int x = mesas.get(i).getX();
			int y = mesas.get(i).getY();
			g.fillRect(x, y, 50, 50);
		}
		
		for (int i = 0; i <= mesas.size()-1; i++) {
			int x = mesas.get(i).getX();
			int y = mesas.get(i).getY();
			int n = i+1;
			if (n <10) {
				g.setColor(Color.BLACK);
				g.drawString("0"+n, x+15, y-5);
			} else {				
				g.setColor(Color.BLACK);
				g.drawString(""+n, x+15, y-5);
			}
		}
		
		desenharComanda(g);
		
		g.setColor(Color.RED);
		g.drawString("Para atualizar os dados da comanda, clique novamente na mesa correspondente a comanda.", 50, 630);
		
	}
	
	private void desenharComanda(Graphics g) {
		g.drawRect(1055, 235, 100, 40);
		g.drawRect(1155, 235, 155, 40);
		g.drawRect(1055, 275, 127, 40);
		g.drawRect(1182, 275, 128, 40);
		g.drawRect(1055, 315, 255, 185);
		g.drawRect(1055, 500, 255, 25);
		g.drawRect(1055, 525, 255, 50);
		g.drawString("Mesa: ", 1070, 260);
		g.setFont(new Font("Roboto", Font.BOLD, 13));
		g.drawString("Código: ", 1160, 260);
		g.setFont(new Font("Roboto", Font.BOLD, 15));
		g.drawString("Operador:", 1060, 290);
		g.drawString("Cliente:", 1187, 290);
		g.drawString("Total (R$):", 1060, 518);
	}
	
	public void desenharComponetesComanda(int numero, Comanda comanda, String operador) {
		Graphics g = getGraphics();
		g.setFont(new Font("Roboto", Font.BOLD, 15));
		g.setColor(Color.WHITE);
		g.fillRect(1120, 245, 30, 30);
		g.fillRect(1216, 250, 90, 10);
		g.fillRect(1187, 298, 120, 12);
		g.fillRect(1150, 505, 150, 20);

		g.setColor(Color.BLACK);
		if (numero < 10) {
			g.drawString("0"+numero, 1120, 260);
		} else {
			g.drawString(""+numero, 1120, 260);
		}
		if (comanda.getNome_cliente() != null) {
			g.drawString(comanda.getNome_cliente(), 1187, 310);
		} 
		g.setFont(new Font("Roboto", Font.BOLD, 13));
		g.drawString(comanda.getCódigo(), 1216, 260);
		g.drawString(operador, 1060, 310);
		g.drawString(""+comanda.getTotal(), 1150, 518);
	}

	public void escreverMensagemErro() {
		Graphics g = getGraphics();
		g.setColor(Color.RED);
		g.setFont(new Font("Roboto", Font.BOLD, 11));
		g.drawString("Selecione uma mesa e digite um nome", 330, 160);
	}
	
	public void corrigirMensagemErro() {
		Graphics g = getGraphics();
		g.setColor(Color.GRAY);
		g.fillRect(330, 145, 225, 20);
	}
	
	public ArrayList<JLabel> getMesas() {
		return mesas;
	}

	public JLabel getNomeClienteLabel() {
		return nomeClienteLabel;
	}

	public JTextField getNomeClienteField() {
		return nomeClienteField;
	}

	public JButton getAdicionarButton() {
		return adicionarButton;
	}

	public JButton getRemoverButton() {
		return removerButton;
	}

	public JButton getOkButton() {
		return okButton;
	}

	public JButton getAbrirMesaButton() {
		return abrirMesa;
	}

	public JButton getFecharMesaButton() {
		return fecharMesaButton;
	}
	
	public TelaComanda getTelaComanda() {
		return telaComanda;
	}

	public JTable getTabelaProduto() {
		return tabelaProduto;
	}
	
	public JTable getTabelaPrato() {
		return tabelaPrato;
	}

	public DefaultTableModel getModeloProduto() {
		return modeloProduto;
	}
	
	public DefaultTableModel getModeloPrato() {
		return modeloPrato;
	}

}
