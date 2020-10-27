package br.com.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class TelaLogin extends TelaGenerica{
	private ImageIcon logo;
	private Painel painel;
	
	private JTextField loginField;
	private JPasswordField senhaField;
	private JButton entrarButton, cadastrarButton;
	
	public TelaLogin(String titulo) {
		super(titulo);
		
		logo = new ImageIcon(getClass().getClassLoader().getResource("logo.png"));
		
		painel = new Painel();
		
		loginField = new JTextField("admin");
		loginField.setBounds(533, 340, 300, 30);
		senhaField = new JPasswordField("admin");
		senhaField.setBounds(533, 400, 300, 30);
		entrarButton = new JButton("Entrar");
		entrarButton.setBounds(608, 460, 150, 30);
		
		cadastrarButton = new JButton("Cadastrar usuário");
		cadastrarButton.setFont(new Font("Roboto", Font.BOLD, 13));
		cadastrarButton.setBounds(608, 520, 150, 13);
		
		add(loginField);
		add(senhaField);
		add(entrarButton);
		add(cadastrarButton);
		
		add(painel);
		
		setVisible(true);
	}

	public Painel getPainel() {
		return painel;
	}

	public JTextField getLoginField() {
		return loginField;
	}

	public JPasswordField getSenhaField() {
		return senhaField;
	}

	public JButton getEntrarButton() {
		return entrarButton;
	}

	public JButton getCadastrarButton() {
		return cadastrarButton;
	}

	public class Painel extends JPanel{
		public Painel() {
			setSize(LARGURA, ALTURA);
			setLocation(0, 0);
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			g.setColor(Color.LIGHT_GRAY);
			g.fillRect(0, 0, TelaGenerica.LARGURA, TelaGenerica.ALTURA);
			g.setColor(Color.BLACK);
			g.setFont(new Font("Roboto", Font.BOLD, 16));
			g.drawString("Login:", 533, 330);
			g.drawString("Senha:", 533, 390);
			g.drawImage(logo.getImage(), 492, 100, null);
		}
		
		public void msgErroUsuario(String mensagem) {
			Graphics g = this.getGraphics();
			g.setColor(Color.LIGHT_GRAY);
			g.fillRect(533, 438, 325, 15);
			g.setColor(Color.RED);
			g.drawString(mensagem, 533, 450);
		}
		
		
	}
	
}
