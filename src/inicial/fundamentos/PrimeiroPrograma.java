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
	 * @param args - argumentos da fun��o padr�o main
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		//senten�a de codigo termina sempre com ;
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
		System.out.println("O valor de " + fahrenheit + "�F em Celsius �: " + celsius + "�C.");
		
		//---------------------------------------
		//inferencia a partir do JAVA10
		var a = 4.5;
		Object tipo = a;
		System.out.println( tipo.getClass().getSimpleName() );
		
		//Primitivos:---------------------------------------
		//convers�es do menor para o maior (implicita), s�o mais tranquilos de fazer, pois o "tipo maior suporta o menor... do maior pro menor � explicita"
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
		//n�o existe metodos em primitivos, so sendo possivel o ponto em n�o primitivos.
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
		String teste2 = stext.next(); //pega a linha removendo espa�os a direita e esquerda
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
		*Preced�ncia | Operador   | Tipo                                | Associatividade
		*-------------------------------------------------------------------------------------
		*15          | ()         | Parentesis                          | Esquerda p/ Direita
		*            | []         | Sele��o em array                    |
		*            | �          | Sele��o de membros                  |
		*-------------------------------------------------------------------------------------
		*14          | ++         | Incremento p�s�fixado               | Direita p/ Esquerda
		*            | ��         | Decremento p�s�fixado               |
		*-------------------------------------------------------------------------------------
		*13          | ++         | Incremento pr�fixado               | Direita p/ Esquerda
		*            | ��         | Decremento pr�fixado               |      
		*            | +          | Mais                                | 
		*            | �          | Menos                               | 
		*            | !          | Nega��o l�gica                      | 
		*            | ~          | Complemento bin�rio                 | 
		*            | ( type )   | Convers�o expl�cita (cast)          | 
		*-------------------------------------------------------------------------------------
		*12          | *          | Multiplica��o                       | Esquerda p/ Direita
		*            | /          | Divis�o                             | 
		*            | %          | M�dulo                              | 
		*-------------------------------------------------------------------------------------
		*11          | +          | Adi��o                              | Esquerda p/ Direita
		*            | �          | Subtra��o                           | 
		*-------------------------------------------------------------------------------------
		*10          | <<         | Deslocamento aritm�tico p/ esquerda | Esquerda p/ Direita
		*            | >>         | Deslocamento aritm�tico p/ direita  | 
		*            | >>>        | Deslocamento l�gico p/ direita      | 
		*-------------------------------------------------------------------------------------
		*9           | <          | Menor que                           | Esquerda p/ Direita
		*            | <=         | Menor que ou igual                  | 
		*            | >          | Maior que                           | 
		*            | >=         | Maior que ou igual                  | 
		*            | instanceof | Compara��o de tipos (objects only)  | 
		*-------------------------------------------------------------------------------------
		*8           | ==         | Igualdade                           | Esquerda p/ Direita
		*            | !=         | Desigualdade                        | 
		*-------------------------------------------------------------------------------------
		*7           | &          | E l�gico (bit a bit)                | Esquerda p/ Direita
		*-------------------------------------------------------------------------------------
		*6           | ^          | Ou exclusivo (bit a bit)            | Esquerda p/ Direita
		*-------------------------------------------------------------------------------------
		*5           | |          | Ou l�gico(bit a bit)                | Esquerda p/ Direita
		*-------------------------------------------------------------------------------------
		*4           | &&         | E l�gico                            | Esquerda p/ Direita
		*-------------------------------------------------------------------------------------
		*3           | ||         | Ou l�gico                           | Esquerda p/ Direita
		*-------------------------------------------------------------------------------------
		*2           | ?:         | Condi��o tern�ria                   | Direita p/ Esquerda
		*-------------------------------------------------------------------------------------
		*1           | =          | Atribui��o                          | Direita p/ Esquerda
		*            | +=         | Atribui��o aditiva                  | 
		*            | �=         | Atribui��o de subtra��o             | 
		*            | *=         | Atribui��o de multiplica��o         | 
		*            | /=         | Atribui��o de divis�o               | 
		*            | %=         | Atribui��o de m�dulo                | 
		*
		*/

		
	}
}
