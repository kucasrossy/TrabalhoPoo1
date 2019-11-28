package com.EasySoft.Jogo;

import java.io.File;

import jaco.mp3.player.MP3Player;

public class Audio {
	
	static MP3Player p;
	
	public static void play(String caminho) {
		p = new MP3Player(new File(caminho));
		p.play();
		p.setRepeat(true);
	}
	
	public static void click() {
		MP3Player c = new MP3Player(new File("c1.mp3"));
		c.play();
	}
	
	public static void stop() {
		p.stop();
	}
	
	
}
