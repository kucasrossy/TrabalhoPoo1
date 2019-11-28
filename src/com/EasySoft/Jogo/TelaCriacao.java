package com.EasySoft.Jogo;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TelaCriacao extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btn;
	private JLabel lb;
	private JTextField txtField; 
	
	TelaCriacao(){
		this.setSize(500,300);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(new Color(13, 33, 101));
		this.setLayout(null);
		this.add(img());
		this.add(initLabel());
		this.add(initTextField());
		this.add(initButton());
		this.setVisible(true);
	}
	
	private Component img() {
		ImageIcon img = new ImageIcon(getClass().getResource("/nick.gif"));
		JLabel i = new JLabel(img);
		i.setBounds(150,25,200,150);
		i.setBackground(new Color(13, 33, 101));
		return i;
	}

	private JLabel initLabel() {
		lb = new JLabel("Digite aqui o seu NickName");
		lb.setBounds(115,-10,275,50);
		lb.setFont(new Font("Arial",Font.BOLD,20));
		lb.setForeground(Color.WHITE);
		return lb;
	}
	
	private JTextField initTextField() {
		txtField = new JTextField();
		txtField.setFont(new Font("Arial",Font.BOLD,20));
		txtField.setHorizontalAlignment(JTextField.CENTER);
		txtField.setBounds(150,170, 200, 35);
		return txtField;
	}
	
	private JButton initButton() {
		btn = new JButton();
		btn.setFont(new Font("Arial",Font.ITALIC,16));
		btn.setText("Jogar");
		btn.setBounds(200, 220, 100, 25);
		btn.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK, 2));
		btn.setBackground(new Color(252, 34, 253));
		btn.setForeground(Color.WHITE);
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(txtField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Você deve colocar o seu NickName");
				}else {
					Jogador a = new Jogador();
					a.setName(txtField.getText());
					System.out.println("Jogador Criado");
					new Game(a).Jogar();
					dispose();
				}
			}
			
		});
		
		return btn;
	}
	
}
