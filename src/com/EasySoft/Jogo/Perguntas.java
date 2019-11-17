package com.EasySoft.Jogo;

public class Perguntas {
	private String imgPath;
	private String perg;
	private String[] op = new String[4];
	private String resp;
	
	boolean compResp(String resp) {
		if(resp==this.resp) {
			return true;
		}else {
			return false;
		}
	}
	
	Perguntas(int i){
		String[] listDados = new String[7];
		String dados = Arquivos.readPerg("Perguntas.txt", i);
		listDados = dados.split(";");
		imgPath = listDados[0];
		perg = listDados[1];
		for(int j = 2; j<6;j++) {
			op[j-2] = listDados[j];
		}
		resp = listDados[6];
	}
	
	String getImagen() {
		return this.imgPath;
	}
	
	String getOp(int i) {
		return this.op[i];
	}
	
	String getPergunta() {
		return this.perg;
	}
	
	char getResp() {
		return resp.charAt(0);
	}
}
