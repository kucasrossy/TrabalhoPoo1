package com.EasySoft.Jogo;


import java.awt.Color;

import javax.swing.JPanel;

import com.EasySoft.Jogo.Game.TelaJogo;

public class Barra extends JPanel implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double contador = 140;
	private Thread thread;
	TelaJogo a;
	
	Barra(TelaJogo a){
		this.setBackground(Color.RED);
		start();
		this.a = a;
	}

	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
		do {
			this.setSize((int)(3.5 * contador), 10);
			contador--;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}while(contador > -1);
		
		a.dispose();
	}
	
}

