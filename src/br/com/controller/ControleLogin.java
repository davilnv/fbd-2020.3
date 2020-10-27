package br.com.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.com.exception.BusinessException;
import br.com.exception.DaoException;
import br.com.fachada.Fachada;
import br.com.model.Usuario;
import br.com.view.TelaCadastro;
import br.com.view.TelaLogin;
import br.com.view.TelaPrincipal;

public class ControleLogin implements ActionListener{
	
	private Fachada fachada;
	private TelaLogin telaLogin;
	private TelaCadastro telaCadastro;
	private TelaPrincipal telaPrincipal;
	public Usuario usuarioLogado;
	
	public ControleLogin(Fachada fachada, TelaLogin telaLogin, TelaCadastro telaCadastro, TelaPrincipal telaPrincipal) {
		this.fachada = fachada;
		this.telaLogin = telaLogin;
		this.telaCadastro = telaCadastro;
		this.telaPrincipal = telaPrincipal;
		usuarioLogado = new Usuario();
		
		telaLogin.getCadastrarButton().addActionListener(this);
		telaLogin.getEntrarButton().addActionListener(this);
		telaLogin.getLoginField().addActionListener(this);
		telaLogin.getSenhaField().addActionListener(this);
		telaCadastro.getCadastrarButton().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == telaLogin.getEntrarButton()) {
			String login = telaLogin.getLoginField().getText();
			String senha = new String(telaLogin.getSenhaField().getPassword()).trim();
			Usuario user = new Usuario("", "", login, senha);
			try {
				if (fachada.verificarUsuario(user)) {
					telaPrincipal.setVisible(true);
					telaLogin.setVisible(false);
					usuarioLogado.setNome(fachada.pegarNomeUsuario(login));
					usuarioLogado.setId(fachada.pegarIdUsuario(user.getLogin(), user.getSenha()));
					usuarioLogado.setLogin(login);
				}
			} catch (BusinessException e1) {
				// TODO Auto-generated catch block
				telaLogin.getPainel().msgErroUsuario(e1.getMessage());
//				e1.printStackTrace();
			}
		}
		
		if(e.getSource() == telaLogin.getCadastrarButton()) {
			telaCadastro.setVisible(true);
		}
		
		if(e.getSource() == telaCadastro.getCadastrarButton()) {
			String nome = telaCadastro.getNomeField().getText();
			String cpf = telaCadastro.getCpfField().getText();
			String login = telaCadastro.getLoginField().getText();
			String senha = new String(telaCadastro.getSenhaField().getPassword()).trim();
			String confirmarSenha = new String(telaCadastro.getConfirmarSenhaField().getPassword()).trim();
			if (senha.equals(confirmarSenha)) {
				Usuario usuario = new Usuario();
				usuario.setNome(nome);
				usuario.setCpf(cpf);
				usuario.setLogin(login);
				usuario.setSenha(senha);
				telaCadastro.getPainel().corrigirMsgErro();
				try {
					fachada.cadastrarUsuario(usuario);
					telaCadastro.setVisible(false);
					telaCadastro.getNomeField().setText("");
					telaCadastro.getCpfField().setText("");
					telaCadastro.getLoginField().setText("");
					telaCadastro.getSenhaField().setText("");
					telaCadastro.getConfirmarSenhaField().setText("");
				} catch (BusinessException e1) {
					// TODO Auto-generated catch block
					telaCadastro.getPainel().corrigirMsgErro();
					telaCadastro.getPainel().msgErroUsuario(e1.getMessage());
					e1.printStackTrace();
				}
			} else {
				telaCadastro.getPainel().corrigirMsgErro();
				telaCadastro.getPainel().msgErroUsuario("As senha não coincidem.");
			}
		}
	}
	
}
