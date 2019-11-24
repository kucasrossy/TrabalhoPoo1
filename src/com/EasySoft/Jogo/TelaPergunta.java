package com.EasySoft.Jogo;

import java.awt.BorderLayout;
import java.awt.Color;
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

public class TelaPergunta extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panelImagen;
	private JPanel panelOp;
	Perguntas png = new Perguntas(2);
	//private int cont;
	
	TelaPergunta(){
		this.setLayout(new GridLayout(2,0));
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.add(initPanelImagen());
		this.add(initPanelOp());
		this.setVisible(true);
	}
	
	private JPanel initPanelImagen() {
		JLabel pergunta = new JLabel(png.getPergunta());
        Icon i = new ImageIcon(getClass().getResource(png.getImagen()));
		JLabel img = new JLabel(i);
		panelImagen = new JPanel();
		panelImagen.setLayout(new BorderLayout());
		panelImagen.add(BorderLayout.CENTER,img);
		panelImagen.add(pergunta,BorderLayout.SOUTH);
		panelImagen.setBackground(Color.DARK_GRAY);
		return panelImagen;
	}
	
	private JPanel initPanelOp() {
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
				}
				
			});
		}
		return panelOp;
	}
	
	
}
