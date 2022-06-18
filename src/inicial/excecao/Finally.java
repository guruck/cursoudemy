package inicial.excecao;

import java.util.Scanner;

public class Finally {

	public static void main(String[] args) {
	
		Scanner entrada = new Scanner(System.in);
		try {
			System.out.print("Digite um numero inteiro: ");
			System.out.println(7/entrada.nextInt());
		} catch (OutOfMemoryError | ArithmeticException e) {
			System.out.println(e.getMessage());
		} finally{
			System.out.println("Processo final... #1 ");
			// entrada.close();
		}
		try {
			System.out.print("Digite um numero inteiro: ");
			System.out.println(7/entrada.nextInt());
		} finally{
			System.out.println("Processo final... #2 ");
			entrada.close();
		}	
		System.out.println("Fim :)!");
		
	}
}
