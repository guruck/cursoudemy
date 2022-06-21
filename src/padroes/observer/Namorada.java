package padroes.observer;

public class Namorada implements ObservadorChegadadAniversariante {

	@Override
	public void chegou(EventoChegadadAniversariante evento) {
		System.out.println("Apagar as Luzes...");
		System.out.println("Fazer silêncio...");
		System.out.println("Esperar um pouco...");
		System.out.println("Gritar SURPRESA!!!!!!!!!!!");
	}

}
