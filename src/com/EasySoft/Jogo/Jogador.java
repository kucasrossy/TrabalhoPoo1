package com.EasySoft.Jogo;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Jogador {
	private String nome;
	private float pont = 0;
	Date data_jog;
	
	void Setpont(double pont) {
		this.pont+= pont;
	}
	
	void setName(String nome) {
		this.nome = nome;
	}
	
	void salvarPont() {
		data_jog = new Date(System.currentTimeMillis());
		SimpleDateFormat formData = new SimpleDateFormat("dd-MM-yyyy");
		String texto = nome + ":" + pont + "," + formData.format(data_jog) + ";" ;
		Arquivos.write("pontuacao.txt", texto);
	}
}
