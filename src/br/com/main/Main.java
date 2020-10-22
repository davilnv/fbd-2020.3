package br.com.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.controller.Controle;
import br.com.exception.BusinessException;
import br.com.fachada.Fachada;
import br.com.model.Codigo;
import br.com.model.Comanda;
import br.com.model.Prato;
import br.com.model.Produto;
import br.com.model.Usuario;

public class Main {
	public static void main(String[] args) throws ParseException {
		System.out.println("INICIO");
		Fachada fachada = new Fachada();
		
//		Usuario usuario = new Usuario("ADMIN", "111.111.111-11", "admin", "admin");
//		Usuario usuario2 = new Usuario("Davi Lima", "222.222.222-22", "davi", "davi123");
//		Usuario usuario3 = new Usuario("ADMIN TESTER", "333.333.333-33", "tester", "tester123");
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date validade = format.parse("15/10/2020");
		Date validade2 = format.parse("26/10/2020");
		
		
		Prato prato = new Prato("Almoço do dia", 14.99f, "Arroz, Feijão, Batat Frita e Bife", 0.5f);
		
		Produto produto = new Produto("Coca-cola Lata", 4.5f, "Refrigerante de cola", 0.350f, validade, 50);
		Produto produto2 = new Produto("Fanta Lata", 3.5f, "Refrigerante de laranja", 0.350f, validade2, 50);
		
		Date data = new Date();
		
		Comanda comanda = new Comanda("Davi Lima", data, 1, 123.54f, "cartao", 1);
		comanda.setCódigo(Codigo.gerarCodigo(fachada));
		comanda.getProdutos().add(produto);
		comanda.getProdutos().add(produto2);
		comanda.getPratos().add(prato);
		comanda.converterArrayStringId();
		
		Controle controle = new Controle(fachada);
		
//		try {
////			fachada.salvarComanda(comanda);
////			fachada.cadastrarUsuario(usuario);
////			fachada.cadastrarUsuario(usuario3);
////			fachada.cadastrarPrato(prato);
////			fachada.cadastrarProduto(produto);
////			fachada.cadastrarProduto(produto2);
////			System.out.println(fachada.procurarProdutoPorId(1));
////			System.out.println(fachada.procurarPratoPorId(1));
//		} catch (BusinessException e) {
//			e.printStackTrace();
//		}
		
		System.out.println("FIM");
	}
}
