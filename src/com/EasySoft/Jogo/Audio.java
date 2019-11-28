package com.EasySoft.Jogo;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;

public class Audio implements Runnable {
	public void play(String path) throws LineUnavailableException, UnsupportedAudioFileException, IOException {
		File fil = new File(path);
		Clip oClip = AudioSystem.getClip();
		AudioInputStream oStream = AudioSystem.getAudioInputStream(fil);
		oClip.open(oStream);
		oClip.loop(Clip.LOOP_CONTINUOUSLY);
	}

	@Override
	public void run() {
		JFrame teste = new JFrame("Teste");
		teste.setVisible(true);
		
	}
	
	
}
