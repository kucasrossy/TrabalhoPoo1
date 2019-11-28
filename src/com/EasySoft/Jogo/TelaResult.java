package com.EasySoft.Jogo;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TelaResult extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int certas;
	private JLabel lb;
	private JButton btn;
	
	TelaResult(int certas){
		this.certas = certas;
		if(certas == 10) {
			Audio.play("m3.mp3");
		}else if(certas == 0) {
			Audio.play("m4.mp3");
		}
		this.setResizable(false);
		this.setSize(500,250);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.getContentPane().setBackground(new Color(13, 33, 101));
		this.add(initLabel());
		this.add(initBtn());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	private Component initBtn() {
		btn = new JButton("Recomeçar");
		btn.setBounds(180, 180, 120, 20);
		btn.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK, 2));
		btn.setBackground(new Color(252, 34, 253));
		btn.setForeground(Color.WHITE);
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Audio.stop();
				Audio.click();
				dispose();
				new TelaInicial();
			}
			
		});
		return btn;
	}

	private Component initLabel() {
		lb = new JLabel();
		lb.setFont(new Font("Arial",Font.BOLD,25));
		lb.setForeground(Color.white);
		lb.setText("Você acertou " + certas + " /10 perguntas");
		lb.setBounds(60, 20, 400, 100);
		return lb;
	}
}
