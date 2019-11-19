package com.EasySoft.Jogo;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaRanking extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panelRanking;

	TelaRanking(){
		this.setSize(300,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.MAGENTA);
		this.setLayout(null);
		this.add(initPanel());
		Ranking();
		this.setVisible(true);
	}
	
	private JPanel initPanel() {
		panelRanking = new JPanel();
		panelRanking.setBounds(20, 5, 250, 250);
		panelRanking.setBackground(Color.CYAN);
		panelRanking.setLayout(new BoxLayout(panelRanking,BoxLayout.Y_AXIS));
		String[] ranking = Ranking();
		for(int i =0;i<3;i++) {
			JLabel l = new JLabel();
			l.setText(ranking[i]);
			panelRanking.add(l);
		}
		return panelRanking;
	}
	
	private String[] Ranking() {
		String rankDados = Arquivos.read("pontuacao.txt");
		String[] dados = new String[3];
		dados = rankDados.split(";");	
		String aux = "";
		for(int i = 0; i<3; i++){
	        for(int j = 0; j<2; j++){
	            if((Double.parseDouble(dados[j].substring(dados[j].indexOf(":")+1))) < (Double.parseDouble(dados[j+1].substring(dados[j+1].indexOf(":")+1)))){
	                aux = dados[j];
	                dados[j] = dados[j+1];
	                dados[j+1] = aux;
	            }
	        }
	    }
		
		return dados;
		
	}
}
