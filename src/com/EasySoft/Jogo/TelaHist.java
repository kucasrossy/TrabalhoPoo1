package com.EasySoft.Jogo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaHist extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	TelaHist(){
		this.setSize(300, 500);
		this.add(Hist());
		this.add(btnVoltar());
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public JPanel Hist() {
		int linhas = Integer.parseInt(Arquivos.read("pontuacao.txt", true));
		JPanel p1 = new JPanel();
		p1.setSize(150, 500);
		p1.setLayout(new BoxLayout(p1,BoxLayout.Y_AXIS));
		if(linhas > 20) {
			linhas = 20;
		}
		
		String l = Arquivos.read("pontuacao.txt", false);
		String tds[] = l.split(";");
		for(int i = 0;i<linhas;i++) {
			JLabel lb = new JLabel(tds[i]);
			p1.add(lb);
		}
		return p1;
	}
	
	public JButton btnVoltar() {
		JButton btn = new JButton("Voltar");
		btn.setBounds(100, 400, 70, 20);
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new TelaRanking();
			}
			
		});
		
		return btn;
	}

}
