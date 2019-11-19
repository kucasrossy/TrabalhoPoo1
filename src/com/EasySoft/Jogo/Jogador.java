package com.EasySoft.Jogo;


public class Jogador {
	private String nome;
	float pont = 0;
	
	void Setpont(double pont) {
		this.pont+= pont;
	}
	
	void setName(String nome) {
		this.nome = nome;
	}
	
	void salvarPont() {
		String texto = nome + ":" + pont + ";";
		Arquivos.write("pontuacao.txt", texto);
	}
}
