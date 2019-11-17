package com.EasySoft.Jogo;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TelaInicial extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton btnNick;
	JButton btnRanking;
	JLabel lbTitulo;
	Font f = new Font("Arial",Font.BOLD,15);
	
	TelaInicial(){
		this.setTitle("Merecemos um 10");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setSize(500,250);
		this.setLocationRelativeTo(null);
		this.add(initBtnNick());
		this.add(initBtnRanking());
		this.add(initLabel());
		this.setVisible(true);
	}
	
	private JButton initBtnNick() {
		btnNick = new JButton();
		btnNick.setFont(f);
		btnNick.setBounds(100, 150, 100, 30);
		btnNick.setText("Jogar");
		btnNick.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new TelaCriacao();
				dispose();
			}
			
		});
		return btnNick;
	}
	
	private JButton initBtnRanking() {
		btnRanking = new JButton();
		btnRanking.setFont(f);
		btnRanking.setBounds(300, 150, 100, 30);
		btnRanking.setText("Ranking");
		return btnRanking;
	}
	
	private JLabel initLabel() {
		lbTitulo = new JLabel();
		lbTitulo.setFont(f);
		lbTitulo.setText("Jogo de Pergunta");
		lbTitulo.setBounds(175, 10, 300, 30);
		return lbTitulo;
	}
	
}
