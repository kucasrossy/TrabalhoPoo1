package com.EasySoft.Jogo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
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
		Audio.play("m1.mp3");
		this.setTitle("Merecemos um 10");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setSize(500,300);
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(new Color(13, 33, 101));
		this.add(initBtnNick());
		this.add(initBtnRanking());
		this.add(initLabel());
		this.add(img());
		this.setVisible(true);
	}
	
	private JButton initBtnNick() {
		btnNick = new JButton();
		btnNick.setFont(f);
		btnNick.setBounds(80, 220, 100, 30);
		btnNick.setText("Jogar");
		btnNick.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK, 2));
		btnNick.setBackground(new Color(252, 34, 253));
		btnNick.setForeground(Color.WHITE);
		btnNick.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Audio.click();
				new TelaCriacao();
				dispose();
			}
			
		});
		return btnNick;
	}
	
	private JButton initBtnRanking() {
		btnRanking = new JButton();
		btnRanking.setFont(f);
		btnRanking.setBounds(280, 220, 100, 30);
		btnRanking.setText("Ranking");
		btnRanking.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK, 2));
		btnRanking.setBackground(new Color(252, 34, 253));
		btnRanking.setForeground(Color.WHITE);
		btnRanking.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Audio.stop();
				Audio.click();
				dispose();
				new TelaRanking();
			}
			
		});
		return btnRanking;
	}
	
	private JLabel initLabel() {
		lbTitulo = new JLabel();
		lbTitulo.setFont(f);
		lbTitulo.setText("<html>PERGUNTAS IMPOSSIVEIS DE RESPONDER <br><br><em>A MENOS</em> QUE VOCE SAIBA A RESPOSTA</html>");
		lbTitulo.setBounds(120, 0, 300, 100);
		lbTitulo.setForeground(Color.WHITE);
		return lbTitulo;
	}
	
	private JLabel img() {
		ImageIcon img = new ImageIcon(getClass().getResource("/100.gif"));
		JLabel i = new JLabel(img);
		i.setBounds(-180, -200, 500, 500);
		return i;
	}
	
}
