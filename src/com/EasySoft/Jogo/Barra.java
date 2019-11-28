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
	private boolean isRunning = true;
	private boolean click = false;
	
	Barra(TelaJogo a){
		this.setBackground(new Color(252, 34, 253));
		start();
		this.a = a;
	}

	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
	}
	
	double getCont() {
		return contador;
	}

	@Override
	public void run() {
		while(isRunning){
			this.setSize((int)(3.5 * contador), 10);
			contador--;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(contador <0) {
				isRunning = false;
			}
		}
		
		if(isRunning == false && click == false) {
			a.addCont();
			a.dispose();
			a.setJogar();
		}
	}

	void tick() {
		System.out.println(contador);		
	}

	public void click() {
		isRunning = false;
		click = true;
	}
	
	
}

