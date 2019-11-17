package com.EasySoft.Jogo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Arquivos {
	public static String read(String caminho) {
		String cont = "";
		try {
			FileReader arq = new FileReader(caminho);
			BufferedReader lerArq = new BufferedReader(arq);
			try {
				String linha = lerArq.readLine();
				while(linha!=null) {
					cont+=linha + "\n";
					linha = lerArq.readLine();
				}
				arq.close();
			}catch(IOException ex) {
				return ex.getMessage();
			}
			
		}catch(FileNotFoundException ex) {
			return ex.getMessage();
		}
		
	   return cont;
	}
	
	public static boolean write(String caminho,String texto) {
		try {
			FileWriter arq = new FileWriter(caminho,true);
			PrintWriter gravarArq = new PrintWriter(arq);
			gravarArq.println(texto);
			gravarArq.close();
			return true;
		}catch(IOException ex) {
			return false;
		}
	}
	
	public static String readPerg(String path,int i) {
		try {
			List<String> listPerg = Files.readAllLines(Paths.get(path));
			String linhaPerg = listPerg.get(i);
			return linhaPerg;
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}
}