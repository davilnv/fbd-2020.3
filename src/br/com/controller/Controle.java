package br.com.controller;

import br.com.fachada.Fachada;
import br.com.view.TelaCadastro;
import br.com.view.TelaLogin;
import br.com.view.TelaPrincipal;

public class Controle{
	
	private ControleLogin controleLogin;
	private ControlePrincipal controlePrincipal;
	Fachada fachada;
	
	public Controle(Fachada fachada) {
		this.fachada = fachada;
		TelaLogin telaLogin = new TelaLogin("Login");
		TelaPrincipal telaPrincipal  = new TelaPrincipal("Principal");
		TelaCadastro telaCadastro = new TelaCadastro();
		
		controleLogin = new ControleLogin(fachada, telaLogin, telaCadastro, telaPrincipal);
		controlePrincipal = new ControlePrincipal(fachada, telaLogin, telaPrincipal, controleLogin);
	}
	
}
