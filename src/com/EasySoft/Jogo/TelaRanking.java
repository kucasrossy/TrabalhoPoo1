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
		this.setVisible(true);
	}
	
	private JPanel initPanel() {
		panelRanking = new JPanel();
		panelRanking.setBounds(20, 5, 250, 250);
		panelRanking.setBackground(Color.CYAN);
		panelRanking.setLayout(new BoxLayout(panelRanking,BoxLayout.Y_AXIS));
		String[] ranking = Ranking.rank(3);
		int tam = ranking.length;
		for(int i =0;i<tam;i++) {
			JLabel l = new JLabel();
			l.setText(ranking[i]);
			panelRanking.add(l);
		}
		return panelRanking;
	}
	
}
