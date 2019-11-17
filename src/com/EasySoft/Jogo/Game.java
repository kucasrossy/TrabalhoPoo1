package com.EasySoft.Jogo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Game{
	
	//private int round = 10;
	private int cont = 0;
	
	void Jogar() {
		if(cont<2) {
			TelaJogo g = new TelaJogo(cont);
			g.comecou();
		}else {
			JOptionPane.showMessageDialog(null, "Você terminou o Jogo");
		}
	}
	
	
	
	private class TelaJogo extends JFrame{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private JPanel panelPerg;
		private JPanel panelOp;
		private Perguntas png;
		
		TelaJogo(int i){
			png = new Perguntas(i);
			this.setLayout(new GridLayout(2,0));
			this.setSize(500, 500);
			this.setLocationRelativeTo(null);
			this.setResizable(false);
			this.add(initPanelImagen());
			this.add(initPanelOp());
			this.setVisible(true);
		}

		public void comecou() {
			// Só pra n encher o saco
		}

		private Component initPanelOp() {
			panelOp = new JPanel(new GridLayout(2,2));
			for(int i=0;i<4;i++) {
				JButton b = new JButton(png.getOp(i));
				b.setName(png.getOp(i));
				panelOp.add(b);
				b.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						char o = b.getName().charAt(0);
						if(o==png.getResp()) {
							JOptionPane.showMessageDialog(null, "Acertou");
						}else {
							JOptionPane.showMessageDialog(null, "Errou");
						}
						cont++;
						dispose();
					    Jogar();
					}
					
				});
			}
			return panelOp;
		}

		private Component initPanelImagen() {
			JLabel pergunta = new JLabel(png.getPergunta());
	        Icon i = new ImageIcon(getClass().getResource(png.getImagen()));
			JLabel img = new JLabel(i);
			panelPerg = new JPanel();
			panelPerg.setLayout(new BorderLayout());
			panelPerg.add(BorderLayout.CENTER,img);
			panelPerg.add(pergunta,BorderLayout.SOUTH);
			panelPerg.setBackground(Color.DARK_GRAY);
			return panelPerg;
		}
		
	}
	
}
