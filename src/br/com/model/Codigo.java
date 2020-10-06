package br.com.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import br.com.fachada.Fachada;

public class Codigo {

	private static Random gerador = new Random();
	
	private static String pegarData() {
		Date data = new Date();
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		String dataString = "";
		String[] separado = f.format(data).split("/");
		dataString += separado[2];
		dataString += separado[1];
		dataString += separado[0];
		return dataString;
	}
	
	private static String pegarLetra() {
		String[] alfabeto = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",};
		return alfabeto[gerador.nextInt(26)];
	}
	
	private static int pegarNumeroAleatorio() {
		return gerador.nextInt(999);
	}
	private static String gerandoCodigo() {
		return pegarData() + pegarLetra() + pegarNumeroAleatorio();
	}
	
	public static String gerarCodigo(Fachada fachada) {
		String codigo = gerandoCodigo();
		while (fachada.verificarCodicoComanda(codigo)) {
			codigo = gerandoCodigo();
		}
		return codigo;
	}
	
}
