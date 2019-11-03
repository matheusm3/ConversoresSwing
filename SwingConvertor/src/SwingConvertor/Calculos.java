package SwingConvertor;

import javax.swing.JOptionPane;

public class Calculos {
	
	static String resultadomoeda;
	static String resultadotemp;
	static String resultadocompr;
	
	
	public static String getMoeda(String metodo1, String metodo2, String num) {

		String texto_numero = num.replaceAll( "," , "." );
		double numero = Double.parseDouble( texto_numero );

		double result = 0;
		
		if (metodo1 == "Real" && metodo2 == "Dólar") {
			result = numero / 4 ;
		}

		if (metodo1 == "Dólar" && metodo2 == "Real") {
			result = numero * 4 ;
		}
		
		else {
			result = numero ;
		}
		
		String retorno = Double.toString(result);
		setResultadomoeda(retorno);
		
		return retorno;
		
	}
	
	public static String getComprimento(String metodo1, String metodo2, String num) {

		String texto_numero = num.replaceAll( "," , "." );
		double numero = Double.parseDouble( texto_numero );

		double result = 0;
		
		if (metodo1 == "Metro" && metodo2 == "Centímetro") {
			result = numero * 100;
		}

		if (metodo1 == "Centímetro" && metodo2 == "Metro") {
			result = numero / 100;
		}
		
		if (metodo1 == "Centímetro" && metodo2 == "Milímetro") {
			result = numero * 10;
		}

		if (metodo1 == "Milímetro" && metodo2 == "Centímetro") {
			result = numero / 10;
		}

		if (metodo1 == "Metro" && metodo2 == "Milímetro") {
			result = numero * 1000;
		}

		if (metodo1 == "Milímetro" && metodo2 == "Metro") {
			result = numero / 1000;
		}
		
		String retorno = Double.toString(result);
		setResultadotemp(retorno);
		
		return retorno;
		
	}
	

	public static String getTemperatura(String metodo1, String metodo2, String num) {

		String texto_numero = num.replaceAll( "," , "." );
		double numero = Double.parseDouble( texto_numero );

		double result = 0;
		
		if (metodo1 == "Fahrenheit" && metodo2 == "Celsius") {
			result = (numero - 32) / 1.8000;
		}

		if (metodo1 == "Celsius" && metodo2 == "Fahrenheit") {
			result = (1.8 * numero) + 32 ;
		}
		
		if(metodo1 == "Kelvin" && metodo2 == "Celsius") {
			result = numero - 273.15;
		}
		
		if(metodo1 == "Celsius" && metodo2 == "Kelvin") {
			result = numero + 273.15;
		}

		if(metodo1 == "Fahrenheit" && metodo2 == "Kelvin") {
			result = ((numero - 32) / 1.8000) - 273.15;
		}
		
		if(metodo1 == "Kelvin" && metodo2 == "Fahrenheit") {
			result = (numero - 273.15)* 1.8000 + 32.00;
		}
		
		String retorno = Double.toString(result);
		setResultadotemp(retorno);
		
		return retorno;
		
	}

	public static String getResultadomoeda() {
		return resultadomoeda;
	}
	
	public static void setResultadomoeda(String resultadomoeda) {
		Calculos.resultadomoeda = resultadomoeda;
	}

	public static String getResultadotemp() {
		return resultadotemp;
	}

	public static void setResultadotemp(String resultadotemp) {
		Calculos.resultadotemp = resultadotemp;
	}

	public static String getResultadocompr() {
		return resultadocompr;
	}

	public static void setResultadocompr(String resultadocompr) {
		Calculos.resultadocompr = resultadocompr;
	}


}