package br.com.view;

import java.awt.Color;
import java.awt.Graphics;

public class PainelPromocoes extends PainelGenerico{
	public PainelPromocoes() {
	}
		
	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 80, TelaPrincipal.LARGURA, 688);
	}
}
