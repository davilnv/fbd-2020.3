package br.com.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TelaComanda extends JFrame{
	
	private PainelAdicionar painelAdicionar;
	private PainelRemover painelRemover;
	
	public TelaComanda() {
		setSize(500, 500);
		setLocationRelativeTo(null);
		setResizable(false);
		
		painelAdicionar = new PainelAdicionar();
		painelRemover = new PainelRemover();
		
		add(painelAdicionar);
		add(painelRemover);
		
		setVisible(false);
	}
	
	public void ligarPainelAdicionar() {
		setVisible(true);
		painelAdicionar.setVisible(true);
		painelRemover.setVisible(false);
		setTitle("Adicionar");
	}
	
	public void ligarPainelRemover() {
		setVisible(true);
		painelRemover.setVisible(true);
		painelAdicionar.setVisible(false);
		setTitle("Remover");
	}
	
	private class PainelAdicionar extends JPanel {
		
		public PainelAdicionar() {
			setSize(500, 500);
			setLocation(0, 0);
			
			setVisible(false);
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			g.drawString("Testanddooooooo", 200, 200);
		}
	}
	
	private class PainelRemover extends JPanel {
		
		public PainelRemover() {
			setSize(500, 500);
			setLocation(0, 0);
			
			setVisible(false);
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			
			g.drawString("Removendooooo", 200, 200);
		}
	}
	
}
