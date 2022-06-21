package padroes.observer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Porteiro extends Thread{

	private List<ObservadorChegadadAniversariante> observadores = new ArrayList<>();;
	
	public void registrarObservador(ObservadorChegadadAniversariante observador) {
			this.observadores.add(observador);
	}
	
	@SuppressWarnings("resource")
	@Override
	public void run() {
		Scanner scanner = new Scanner(System.in);
		
		String valor = "";
		while(!"sair".equalsIgnoreCase(valor)) {
			System.out.print("Aniversariante Chegou?");
			valor = scanner.nextLine();
			
			if ("sim".equalsIgnoreCase(valor)) {
				EventoChegadadAniversariante evento = new EventoChegadadAniversariante(new Date());		
//				for(ObservadorChegadadAniversariante observador: this.observadores) {observador.chegou(evento);}
				observadores.stream().forEach(obs -> obs.chegou(evento));
				valor = "sair";
			}else {
				System.out.println("Alarme Falso!");
			}
		}
	}
}
