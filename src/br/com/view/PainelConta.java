package br.com.view;

import java.awt.Color;
import java.awt.Graphics;

public class PainelConta extends PainelGenerico{
	public PainelConta() {
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 80, TelaPrincipal.LARGURA, 688);
		g.setColor(Color.RED);
		g.fillRect(50, 240, 50, 50);
	}
}
