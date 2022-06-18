
package inicial.fundamentos;

import java.util.Scanner;

public class EstruturasControle {
	public static void main(String[] args) {

		// IF / ELSE IF / ELSE---------------------
		Scanner entrada = new Scanner(System.in);
		System.out.println("informa a média: ");
		Double media = entrada.nextDouble();

		if (media <= 10.0 && media >= 7.0) {
			System.out.println("Aprovado\nParabéns!!");
		} else if (media < 7.0 && media >= 5.0) {
			System.out.println("Recuperação!!");
		} else {
			System.out.println("Reprovado!!");
		}
		entrada.close();

		// while---------------------
		Integer num = 0;
		while(num < 5) {
			System.out.println("While" + num++);
		}
		
		// for---------------------
		for (int cont = 0; cont <=5; cont++) {
			if (cont % 2 == 1)continue;
			System.out.println("For" + cont);
		}
		for (String v = "#"; !v.equals("####"); v+="#") {
			System.out.println(v);
		}
		externo:
		for (int i = 0; i <5; i++) {
			for (int j = 0; j <3; j++) {
				if (i==1)continue externo;
				if (i==2)break ;
				if (i==4)break externo;
				System.out.printf("[%d %d]", i, j);
			}
			System.out.println();
		}
		System.out.println("fim For Rotulado");

		// Do / while---------------------
		 do{
			System.out.println("doWhile" + num--);
		}while(num > 0);
		 
		// switch---------------------
		 String faixa = "preta";
		 switch(faixa.toLowerCase()) {
		 	case "preta":
		 		System.out.println("Bassai-Dai...");
		 	case "marrom":
		 		System.out.println("Tekki Shodan...");
		 	case "roxa":
		 		System.out.println("Heian Godan...");
		 	case "verde":
		 		System.out.println("Heian Yodan...");
		 	case "laranja":
		 		System.out.println("Heian Sandan...");
		 	case "vermelha":
		 		System.out.println("Heian Nidan...");
		 	case "amarela":
		 		System.out.println("Heian Shodan...");
		 		break;
		 	default:
		 		System.out.println("não sei mais nada....");
		 }
		 
		 
	}

}
