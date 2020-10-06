package br.com.controller;

import br.com.fachada.Fachada;
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
		
		controleLogin = new ControleLogin(fachada, telaLogin, telaPrincipal);
		controlePrincipal = new ControlePrincipal(fachada, telaLogin, telaPrincipal);
	}
	
}
