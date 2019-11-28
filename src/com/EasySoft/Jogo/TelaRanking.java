package com.EasySoft.Jogo;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaRanking extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int i = Integer.parseInt(Arquivos.read("pontuacao.txt", true));
	
	TelaRanking(){
		Audio.play("m2.mp3");
		this.setSize(600, 400);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(new Color(13, 33, 101));
		this.setLocationRelativeTo(null);
		this.add(intiBtn_Inicial());
		this.add(initBtn_hist());
		this.setLayout(null);
		this.add(initTitulo());
		if(i < 4) {
			this.add(showMes());
		}else {
			this.add(initTop());
		}
		this.setVisible(true);
	}
	


	private JButton initBtn_hist() {
		JButton btn = new JButton("Historico das Partidas");
		btn.setBounds(320,320,200,20);
		btn.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK, 2));
		btn.setBackground(new Color(252, 34, 253));
		btn.setForeground(Color.WHITE);
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Audio.stop();
				Audio.click();
				dispose();
				new TelaHist();
			}
			
		});
		
		
		return btn;
	}


	private JButton intiBtn_Inicial() {
		JButton btn = new JButton("Voltar a tela inicial");
		btn.setBounds(70, 320, 200, 20);
		btn.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK, 2));
		btn.setBackground(new Color(252, 34, 253));
		btn.setForeground(Color.WHITE);
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Audio.stop();
				Audio.click();
				dispose();
				new TelaInicial();
			}
			
		});
		return btn;
	}


	public JLabel initTitulo() {
		JLabel titulo = new JLabel("Tabela de Ranking");
		Font f = new Font("Arial",Font.BOLD,40);
		titulo.setFont(f);
		titulo.setBounds(120, -50, 500, 200);
		titulo.setForeground(Color.WHITE);
		
		return titulo;
	}
	
	
	public JPanel initTop() {
		
		String linhas[]  = Ranking.rank(3);
		
		
				
		String l1 = linhas[0];
		String l2 = linhas[1];
		String l3 = linhas[2];
		
		
		
		JPanel comp = new JPanel(null);
		comp.setBackground(new Color(13, 33, 101));
		comp.setBounds(145, 120, 400, 400);
		Font f1 = new Font("Arial", Font.BOLD,40); //Font para P1
		Font f2 = new Font("Arial",Font.ITALIC,25); //Font para o TOp
		Font f3 = new Font("Arial",Font.BOLD,15);
		JPanel top = new JPanel();
		JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel p2 = new JPanel(null);
		comp.add(top);
		comp.add(p1);
		comp.add(p2);
		//Desenhando a coluna de numeros
		top.setLayout(new BoxLayout(top,BoxLayout.Y_AXIS));
		top.setBackground(new Color(1,5,37));
		top.setBounds(0,30,30, 140);
		for(int i = 1;i<=3;i++) {
			JLabel a = new JLabel(Integer.toString(i));
			a.setFont(f1);
			a.setForeground(Color.WHITE);
			a.setHorizontalTextPosition(JLabel.RIGHT);
			top.add(a);
		}
		//Desenhado a linha dos numeros (releva do com sono)
		p1.setBounds(23,0,270, 30);
		p1.setBackground(Color.BLACK);
		JLabel a1 = new JLabel("Nome");
		a1.setFont(f2);
		a1.setForeground(Color.WHITE);
		p1.add(a1);
		JLabel a2 = new JLabel("Pontuação");
		a2.setFont(f2);
		a2.setForeground(Color.WHITE);
		p1.add(a2);
		JLabel a3 = new JLabel("Data");
		a3.setFont(f2);
		a3.setForeground(Color.WHITE);
		p1.add(a3);
		
		//Painel dos dados vulgo P2 (Serio, to com sono e sem criatividade)
		p2.setBounds(23, 30, 270, 140);
		p2.setBackground(new Color(1, 29, 37));
		JLabel b1 = new JLabel();
		JLabel b2 = new JLabel();
		JLabel b3 = new JLabel();
		p2.add(b1);
		b1.setBounds(10, -35, 300, 100);
		b1.setFont(f3);
		b1.setForeground(Color.WHITE);
		p2.add(b2);
		b2.setBounds(10,17,300,100);
		b2.setFont(f3);
		b2.setForeground(Color.WHITE);
		p2.add(b3);
		b3.setBounds(10, 65, 300, 100);
		b3.setForeground(Color.WHITE);
		b3.setFont(f3);
	
		
		b1.setText(l1.substring(l1.indexOf(""), l1.lastIndexOf(":")) + "               " + l1.substring(l1.indexOf(":") + 1, l1.lastIndexOf(",")) + "            " + l1.substring(l1.indexOf(",")+1));
		b2.setText(l2.substring(l2.indexOf(""), l2.lastIndexOf(":")) + "               " + l2.substring(l2.indexOf(":") + 1, l2.lastIndexOf(",")) + "            " + l2.substring(l2.indexOf(",")+1));
		b3.setText(l3.substring(l3.indexOf(""), l3.lastIndexOf(":")) + "               " + l3.substring(l3.indexOf(":") + 1, l3.lastIndexOf(",")) + "            " + l3.substring(l3.indexOf(",")+1));
		
		return comp;
	}
	
	
	public JLabel showMes() {
		JLabel lb = new JLabel("Não tem dado Suficiente");
		lb.setFont(new Font("Arial",Font.BOLD,30));
		lb.setBounds(125,0,400,300);
		lb.setForeground(Color.BLACK);
		return lb;
	}

}
