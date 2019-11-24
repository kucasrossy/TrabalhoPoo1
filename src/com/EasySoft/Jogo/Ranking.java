package com.EasySoft.Jogo;

public class Ranking {
	public static String[] rank(int tam) {
		int linhas = Integer.parseInt(Arquivos.read("pontuacao.txt", true));
		String dados = Arquivos.read("pontuacao.txt", false);
		String[] rankDados = new String[linhas];
		rankDados = dados.split(";");
		String aux = "";
		for(int i = 0; i<linhas;i++) {
			for(int j = 0; j<linhas-1;j++) {
				if((Double.parseDouble(rankDados[j].substring(rankDados[j].indexOf(":")+1, rankDados[j].lastIndexOf(",")))) < 
				   (Double.parseDouble(rankDados[j+1].substring(rankDados[j+1].indexOf(":")+1, rankDados[j+1].lastIndexOf(","))))) 
				{
					aux = rankDados[j];
	                rankDados[j] = rankDados[j+1];
	                rankDados[j+1] = aux;
				}
			}
		}
		
		String[] top = new String[tam];
		for(int i =0; i<tam;i++) {
			top[i] = rankDados[i];
		}
		
		return top;
	}
	
	
}
