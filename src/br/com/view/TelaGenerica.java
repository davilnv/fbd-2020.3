package br.com.view;

import javax.swing.JFrame;

public class TelaGenerica extends JFrame{
	
	public static final int LARGURA = 1366;
	public static final int ALTURA = 768;
	
	public TelaGenerica(String titulo) {
		super(titulo);
		setSize(LARGURA, ALTURA);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);
		
		
	}
	
}
