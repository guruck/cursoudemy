package inicial.streams;

import java.util.function.Consumer;
import java.util.function.Function;

public class Media {

	private double total;
	private int quantidade;
	
	public Media adiciona(double valor) {
		this.total += valor;
		this.quantidade++;
		return this;
	}
	
	public Double getMedia() {
//		return Double.parseDouble(String.format("%.2f", (this.total / this.quantidade)));
		return this.total / this.quantidade;
	}
	
	public static Media combinar(Media m1, Media m2) {
		Media r = new Media();
//		r.adiciona(m1.getMedia());
//		r.adiciona(m2.getMedia());
		r.total = m1.total + m2.total;
		r.quantidade = m1.quantidade + m2.quantidade;
		return r;
	}

	public void ifPresent(Consumer<Double> object) {
		Double value = this.getMedia();
        if (value != null) {
        	object.accept(value);
        }
	}

	public void ifPresent(Function<Double, String> formatar) {
		Double value = this.getMedia();
        if (value != null) {
        	System.out.println(formatar.apply(value));;
        }
		
	}
}
