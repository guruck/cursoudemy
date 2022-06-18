package inicial.fundamentos;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author guruck - guruck@gmail.com
 * @since JDK12.0
 *
 */
public class PrimeiroPrograma {
	/**
	 * @param args - argumentos da função padrão main
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		//sentença de codigo termina sempre com ;
		/*
		 * comentario de multipla linha
		 */
		System.out.println("Primeiro Programa");
		double raio = 3.4;			//variavel
		final double PI = 3.141516; //constante
		
		double area = PI * raio * raio;
		System.out.println("Area = " + area );
		//---------------------------------------
		final double FATOR = 5.0 / 9.0;
		final double AJUSTE = 32;
		
		double fahrenheit = 86;
		double celsius = (fahrenheit - AJUSTE) * FATOR;
		System.out.println("O valor de " + fahrenheit + "ºF em Celsius é: " + celsius + "ºC.");
		
		//---------------------------------------
		//inferencia a partir do JAVA10
		var a = 4.5;
		Object tipo = a;
		System.out.println( tipo.getClass().getSimpleName() );
		
		//Primitivos:---------------------------------------
		//conversões do menor para o maior (implicita), são mais tranquilos de fazer, pois o "tipo maior suporta o menor... do maior pro menor é explicita"
		byte b = -56; 				// 8bits => -128 a 127
		short s = 542; 				// 2bytes
		int i = 56789;				// 4bytes - default
		long l = 3_134_845_223L;	// 8bytes
		float f = 11_445.44F;		// 4bytes
		double d = 2_991_797.01;	// 8bytes - default
		char c = '\u0010';			// 1 caractere
		boolean bl = true;			// false ou true
		
		/*
		 * 1100 1000 (-56)
		 * &
		 * 1111 1111 (the 0xFF)
		 * =======================================
		 * 1100 1000 (200)
		 */
		System.out.println(b); //print -56, 
		System.out.println(b & 0xFF); //print 200, *unsigned*
		
		//Notacao ponto (.):---------------------------------------
		//não existe metodos em primitivos, so sendo possivel o ponto em não primitivos.
		String y = "Bom dia X"
				.replace("X","Guruck")
				.toUpperCase()
				.concat("!!!");
		System.out.println(y);
		
		//import:---------------------------------------
		Date dateNow = new Date();
		System.out.println(dateNow);
		
		//String:---------------------------------------
		String frase = String.format("Teste R$%.2f", f);
		System.out.println(frase + " : " + frase.length());
		Scanner stext = new Scanner(System.in);
		String teste = stext.nextLine(); //pega a linha literal
		String teste2 = stext.next(); //pega a linha removendo espaços a direita e esquerda
		System.out.println(teste);
		stext.close();
		
		//Wrapers: Classe que envolve um tipo primitivo.
		Byte b2 = -56; 				// 8bits => -128 a 127
		Short s2 = 542; 			// 2bytes
		Integer i2 = 56789;			// 4bytes - default
		Long l2 = 3_134_845_223L;	// 8bytes
		Float f2 = 11_445.44F;		// 4bytes
		Double d2 = 2_991_797.01;	// 8bytes - default
		Character c2 = '\u0010';	// 1 caractere
		Boolean b3 = true;			// false ou true
		
		/*
		* Operadores---------------------
		*Precedência | Operador   | Tipo                                | Associatividade
		*-------------------------------------------------------------------------------------
		*15          | ()         | Parentesis                          | Esquerda p/ Direita
		*            | []         | Seleção em array                    |
		*            | ·          | Seleção de membros                  |
		*-------------------------------------------------------------------------------------
		*14          | ++         | Incremento pós­fixado               | Direita p/ Esquerda
		*            | ­­         | Decremento pós­fixado               |
		*-------------------------------------------------------------------------------------
		*13          | ++         | Incremento pré­fixado               | Direita p/ Esquerda
		*            | ­­         | Decremento pré­fixado               |      
		*            | +          | Mais                                | 
		*            | ­          | Menos                               | 
		*            | !          | Negação lógica                      | 
		*            | ~          | Complemento binário                 | 
		*            | ( type )   | Conversão explícita (cast)          | 
		*-------------------------------------------------------------------------------------
		*12          | *          | Multiplicação                       | Esquerda p/ Direita
		*            | /          | Divisão                             | 
		*            | %          | Módulo                              | 
		*-------------------------------------------------------------------------------------
		*11          | +          | Adição                              | Esquerda p/ Direita
		*            | ­          | Subtração                           | 
		*-------------------------------------------------------------------------------------
		*10          | <<         | Deslocamento aritmético p/ esquerda | Esquerda p/ Direita
		*            | >>         | Deslocamento aritmético p/ direita  | 
		*            | >>>        | Deslocamento lógico p/ direita      | 
		*-------------------------------------------------------------------------------------
		*9           | <          | Menor que                           | Esquerda p/ Direita
		*            | <=         | Menor que ou igual                  | 
		*            | >          | Maior que                           | 
		*            | >=         | Maior que ou igual                  | 
		*            | instanceof | Comparação de tipos (objects only)  | 
		*-------------------------------------------------------------------------------------
		*8           | ==         | Igualdade                           | Esquerda p/ Direita
		*            | !=         | Desigualdade                        | 
		*-------------------------------------------------------------------------------------
		*7           | &          | E lógico (bit a bit)                | Esquerda p/ Direita
		*-------------------------------------------------------------------------------------
		*6           | ^          | Ou exclusivo (bit a bit)            | Esquerda p/ Direita
		*-------------------------------------------------------------------------------------
		*5           | |          | Ou lógico(bit a bit)                | Esquerda p/ Direita
		*-------------------------------------------------------------------------------------
		*4           | &&         | E lógico                            | Esquerda p/ Direita
		*-------------------------------------------------------------------------------------
		*3           | ||         | Ou lógico                           | Esquerda p/ Direita
		*-------------------------------------------------------------------------------------
		*2           | ?:         | Condição ternária                   | Direita p/ Esquerda
		*-------------------------------------------------------------------------------------
		*1           | =          | Atribuição                          | Direita p/ Esquerda
		*            | +=         | Atribuição aditiva                  | 
		*            | ­=         | Atribuição de subtração             | 
		*            | *=         | Atribuição de multiplicação         | 
		*            | /=         | Atribuição de divisão               | 
		*            | %=         | Atribuição de módulo                | 
		*
		*/

		
	}
}
