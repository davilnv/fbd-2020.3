package br.com.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;

public class PainelConta extends PainelGenerico{
	
	private JButton sairButton;
	
	public PainelConta() {
		sairButton = new JButton("Sair");
		sairButton.setBounds(500, 500, 150, 30);
		
		add(sairButton);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 80, TelaPrincipal.LARGURA, 688);
		g.setColor(Color.RED);
		g.fillRect(50, 240, 50, 50);
	}

	public JButton getSairButton() {
		return sairButton;
	}
	
}
