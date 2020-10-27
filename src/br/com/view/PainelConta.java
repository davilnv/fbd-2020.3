package br.com.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import br.com.model.Usuario;

public class PainelConta extends PainelGenerico{
	
	private JButton sairButton, alterarNomeButton, alterarSenhaButton, confirmarAlterarNomeButton, confirmarAlterarSenhaButton;
	private JTextField nomeField;
	private JPasswordField senhaField, confirmarSenhaField, senhaAntigaField;
	
	public PainelConta() {
		sairButton = new JButton("Sair");
		sairButton.setBounds(608, 594, 150, 30);
		alterarNomeButton = new JButton("Alterar Nome");
		alterarNomeButton.setBounds(50, 326, 150, 30);
		alterarSenhaButton = new JButton("Alterar Senha");
		alterarSenhaButton.setBounds(50, 376, 150, 30);
		confirmarAlterarNomeButton = new JButton("Confirmar Alteração");
		confirmarAlterarNomeButton.setBounds(383, 280, 200, 30);
		confirmarAlterarNomeButton.setEnabled(false);
		confirmarAlterarSenhaButton = new JButton("Confirmar Alteração");
		confirmarAlterarSenhaButton.setBounds(633, 425, 200, 30);
		confirmarAlterarSenhaButton.setEnabled(false);
		
		nomeField = new JTextField();
		nomeField.setBounds(383, 235, 200, 30);
		nomeField.setEnabled(false);
		
		senhaAntigaField = new JPasswordField();
		senhaAntigaField.setBounds(633, 235, 200, 30);
		senhaAntigaField.setEnabled(false);
		senhaField = new JPasswordField();
		senhaField.setBounds(633, 300, 200, 30);
		senhaField.setEnabled(false);
		confirmarSenhaField = new JPasswordField();
		confirmarSenhaField.setBounds(633, 365, 200, 30);
		confirmarSenhaField.setEnabled(false);
		
		add(nomeField);
		add(senhaField);
		add(confirmarSenhaField);
		add(senhaAntigaField);
		add(sairButton);
		add(alterarNomeButton);
		add(alterarSenhaButton);
		add(confirmarAlterarNomeButton);
		add(confirmarAlterarSenhaButton);
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 80, TelaPrincipal.LARGURA, 688);
		g.setColor(Color.BLACK);
		g.setFont(new Font("Roboto", Font.BOLD, 22));
		g.drawString("Dados do Usuário", 50, 150);
		g.setFont(new Font("Roboto", Font.BOLD, 16));
		g.drawString("Nome: ", 50, 182);
		g.drawString("CPF: ", 50, 208);
		g.drawString("Login: ", 50, 234);
		g.drawString("Senha: ", 50, 260);
		g.drawString("Registros do Usuário: ", 50, 286);
		g.drawString("Novo nome do usuário:", 383, 224);
		g.drawString("Senha antiga:", 633, 224);
		g.drawString("Nova senha:", 633, 289);
		g.drawString("Confirmação da nova senha:", 633, 354);
		g.setColor(Color.RED);
		g.drawString("Para mostrar os dados clique novamente no icone do perfil", 50, 614);
		
	}
	
	public void desenharDados(Usuario usuario, int registros) {
		Graphics g = getGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0, 150, 300, 150);
		g.setColor(Color.BLACK);
		g.setFont(new Font("Roboto", Font.BOLD, 16));
		g.drawString("Nome: ", 50, 182);
		g.drawString("CPF: ", 50, 208);
		g.drawString("Login: ", 50, 234);
		g.drawString("Senha: ", 50, 260);
		g.drawString("Registros do Usuário: ", 50, 286);
		g.drawString(usuario.getNome(), 110, 182);
		String[] cpf = usuario.getCpf().split("");
		String novoCpf = "***.***.***-" + cpf[12] + cpf[13];
		g.drawString(novoCpf, 110, 208);
		g.drawString(usuario.getLogin(), 110, 234);
		String senha = "";
		for (int i = 0; i <= usuario.getSenha().length(); i++) {
			senha += "*";
		}
		g.drawString(senha, 110, 260);
		g.drawString(""+registros, 220, 286);
	}
	
	public void escreverMensagemErro(String mensagem) {
		Graphics g = getGraphics();
		g.setColor(Color.RED);
		g.setFont(new Font("Roboto", Font.BOLD, 12));
		g.drawString(mensagem, 383, 485);
	}
	
	public void concertarMensagemErro() {
		Graphics g = getGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(383, 471, 400, 20);
	}
 
	public JButton getSairButton() {
		return sairButton;
	}

	public JButton getAlterarNomeButton() {
		return alterarNomeButton;
	}

	public JButton getAlterarSenhaButton() {
		return alterarSenhaButton;
	}

	public JTextField getNomeField() {
		return nomeField;
	}

	public JButton getConfirmarAlterarNomeButton() {
		return confirmarAlterarNomeButton;
	}

	public JPasswordField getConfirmarSenhaField() {
		return confirmarSenhaField;
	}

	public JPasswordField getSenhaField() {
		return senhaField;
	}

	public JButton getConfirmarAlterarSenhaButton() {
		return confirmarAlterarSenhaButton;
	}

	public JPasswordField getSenhaAntigaField() {
		return senhaAntigaField;
	}
	
}
