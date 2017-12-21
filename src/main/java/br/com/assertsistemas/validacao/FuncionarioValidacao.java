package br.com.assertsistemas.validacao;

import javax.swing.JOptionPane;

import org.apache.commons.lang.math.NumberUtils;

public class FuncionarioValidacao {

	public static void main(String[] args) {
		//System.out.println(new ClienteValidacao().validaNomeEsobrenome(""));
	}
	
//	public String tentandoNomeEsobrenome(){
//		String a = JOptionPane.showInputDialog("Digite seu nome:");
//		String b = JOptionPane.showInputDialog("Digite seu sobrenome:");
//		if (this.isValidNomeEsobrenome(a) && (this.isValidNomeEsobrenome(b))) {
//			return a+b;
//		} else { 
//			return this.repeticao(); 
//			}
//	}
	
	public String repeticao(String key){
		int tentando = 0;
		while (tentando < 5) {
			tentando++;
			JOptionPane.showInputDialog("Erro no sistema.");
			String sair = JOptionPane.showInputDialog("Sair do programa? S/N");
			sair = sair.toUpperCase();
			
			if (sair.contains("S")) {
				System.exit(0);
			}
			
			String parse = this.createParseInputMessage(key);
			if(parse != null && parse.isEmpty() == false){
				return parse;
			}
			
			if (tentando == 2) {
				JOptionPane.showInputDialog("Você tem apenas mais uma tentativa antes do bloqueio.");
			}
			
			if (tentando == 3) {
				JOptionPane.showInputDialog("Sistema bloqueado por 10 segundos.");
				this.Sleep(10000);
			}
			
			if (tentando == 4) {
				JOptionPane.showInputDialog("Sistema bloqueado por 20 segundos.");
				this.Sleep(20000);
			}
			
			if (tentando == 5) {
				JOptionPane.showInputDialog("Sistema encerrado.");
				System.exit(0);			
			}		
		}
		
		return null;
	}

	private String createParseInputMessage(String key){
		String value = "";
		switch (key) {
		case "nome":
			value = JOptionPane.showInputDialog("Insira Nome:");
			if(isValidNomeEsobrenome(value)){
				return value;
			}
			break;
		case "sobrenome":
			value = JOptionPane.showInputDialog("Insira sobrenome:");
			if(isValidNomeEsobrenome(value)){
				return value;
			}
			break;
		case "sexo":
			value = JOptionPane.showInputDialog("Insira sexo:");
			if(validChar(value)){
				return value;
			}
			break;
		case "idade":
			value = JOptionPane.showInputDialog("Insira idade:");
			if (validInt(value)){
				return value;
			}
			break;
		case "cpf":
			value = JOptionPane.showInputDialog("Insira CPF:");
			if (validCPF(value)){
				return value;
			}
		case "salario":
			value = JOptionPane.showInputDialog("Insira salário:");
			if (validDouble(value)) {
				return value;
			}
		default:
			break;
		}
		
		return null;
	}
	
	public void Sleep(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	} 
	
	public boolean validCPF (String i) {
		try{
			String parseValue = i.replaceAll("\\/", "").replaceAll("\\.", "");
			return (parseValue.length() == 11) ? true : false;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean isValidNomeEsobrenome(String value) {
		if(value == null || value.isEmpty() == true){
			return false;
		}
		
		char[] numeros = "1,2,3,4,5,6,7,8,9,0".toCharArray();
		char[] values = value.toCharArray();
		
		for (int i = 0; i < values.length; i++) {
			char caracter = values[i];
			
			for (int j = 0; j < numeros.length; j++) {
				if(caracter == numeros[j]){
					return false;
				}
			}
		}
		
		return true;
	}
	
	public boolean validInt (String i) {
		return NumberUtils.isNumber(i);
	}
	
	public boolean validLong (String i) {
		return NumberUtils.isNumber(i);
	}
	
	public boolean validChar(String i) {
		int tamanho = i.length();
		String sexo = i.toLowerCase();

		if(tamanho == 1){
			if(sexo.contains("m") || sexo.contains("f")){
				return true;
			}else{
				return false;
			}
		} else {
			return false;
		}
	}
	
	public boolean validDouble (String i) {
		try{
			String parseValue = i.replaceAll("\\,", ".");
			Double.valueOf(parseValue);
			if (parseValue.contains(".")) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return (false);
		}
	}
		
	}
	
