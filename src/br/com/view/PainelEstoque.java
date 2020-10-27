package br.com.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.model.Prato;
import br.com.model.Produto;

public class PainelEstoque extends PainelGenerico{
	
	private JButton cadastrarProdutoButton, cadastrarPratoButton, atualizarButton, alterarProdutoButton, alterarPratoButton;
	private JRadioButton produtoButton, pratoButton;
	private JTable tabela;
	private JScrollPane barraRolagem;
	private DefaultTableModel modelo = new DefaultTableModel();
	private TelaEstoque telaEstoque;
	
	public PainelEstoque() {
		telaEstoque = new TelaEstoque();
		
		ImageIcon atualizarIcon = new ImageIcon(getClass().getClassLoader().getResource("atualizar-icon.png"));
		
		tabela = new JTable(modelo);
		modelo.addColumn("Id");
		modelo.addColumn("Nome");
		modelo.addColumn("Preço");
		modelo.addColumn("Descrição");
		modelo.addColumn("Peso");
		modelo.addColumn("Validade");
		modelo.addColumn("Quantidade");
		tabela.getColumnModel().getColumn(0).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(400);
		tabela.getColumnModel().getColumn(2).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(3).setPreferredWidth(466);
		tabela.getColumnModel().getColumn(4).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(5).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(6).setPreferredWidth(100);
		
		barraRolagem = new JScrollPane(tabela);
		barraRolagem.setBounds(0, 180, TelaPrincipal.LARGURA, 420);
		
		cadastrarProdutoButton = new JButton("Cadastrar Produto");
		cadastrarProdutoButton.setBounds(50, 115, 170, 30);
		cadastrarPratoButton = new JButton("Cadastrar Prato");
		cadastrarPratoButton.setBounds(230, 115, 150, 30);
		atualizarButton = new JButton("Atualizar", atualizarIcon);
		atualizarButton.setBounds(560, 115, 130, 30);
		alterarPratoButton = new JButton("Alterar Prato");
		alterarPratoButton.setBounds(700, 115, 150, 30);
		alterarProdutoButton = new JButton("Alterar Produto");
		alterarProdutoButton.setBounds(860, 115, 150, 30);
		
		produtoButton = new JRadioButton("Produto", true);
		produtoButton.setBounds(390, 120, 85, 20);
		pratoButton = new JRadioButton("Prato", false);
		pratoButton.setBounds(485, 120, 65, 20);
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(produtoButton);
		grupo.add(pratoButton);
		
		add(barraRolagem);
		add(cadastrarProdutoButton);
		add(cadastrarPratoButton);
		add(atualizarButton);
		add(alterarPratoButton);
		add(alterarProdutoButton);
		add(produtoButton);
		add(pratoButton);
	}
	
	public void criarTabelaProduto(ArrayList<Produto> produtos) {
		modelo.setNumRows(0);
		for (Produto produto : produtos) {
			modelo.addRow(new Object[] {produto.getId(), produto.getNome(), produto.getPreco(), produto.getDescricao(), produto.getPeso(), produto.converterDataString(produto.getValidade()), produto.getQuantidade()});
		}
	}
	
	public void criarTabelaPrato(ArrayList<Prato> pratos) {
		modelo.setNumRows(0);
		for (Prato prato : pratos) {
			modelo.addRow(new Object[] {prato.getId(), prato.getNome(), prato.getPreco(), prato.getDescricao(), prato.getPeso()});
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 80, TelaPrincipal.LARGURA, 688);
		g.setColor(Color.GRAY);
		g.fillRect(0, 80, TelaPrincipal.LARGURA, 100);
		g.fillRect(1015, 120, 366, 20);
		g.setFont(new Font("Roboto", Font.BOLD, 15));
		g.setColor(Color.BLACK);
		g.drawString("Registros: ", 40, 640);
		g.drawString("Último Registro: ", 150, 640);
		g.drawString("Usuário: ", 1200, 640);
		g.drawString("Data do último registro: ", 1020, 135);
	}
	
	public void pintarComponentesEstoque(int registros, String ultimoRegistro, String usuario, String data) {
		Graphics g = getGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(40, 625, 1366, 20);
		g.setColor(Color.GRAY);
		g.fillRect(1015, 120, 366, 20);
		g.setFont(new Font("Roboto", Font.BOLD, 15));
		g.setColor(Color.BLACK);
		g.drawString("Registros: "+registros, 40, 640);
		g.drawString("Último Registro: "+ultimoRegistro, 150, 640);
		g.drawString("Usuário: "+usuario, 1200, 640);
		g.drawString("Data do último registro: "+data, 1020, 135);
	}

	public JButton getCadastrarProdutoButton() {
		return cadastrarProdutoButton;
	}

	public JButton getCadastrarPratoButton() {
		return cadastrarPratoButton;
	}

	public JButton getAtualizarButton() {
		return atualizarButton;
	}
	
	public JButton getAlterarProdutoButton() {
		return alterarProdutoButton;
	}

	public JButton getAlterarPratoButton() {
		return alterarPratoButton;
	}

	public JRadioButton getProdutoButton() {
		return produtoButton;
	}

	public JRadioButton getPratoButton() {
		return pratoButton;
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

	public TelaEstoque getTelaEstoque() {
		return telaEstoque;
	}
	
}
