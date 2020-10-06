package br.com.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.com.exception.BusinessException;
import br.com.exception.DaoException;
import br.com.fachada.Fachada;
import br.com.model.Usuario;
import br.com.view.TelaLogin;
import br.com.view.TelaPrincipal;

public class ControleLogin implements ActionListener{
	
	private Fachada fachada;
	private TelaLogin telaLogin;
	private TelaPrincipal telaPrincipal;
	
	public ControleLogin(Fachada fachada, TelaLogin telaLogin, TelaPrincipal telaPrincipal) {
		this.fachada = fachada;
		this.telaLogin = telaLogin;
		this.telaPrincipal = telaPrincipal;
		
		telaLogin.getEntrarButton().addActionListener(this);
		telaLogin.getLoginField().addActionListener(this);
		telaLogin.getSenhaField().addActionListener(this);
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
				}
			} catch (BusinessException e1) {
				// TODO Auto-generated catch block
				telaLogin.getPainel().msgErroUsuario(e1.getMessage());
//				e1.printStackTrace();
			}
		}
	}
	
}
