package com.EasySoft.Jogo;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		this.setSize(500,250);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.add(initLabel());
		this.add(initTextField());
		this.add(initButton());
		this.setVisible(true);
	}
	
	private JLabel initLabel() {
		lb = new JLabel("Digite aqui o seu NickName");
		lb.setBounds(115,-10,275,50);
		lb.setFont(new Font("Arial",Font.BOLD,20));
		return lb;
	}
	
	private JTextField initTextField() {
		txtField = new JTextField();
		txtField.setFont(new Font("Arial",Font.BOLD,20));
		txtField.setHorizontalAlignment(JTextField.CENTER);
		txtField.setBounds(150,80, 200, 35);
		return txtField;
	}
	
	private JButton initButton() {
		btn = new JButton();
		btn.setFont(new Font("Arial",Font.ITALIC,16));
		btn.setText("Jogar");
		btn.setBounds(200, 180, 100, 50);
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(txtField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Você deve colocar o seu NickName");
				}else {
					Jogador a = new Jogador();
					a.setName(txtField.getText());
					System.out.println("Jogador Criado");
					new Game().Jogar();
					dispose();
				}
			}
			
		});
		
		return btn;
	}
	
}
