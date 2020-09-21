package br.com.main;

import br.com.exception.BusinessException;
import br.com.fachada.Fachada;
import br.com.model.Usuario;

public class Main {
	public static void main(String[] args) {
		System.out.println("INICIO");
		
		Fachada fachada = new Fachada();
		
		Usuario usuario = new Usuario("ADMIN", "111.111.111-11", "admin", "admin");
		Usuario usuario2 = new Usuario("Davi Lima", "222.222.222-22", "davi", "davi123");
		
		try {
//			fachada.cadastrarUsuario(usuario);
			fachada.cadastrarUsuario(usuario2);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("FIM");
	}
}
