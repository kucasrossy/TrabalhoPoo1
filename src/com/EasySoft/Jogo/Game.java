package com.EasySoft.Jogo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Game{
	
	//private int round = 10;
	private int cont = 0;
	private Jogador a;
	int certas = 0;
	
	Game(Jogador a){
		this.a = a;
	}
	
	void Jogar() {
		if(cont<3) {
			new TelaJogo(cont);
		}else {
			a.salvarPont();
			new TelaResult(cont);
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
							a.Setpont(5);
							certas++;
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
	        ImageIcon i = new ImageIcon(getClass().getResource(png.getImagen()));
	        i.setImage(i.getImage().getScaledInstance(380,200, 100));
			JLabel img = new JLabel(i);
			panelPerg = new JPanel();
			panelPerg.setLayout(new BorderLayout());
			panelPerg.add(BorderLayout.CENTER,img);
			panelPerg.add(pergunta,BorderLayout.SOUTH);
			panelPerg.setBackground(Color.WHITE);
		    pergunta.setFont(new Font("Arial",Font.BOLD,25));
		    pergunta.setForeground(Color.BLACK);
		    pergunta.setHorizontalAlignment(JLabel.CENTER);
			return panelPerg;
		}
		
	}
	
}
