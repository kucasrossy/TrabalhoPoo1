package com.EasySoft.Jogo;


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
			new TelaResult(certas);
		}
	}
	
	
	
	public class TelaJogo extends JFrame{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private JPanel panelPerg;
		private JPanel panelOp;
		private Perguntas png;
		private Barra b;
		
		TelaJogo(int i){
			png = new Perguntas(i);
			this.setLayout(new GridLayout(2,0));
			this.setSize(500, 550);
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
						Character o = b.getText().charAt(0);
						if(o.equals(png.getResp())) {
							a.Setpont(5);
							certas++;
							System.out.println(o + " = " + png.getResp());
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
			panelPerg = new JPanel();
			b = new Barra(this);
			panelPerg.setLayout(null);
			panelPerg.add(b);
			b.setSize(500, 10);
			ImageIcon img = new ImageIcon(getClass().getResource(png.getImagen()));
			img.setImage(img.getImage().getScaledInstance(380,248, 223));
			JLabel lbImg = new JLabel(img);
			lbImg.setBounds(120, 25, 248, 203);
			panelPerg.add(lbImg);
			JLabel lbPergunta = new JLabel();
			lbPergunta.setFont(new Font("Arial",Font.BOLD,18));
			lbPergunta.setForeground(Color.BLACK);
			lbPergunta.setBounds(5, 190, 500, 100);
			lbPergunta.setText("Essa pergunta é um teste\n para a nossa vitoria");
			panelPerg.add(lbPergunta);
			return panelPerg;
		}
		
	}
	
}
