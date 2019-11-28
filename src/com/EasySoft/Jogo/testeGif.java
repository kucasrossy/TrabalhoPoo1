package com.EasySoft.Jogo;

import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class testeGif extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	testeGif(){
		ImageIcon img = new ImageIcon(getClass().getResource("/200.gif"));
		img.setImage(getIconImage().getScaledInstance(380,248, Image.SCALE_DEFAULT));
		JLabel teste = new JLabel(img);
		this.add(teste);
		this.setSize(500, 500);
		this.setLayout(new FlowLayout());
		JLabel b = new JLabel("Testando");
		this.add(b);
		this.setVisible(true);
	}
}
