package br.com.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class TelaCadastro extends JFrame{
	
	private JTextField nomeField, cpfField, loginField;
	private JPasswordField senhaField, confirmarSenhaField;
	private JButton cadastrarButton;
	private Painel painel;
	
	public TelaCadastro() {
		super("Tela de Cadastro");
		setSize(1366, 768);
		setLocation(0, 0);
		setLayout(null);
		
		painel = new Painel();
		
		nomeField = new JTextField();
		nomeField.setBounds(583, 140, 200, 30);
		cpfField = new JTextField();
		cpfField.setBounds(583, 210, 200, 30);
		loginField = new JTextField();
		loginField.setBounds(583, 280, 200, 30);
		senhaField = new JPasswordField();
		senhaField.setBounds(583, 350, 200, 30);
		confirmarSenhaField = new JPasswordField();
		confirmarSenhaField.setBounds(583, 420, 200, 30);
		cadastrarButton = new JButton("Confirmar cadastro");
		cadastrarButton.setBounds(583, 490, 200, 30);
		
		add(nomeField);
		add(cpfField);
		add(loginField);
		add(senhaField);
		add(confirmarSenhaField);
		add(cadastrarButton);
		
		add(painel);
		
		setVisible(false);
	}
	
	public Painel getPainel() {
		return painel;
	}

	public JTextField getNomeField() {
		return nomeField;
	}

	public JTextField getCpfField() {
		return cpfField;
	}

	public JTextField getLoginField() {
		return loginField;
	}

	public JPasswordField getSenhaField() {
		return senhaField;
	}

	public JPasswordField getConfirmarSenhaField() {
		return confirmarSenhaField;
	}

	public JButton getCadastrarButton() {
		return cadastrarButton;
	}
	
	public class Painel extends JPanel{
		public Painel() {
			setSize(1366, 768);
			setLocation(0, 0);
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			g.setColor(Color.LIGHT_GRAY);
			g.fillRect(0, 0, TelaGenerica.LARGURA, TelaGenerica.ALTURA);
			g.setColor(Color.BLACK);
			g.setFont(new Font("Roboto", Font.BOLD, 16));
			g.drawString("Nome:", 583, 129);
			g.drawString("CPF:", 583, 199);
			g.drawString("Login:", 583, 269);
			g.drawString("Senha:", 583, 339);
			g.drawString("Confirmar Senha:", 583, 409);
		}
		
		public void msgErroUsuario(String mensagem) {
			Graphics g = this.getGraphics();
			g.setColor(Color.RED);
			g.drawString(mensagem, 533, 480);
		}
		
		public void corrigirMsgErro() {
			Graphics g = getGraphics();
			g.setColor(Color.LIGHT_GRAY);
			g.fillRect(533, 465, 325, 20);
		}
	}
	
}
